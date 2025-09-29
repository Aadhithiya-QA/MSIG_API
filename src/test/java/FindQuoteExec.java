import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.FindQuote;
import RequestSpecifier.FindQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class FindQuoteExec {

    public void ExeFindQuote(String QuoteNumber, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String FindQuoteRequest = FindQuote.findQuote(QuoteNumber);
        String FindQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),FindQuoteRequest,"FindQuote Request");
        Response response = RestAssured.given().spec(FindQuoteSpec.SpecFindQuote(QuoteNumber)).when().post();

        FindQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),FindQuoteResponse,"FindQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
