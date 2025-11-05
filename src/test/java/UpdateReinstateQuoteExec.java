import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.UpdateReinstateQuote;
import RequestSpecifier.UpdateReinstateQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class UpdateReinstateQuoteExec {

    public void exeUpdateReinstateQuote(Map<String,String>map,String TermGroupID){

        SoftAssert softAssert = new SoftAssert();

        String UpdateReinstateQuoteRequest = UpdateReinstateQuote.updateReinstateQuote(TermGroupID);
        String UpdateReinstateQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),UpdateReinstateQuoteRequest,"UpdateReinstateQuote Request");
        Response response = RestAssured.given().spec(UpdateReinstateQuoteSpec.specUpdateReinstateQuote(TermGroupID)).when().post();

        UpdateReinstateQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),UpdateReinstateQuoteResponse,"UpdateReinstateQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
