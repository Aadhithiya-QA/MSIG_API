import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.ReactivateQuote;
import RequestSpecifier.ReactivateQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class ReactivateQuoteExec {
    
    public void ExeReactivateQuote(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String ReactivateQuoteRequest = ReactivateQuote.reactivateQuote(QuoteID);
        String ReactivateQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),ReactivateQuoteRequest,"ReactivateQuote Request");
        Response response = RestAssured.given().spec(ReactivateQuoteSpec.SpecReactivateQuote(QuoteID)).when().post();

        ReactivateQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),ReactivateQuoteResponse,"ReactivateQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
