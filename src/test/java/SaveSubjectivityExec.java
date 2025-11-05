import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.SaveSubjectivity;
import RequestSpecifier.SaveSubjectivitySpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class SaveSubjectivityExec {

    public void exeSaveSubjectivity(String QuoteID, String ID1,String ID2, String ID3,String ID4,String ID5,String ID6, String ID7, String ID8,Map<String,String>map)  {

        SoftAssert softAssert = new SoftAssert();

        String SaveSubjectivityRequest = SaveSubjectivity.saveSubjectivityRequest(QuoteID,ID1,ID2,ID3,ID4,ID5,ID6,ID7,ID8);
        String SaveSubjectivityResponse;

        RequestSaver.saveRequest(map.get("Iteration"),SaveSubjectivityRequest,"SaveSubjectivity Request");
        Response response = RestAssured.given().spec(SaveSubjectivitySpec.specSaveSubjectivity(QuoteID,ID1,ID2,ID3,ID4,ID5,ID6,ID7,ID8)).when().post();

        SaveSubjectivityResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),SaveSubjectivityResponse,"SaveSubjectivity Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
