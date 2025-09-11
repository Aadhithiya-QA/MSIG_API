import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.FindSubmission;
import RequestSpecifier.FindSubmissionSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class FindSubmissionExec {

    public void ExecFindSubmission(String SubNumber, Map<String,String> map){

        String FindSubmissionRequest = FindSubmission.findSubmissionRequest(SubNumber);
        String FindSubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),FindSubmissionRequest,"FindSubmission Request");
        Response response = RestAssured.given().spec(FindSubmissionSpec.SpecFindSubmission(SubNumber)).when().post();

        FindSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),FindSubmissionResponse,"FindSubmission Response");

    }

}
