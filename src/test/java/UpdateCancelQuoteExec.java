import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.UpdateCancelQuote;
import RequestSpecifier.UpdateCancelQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class UpdateCancelQuoteExec {

    public void exeUpdateCancelQuote(Map<String,String>map,String TermGroupId){

        SoftAssert softAssert = new SoftAssert();

        String UpdateCancelQuoteRequest = UpdateCancelQuote.updateCancelQuote(map,TermGroupId);
        String UpdateCancelQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),UpdateCancelQuoteRequest,"UpdateCancelQuote Request");
        Response response = RestAssured.given().spec(UpdateCancelQuoteSpec.specUpdateCancelQuote(map,TermGroupId)).when().post();

        UpdateCancelQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),UpdateCancelQuoteResponse,"UpdateCancelQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
