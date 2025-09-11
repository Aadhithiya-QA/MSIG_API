import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.GetSubmission;
import RequestSpecifier.GetSubmissionSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class GetSubmissionExec {

    public void ExecGetSubmission(String SubID, Map<String,String>map){

        String GetSubmissionRequest = GetSubmission.getSubmissionRequest(SubID);
        String GetSubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),GetSubmissionRequest,"GetSubmission Request");

        Response response = RestAssured
                .given().spec(GetSubmissionSpec.SpecGetSubmission(SubID)).when().post();

        GetSubmissionResponse = response.then().extract().body().asPrettyString();

        ResponseSaver.saveResponse(map.get("Iteration"),GetSubmissionResponse,"GetSubmission Response");

    }

}
