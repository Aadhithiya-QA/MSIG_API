import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.CreateQuote;
import RequestSpecifier.CreateQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CreateQuoteExec {

    public void ExeCreateQuote(Map<String,String> map, String SubID, String carrierBlock){

        SoftAssert softAssert = new SoftAssert();

        String CreateQuoteRequest = CreateQuote.createQuote(map,SubID,carrierBlock);
        String CreateQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),CreateQuoteRequest,"CreateQuote Request");
        Response response = RestAssured.given().spec(CreateQuoteSpec.SpecCreateQuote(map,SubID,carrierBlock)).when().post();

        CreateQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),CreateQuoteResponse,"CreateQuote Response");

        long responseTime = response.timeIn(TimeUnit.SECONDS);
        Reporter.log("CreateQuote API Response Time: " + responseTime + " Sec", true);

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();


    }

}
