import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.BindRequest;
import RequestSpecifier.BindRequestSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class BindRequestExec {

    public void ExeBindRequest(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String BindRequestRequest = BindRequest.bindRequest(QuoteID);
        String BindRequestResponse;

        RequestSaver.saveRequest(map.get("Iteration"),BindRequestRequest,"BindRequest Request");
        Response response = RestAssured.given().spec(BindRequestSpec.SpecBindRequest(QuoteID)).when().post();

        BindRequestResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),BindRequestResponse,"BindRequest Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
