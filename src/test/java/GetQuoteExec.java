import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.GetQuote;
import RequestSpecifier.GetQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class GetQuoteExec {
    
    public void ExeGetQuote(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String GetQuoteRequest = GetQuote.getQuote(QuoteID);
        String GetQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),GetQuoteRequest,"GetQuote Request");
        Response response = RestAssured.given().spec(GetQuoteSpec.SpecGetQuote(QuoteID)).when().post();

        GetQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),GetQuoteResponse,"GetQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
