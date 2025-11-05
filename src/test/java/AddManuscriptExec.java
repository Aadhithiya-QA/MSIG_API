import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.AddManuscript;
import RequestSpecifier.AddManuscriptSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class AddManuscriptExec {

    public void exeAddManuscript(Map<String,String> map, String QuoteID){

        SoftAssert softAssert = new SoftAssert();

        String AddManuscriptRequest = AddManuscript.addManuscriptRequest(QuoteID);
        String AddManuscriptResponse;

        RequestSaver.saveRequest(map.get("Iteration"),AddManuscriptRequest,"AddManuscript Request");
        Response response = RestAssured.given().spec(AddManuscriptSpec.specAddManuscript(QuoteID)).when().post();

        AddManuscriptResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),AddManuscriptResponse,"AddManuscript Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }
    
}
