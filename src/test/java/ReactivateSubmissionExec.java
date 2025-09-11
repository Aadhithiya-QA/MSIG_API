import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.ReactivateSubmission;
import RequestSpecifier.ReactivateSubmissionSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ReactivateSubmissionExec {

    public void ExecReactivateSubmission(Map<String,String>map,String SubID){

        String ReactivateSubmissionRequest = ReactivateSubmission.reactivateSubmissionRequest(SubID);
        String ReactivateSubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),ReactivateSubmissionRequest,"ReactivateSubmission Request");
        Response response = RestAssured.given().spec(ReactivateSubmissionSpec.SpecReactivateSubmission(SubID)).when().post();

        ReactivateSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),ReactivateSubmissionResponse,"ReactivateSubmission Response");

    }

}
