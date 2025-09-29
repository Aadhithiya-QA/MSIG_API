package RequestBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SaveSubmission {

    private static String loadTemplate(String fileName) {
        try (InputStream inputStream = SaveSubmission.class.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalStateException("Resource file not found: " + fileName);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load request template", e);
        }
    }

    // Build Classification object
    private static JSONObject buildClassification(Map<String, String> row) {
        JSONObject template = new JSONObject(loadTemplate("/Classification.json"));
        row.forEach((k, v) -> replaceRecursive(template, "${{" + k + "}}", safeValue(v)));
        return template;
    }

    private static JSONArray buildClassificationRequest(List<Map<String, String>> classificationList) {
        JSONArray arr = new JSONArray();
        for (Map<String, String> row : classificationList) {
            arr.put(buildClassification(row));
        }
        return arr;
    }

    // Build Location object
    private static JSONObject buildLocation(Map<String, String> row, List<Map<String,String>> classificationSheet, String iteration) {
        JSONObject template = new JSONObject(loadTemplate("/Location.json"));
        row.forEach((k, v) -> replaceRecursive(template, "${{" + k + "}}", safeValue(v)));

        // Nested classifications
        List<Map<String,String>> filtered = classificationSheet.stream()
                .filter(c -> iteration.equals(c.get("Iteration")))
                .collect(Collectors.toList());

        template.put("GeneralLiabilityClassification", buildClassificationRequest(filtered));
        return template;
    }

    private static JSONArray buildLocationArray(List<Map<String,String>> locationSheet,
                                                List<Map<String,String>> classificationSheet,
                                                String iteration) {
        List<Map<String,String>> filtered = locationSheet.stream()
                .filter(row -> iteration.equals(row.get("Iteration")))
                .collect(Collectors.toList());

        JSONArray arr = new JSONArray();
        for (Map<String,String> loc : filtered) {
            arr.put(buildLocation(loc, classificationSheet, iteration));
        }
        return arr;
    }

    // Build Policy object
    private static JSONObject buildPolicy(Map<String, String> row,
                                          List<Map<String,String>> locationSheet,
                                          List<Map<String,String>> classificationSheet,
                                          String iteration) {
        JSONObject template = new JSONObject(loadTemplate("/Policy.json"));
        row.forEach((k, v) -> replaceRecursive(template, "${{" + k + "}}", safeValue(v)));

        JSONArray locations = buildLocationArray(locationSheet, classificationSheet, iteration);
        template.put("GeneralLiabilityLocation", locations);

        return template;
    }

    private static JSONArray buildPolicyArray(List<Map<String,String>> policySheet,
                                              List<Map<String,String>> locationSheet,
                                              List<Map<String,String>> classificationSheet,
                                              String iteration) {
        List<Map<String,String>> filtered = policySheet.stream()
                .filter(row -> iteration.equals(row.get("Iteration")))
                .collect(Collectors.toList());

        JSONArray arr = new JSONArray();
        for (Map<String,String> policy : filtered) {
            arr.put(buildPolicy(policy, locationSheet, classificationSheet, iteration));
        }
        return arr;
    }

    // Helpers
    private static void replaceRecursive(Object obj, String placeholder, Object replacement) {
        if (obj instanceof JSONObject) {
            JSONObject json = (JSONObject) obj;
            for (String key : json.keySet()) {
                Object val = json.get(key);

                if (val instanceof String && val.equals(placeholder)) {
                    // ✅ Log what is being replaced
//                    System.out.println("Replacing placeholder: " + placeholder + " → " + replacement);

                    if (replacement instanceof JSONArray) {
                        json.put(key, (JSONArray) replacement);
                    } else if (replacement instanceof JSONObject) {
                        json.put(key, (JSONObject) replacement);
                    } else {
                        json.put(key, String.valueOf(replacement));
                    }
                } else {
                    replaceRecursive(val, placeholder, replacement);
                }
            }
        } else if (obj instanceof JSONArray) {
            JSONArray arr = (JSONArray) obj;
            for (int i = 0; i < arr.length(); i++) {
                Object val = arr.get(i);

                if (val instanceof String && val.equals(placeholder)) {
                    // ✅ Log what is being replaced
//                    System.out.println("Replacing placeholder: " + placeholder + " → " + replacement);

                    if (replacement instanceof JSONArray) {
                        arr.put(i, replacement);
                    } else if (replacement instanceof JSONObject) {
                        arr.put(i, replacement);
                    } else {
                        arr.put(i, String.valueOf(replacement));
                    }
                } else {
                    replaceRecursive(val, placeholder, replacement);
                }
            }
        }
    }

    private static String safeValue(String value) {
        return value == null ? "" : value;
    }

    // Entry point
    public static String buildFinalRequest(
            String iteration,
            Map<String, String> mainSheet,
            List<Map<String, String>> policySheet,
            List<Map<String, String>> locationSheet,
            List<Map<String, String>> classificationSheet) {

        // Load final skeleton (SaveSubmission.json)
        JSONObject requestJson = new JSONObject(loadTemplate("/SaveSubmission.json"));

        // Replace main sheet placeholders
        if (mainSheet != null) {
            mainSheet.forEach((k, v) -> {
                String placeholder = "${{" + k + "}}";
                replaceRecursive(requestJson, placeholder, safeValue(v));
            });
        }

        // Build full nested policy → location → classification hierarchy
        JSONArray policies = buildPolicyArray(policySheet, locationSheet, classificationSheet, iteration);

        // Replace placeholder with full JSON array
        replaceRecursive(requestJson, "${{Policy}}", policies);

        return requestJson.toString(2);
    }

}
