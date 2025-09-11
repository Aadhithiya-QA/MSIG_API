import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.ReferSubmission;
import RequestSpecifier.ReferSubmissionSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ReferSubmissionExec {

    public void ExecReferSubmission(Map<String,String> map,String SubID){

        String ReferSubmissionRequest = ReferSubmission.referSubmissionRequest(SubID);
        String ReferSubmissionResponse ;

        RequestSaver.saveRequest(map.get("Iteration"),ReferSubmissionRequest,"ReferSubmission Request");
        Response response = RestAssured.given().spec(ReferSubmissionSpec.SpecReferSubmission(SubID)).when().post();

        ReferSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),ReferSubmissionResponse,"ReferSubmission Response");

    }

}
