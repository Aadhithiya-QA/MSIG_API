import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.BindRequest;
import RequestBuilder.IssuePolicy;
import RequestSpecifier.BindRequestSpec;
import RequestSpecifier.IssuePolicySpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class IssuePolicyExec {

    public void exeIssuePolicy(String PolicyID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String IssuePolicyRequest = IssuePolicy.issuePolicyRequest(PolicyID,map);
        String IssuePolicyResponse;

        RequestSaver.saveRequest(map.get("Iteration"),IssuePolicyRequest,"IssuePolicy Request");
        Response response = RestAssured.given().spec(IssuePolicySpec.issuePolicySpec(PolicyID,map)).when().post();

        IssuePolicyResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),IssuePolicyResponse,"IssuePolicy Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
