import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.BindQuote;
import RequestBuilder.BindRequest;
import RequestSpecifier.BindQuoteSpec;
import RequestSpecifier.BindRequestSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class BindQuoteExec {

    public void exeBindQuote(Map<String,String>map,String QuoteID){

        SoftAssert softAssert = new SoftAssert();

        String BindQuoteRequest = BindQuote.bindQuoteRequest(map,QuoteID);
        String BindQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),BindQuoteRequest,"BindQuote Request");
        Response response = RestAssured.given().spec(BindQuoteSpec.bindQuoteSpec(map,QuoteID)).when().post();

        BindQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),BindQuoteResponse,"BindQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
