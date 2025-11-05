import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.CreateReinstateQuote;
import RequestSpecifier.CreateReinstateQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CreateReinstateQuoteExec {
    
    public void exeCreateReinstateQuote(Map<String,String>map,String AccountID){

        SoftAssert softAssert = new SoftAssert();

        String CreateReinstateQuoteRequest = CreateReinstateQuote.createReinstateQuote(AccountID);
        String CreateReinstateQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),CreateReinstateQuoteRequest,"CreateReinstateQuote Request");
        Response response = RestAssured.given().spec(CreateReinstateQuoteSpec.specCreateReinstateQuote(AccountID)).when().post();

        CreateReinstateQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),CreateReinstateQuoteResponse,"CreateReinstateQuote Response");

        long responseTime = response.timeIn(TimeUnit.SECONDS);
        Reporter.log("CreateReinstateQuote API Response Time: " + responseTime + " Sec", true);

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
