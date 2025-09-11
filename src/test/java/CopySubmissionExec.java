import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.CopySubmission;
import RequestSpecifier.CopySubmissionSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class CopySubmissionExec {

    public void ExecCopySubmission(Map<String,String> map, String SubID){

        SoftAssert softAssert = new SoftAssert();

        String CopySubmissionRequest = CopySubmission.copySubmissionRequest(SubID);
        String CopySubmissionResponse;

        RequestSaver.saveRequest(map.get("Iteration"),CopySubmissionRequest,"CopySubmission Request");
        Response response = RestAssured.given().spec(CopySubmissionSpec.SpecCopySubmission(SubID)).when().post();

        CopySubmissionResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),CopySubmissionResponse,"CopySubmission Response");

        softAssert.assertEquals(response.statusCode(),200,"Status code mismatch");

    }
}
