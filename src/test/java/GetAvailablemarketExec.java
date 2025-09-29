import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.GetAvailableMarket;
import RequestSpecifier.GetAvailableMarketSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class GetAvailablemarketExec {

    public void ExecGetAvailableMarket(Map<String,String>map,String SubID){

        SoftAssert softAssert = new SoftAssert();

        String GetAvailableMarketRequest = GetAvailableMarket.getAvailableMarketRequest(SubID);
        String GetAvailablemarketResponse;

        RequestSaver.saveRequest(map.get("Iteration"),GetAvailableMarketRequest,"GetAvailableMarket Request");
        Response response = RestAssured.given().spec(GetAvailableMarketSpec.SpecGetAvailableMarket(SubID)).when().post();

        GetAvailablemarketResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),GetAvailablemarketResponse,"GetAvailableMarket Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
