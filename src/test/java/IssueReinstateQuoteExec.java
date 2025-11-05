import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.IssueReinstateQuote;
import RequestSpecifier.IssueReinstateQuoteSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class IssueReinstateQuoteExec {
    
    public void exeIssueReinstateQuote(Map<String,String> map, String TermGroupID){

        SoftAssert softAssert = new SoftAssert();

        String IssueReinstateQuoteRequest = IssueReinstateQuote.issueReinstateQuote(TermGroupID);
        String IssueReinstateQuoteResponse;

        RequestSaver.saveRequest(map.get("Iteration"),IssueReinstateQuoteRequest,"IssueReinstateQuote Request");
        Response response = RestAssured.given().spec(IssueReinstateQuoteSpec.specIssueReinstateQuote(TermGroupID)).when().post();

        IssueReinstateQuoteResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),IssueReinstateQuoteResponse,"IssueReinstateQuote Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
