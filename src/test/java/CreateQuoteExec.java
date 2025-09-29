import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.CreateQuote;
import RequestSpecifier.CreateQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class CreateQuoteExec {

    public void ExeCreateQuote(Map<String,String> map, String SubID, String carrierBlock){

        SoftAssert softAssert = new SoftAssert();

        String CreateQuoteRequest = CreateQuote.createQuote(SubID,carrierBlock);
        String CreateQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),CreateQuoteRequest,"CreateQuote Request");
        Response response = RestAssured.given().spec(CreateQuoteSpec.SpecCreateQuote(SubID,carrierBlock)).when().post();

        CreateQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),CreateQuoteResponse,"CreateQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
