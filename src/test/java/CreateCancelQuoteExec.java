import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.CreateCancelQuote;
import RequestSpecifier.CreateCancelQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CreateCancelQuoteExec {
    
    public void exeCreateCancelQuote(Map<String,String>map, String AccountID){

        SoftAssert softAssert = new SoftAssert();

        String CreateCancelQuoteRequest = CreateCancelQuote.createCancelQuoteRequest(map,AccountID);
        String CreateCancelQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),CreateCancelQuoteRequest,"CreateCancelQuote Request");
        Response response = RestAssured.given().spec(CreateCancelQuoteSpec.SpecCreateCancelQuote(map,AccountID)).when().post();

        CreateCancelQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),CreateCancelQuoteResponse,"CreateCancelQuote Response");

        long responseTime = response.timeIn(TimeUnit.SECONDS);
        Reporter.log("CreateCancelQuote API Response Time: " + responseTime + " Sec", true);

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
