import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.GetPolicy;
import RequestSpecifier.GetPolicySpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class GetPolicyExec {

    public void exeGetPolicy(String PolicyID,Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String GetPolicyRequest = GetPolicy.getPolicyRequest(PolicyID);
        String GetPolicyResponse;

        RequestSaver.saveRequest(map.get("Iteration"),GetPolicyRequest,"GetPolicy Request");
        Response response = RestAssured.given().spec(GetPolicySpec.getPolicySpec(PolicyID)).when().post();

        GetPolicyResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),GetPolicyResponse,"GetPolicy Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
