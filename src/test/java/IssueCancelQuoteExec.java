import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.IssueCancelQuote;
import RequestSpecifier.IssueCancelQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class IssueCancelQuoteExec {
    
    public void exeIssueCancelQuote(Map<String,String>map,String TermGroupId){

        SoftAssert softAssert = new SoftAssert();

        String IssueCancelQuoteRequest = IssueCancelQuote.issueCancelQuote(TermGroupId);
        String IssueCancelQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),IssueCancelQuoteRequest,"IssueCancelQuote Request");
        Response response = RestAssured.given().spec(IssueCancelQuoteSpec.specIssueCancelQuote(TermGroupId)).when().post();

        IssueCancelQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),IssueCancelQuoteResponse,"IssueCancelQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
