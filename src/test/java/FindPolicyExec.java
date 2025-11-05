import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.FindPolicy;
import RequestSpecifier.FindPolicySpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class FindPolicyExec {

    public void exeFindPolicy(String QuoteNumber, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String FindPolicyRequest = FindPolicy.findPolicyRequest(QuoteNumber);
        String FindPolicyResponse;

        RequestSaver.saveRequest(map.get("Iteration"),FindPolicyRequest,"FindPolicy Request");
        Response response = RestAssured.given().spec(FindPolicySpec.findPolicySpec(QuoteNumber)).when().post();

        FindPolicyResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),FindPolicyResponse,"FindPolicy Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}