import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.LapseOrDeclineQuote;
import RequestSpecifier.LapseOrDeclineQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class LapseOrDeclineQuoteExec {
    
    public void ExeLapseQuote(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String LapseQuoteRequest = LapseOrDeclineQuote.lapseQuote(QuoteID);
        String LapseQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),LapseQuoteRequest,"LapseQuote Request");
        Response response = RestAssured.given().spec(LapseOrDeclineQuoteSpec.SpecLapseQuote(QuoteID)).when().post();

        LapseQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),LapseQuoteResponse,"LapseQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }

    public void ExeDeclineQuote(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String DeclineQuoteRequest = LapseOrDeclineQuote.declineQuote(QuoteID);
        String DeclineQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),DeclineQuoteRequest,"DeclineQuote Request");
        Response response = RestAssured.given().spec(LapseOrDeclineQuoteSpec.SpecDeclineQuote(QuoteID)).when().post();

        DeclineQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),DeclineQuoteResponse,"DeclineQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }
    
}
