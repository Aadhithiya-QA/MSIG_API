import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.SaveSubmission;
import RequestSpecifier.SaveSubmissionSpec;
import Utilities.PropertyUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import DataProviderUtil.*;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class SaveSubmissionExec {

    public void ExecSaveSubmission(Map<String, Object> iterationData) {
        String iteration = String.valueOf(iterationData.get("Iteration"));

        Map<String, String> mergedParams = new HashMap<>();

        Object mainSheetObj = iterationData.get("Main");
        if (mainSheetObj instanceof Map) {
            mergedParams.putAll((Map<String, String>) mainSheetObj);
        }

        List<Map<String, String>> policySheet =
                (List<Map<String, String>>) iterationData.getOrDefault("Policy lvl", new ArrayList<>());
        List<Map<String, String>> locationSheet =
                (List<Map<String, String>>) iterationData.getOrDefault("Location lvl", new ArrayList<>());
        List<Map<String, String>> classificationSheet =
                (List<Map<String, String>>) iterationData.getOrDefault("Classification lvl", new ArrayList<>());

        // Add properties
        mergedParams.put("Token", PropertyUtils.getValue("Token"));
        mergedParams.put("OwnerId", PropertyUtils.getValue("OwnerId"));
        mergedParams.put("ProductVerNumber", PropertyUtils.getValue("ProductVerNumber"));
        mergedParams.put("ProductNumber", PropertyUtils.getValue("ProductNumber"));
        mergedParams.put("AgencyId",PropertyUtils.getValue("AgencyId"));
        mergedParams.put("AgentId",PropertyUtils.getValue("AgentId"));

//        System.out.println("📝 Raw mergedParams keys = " + mergedParams.keySet());

        // --- Remap to JSON placeholders ---
        Map<String, String> mappedParams = ExcelJsonMapper.remapParams(mergedParams);

//        System.out.println("✅ Final mappedParams keys = " + mappedParams.keySet());

        ExecSaveSubmission(iteration, mappedParams, policySheet, locationSheet, classificationSheet);
    }

    public void ExecSaveSubmission(String iteration,
                                   Map<String, String> mergedParams,
                                   List<Map<String, String>> policySheet,
                                   List<Map<String, String>> locationSheet,
                                   List<Map<String, String>> classificationSheet) {
        SoftAssert softAssert = new SoftAssert();

        String SaveSubmissionRequest = SaveSubmission.buildFinalRequest(
                iteration,
                mergedParams,
                policySheet,
                locationSheet,
                classificationSheet
        );

        RequestSaver.saveRequest(iteration, SaveSubmissionRequest, "SaveSubmission Request");

        Response response = RestAssured
                .given()
                .spec(SaveSubmissionSpec.SpecSaveSubmission(iteration,
                        mergedParams,
                        policySheet,
                        locationSheet,
                        classificationSheet))
                .body(SaveSubmissionRequest)
                .when()
                .post();

        String SaveSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(iteration, SaveSubmissionResponse, "SaveSubmission Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }
}
