import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.LapseandDeclineSubmission;
import RequestSpecifier.LapseandDeclineSubmissionSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class LapseandDeclineSubmissionExec {

    SoftAssert softAssert = new SoftAssert();

    public void ExecLapseSubmission(Map<String,String>map,String SubID){

        String LapseSubmissionRequest = LapseandDeclineSubmission.lapseSubmissionRequest(SubID);
        String LapseSubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),LapseSubmissionRequest,"LapseSubmission Request");
        Response response = RestAssured.given().spec(LapseandDeclineSubmissionSpec.SpecLapseSubmission(SubID)).when().post();

        LapseSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),LapseSubmissionResponse,"LapseSubmission Response");

        softAssert.assertEquals(response.statusCode(),200,"Status code mismatch");

    }

    public void ExecDeclineSubmission(Map<String,String>map,String SubID){

        String DeclineSubmissionRequest = LapseandDeclineSubmission.declineSubmissionRequest(SubID);
        String DeclineSubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),DeclineSubmissionRequest,"DeclineSubmission Request");
        Response response = RestAssured.given().spec(LapseandDeclineSubmissionSpec.SpecDeclineSubmission(SubID)).when().post();

        DeclineSubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),DeclineSubmissionResponse,"DeclineSubmission Response");

        softAssert.assertEquals(response.statusCode(),200,"Status code mismatch");

    }

}
