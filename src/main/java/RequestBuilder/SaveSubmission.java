package RequestBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SaveSubmission {

    private static final String REQUEST_FILE = "/SaveSubmission.json"; // keep template in resources

    private static String loadTemplate() {
        try (InputStream inputStream = SaveSubmission.class.getResourceAsStream(REQUEST_FILE)) {
            if (inputStream == null) {
                throw new IllegalStateException("Resource file not found: " + REQUEST_FILE);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load request template", e);
        }
    }

    public static String buildRequest(Map<String, String> params) {
        String template = loadTemplate();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            template = template.replace("${{" + entry.getKey() + "}}", entry.getValue());
        }
        return template;
    }

}
