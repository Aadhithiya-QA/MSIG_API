import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.SaveSubmission;
import RequestSpecifier.SaveSubmissionSpec;
import Utilities.PropertyUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class SaveSubmissionExec {

    /*public void ExecSaveSubmission(Map<String,String>map){

        String SaveSubmissionRequest = SaveSubmission.saveSubmissionRequest();
        String SaveSubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),SaveSubmissionRequest,"SaveSubmission Request");
        Response response = RestAssured
                .given()
                .spec(SaveSubmissionSpec.SpecSaveSubmission())
                .when().post();

        SaveSubmissionResponse = response.then().extract().body().asPrettyString();

        ResponseSaver.saveResponse(map.get("Iteration"),SaveSubmissionResponse,"SaveSubmission Response");

    }*/

    public void  ExecSaveSubmission(Map<String, String> map ) {
        // --- Merge Excel Data + PropertyUtils ---
        Map<String, String> params = new HashMap<>(map);

        // Add values from property file (env/config)
        params.put("Token", PropertyUtils.getValue("Token"));
        params.put("OwnerId", PropertyUtils.getValue("OwnerId"));
//        params.put("UserName", PropertyUtils.getValue("UserName"));
        params.put("ProductVerNumber", PropertyUtils.getValue("ProductVerNumber"));
        params.put("ProductNumber", PropertyUtils.getValue("ProductNumber"));
        params.put("PolicyEffectiveDate", PropertyUtils.getValue("PolicyEffectiveDate"));
        params.put("PolicyExpirationDate", PropertyUtils.getValue("PolicyExpirationDate"));

        // Build request body from template
        String SaveSubmissionRequest = SaveSubmission.buildRequest(params);
        String SaveSubmissionResponse;
//        System.out.println(SaveSubmissionRequest);
        RequestSaver.saveRequest(map.get("Iteration"),SaveSubmissionRequest,"SaveSubmission Request");
     // Build spec and execute
        Response response = RestAssured.given().spec(SaveSubmissionSpec.SpecSaveSubmission(params)).when().post();

        SaveSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),SaveSubmissionResponse,"SaveSubmission Response");

    }

}
