import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.GetSubjectivity;
import RequestSpecifier.GetSubjectivitySpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class GetSubjectivityExec {

    public void exeGetSubjectivity(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String GetSubjectivityRequest = GetSubjectivity.getSubjectivityRequest(QuoteID);
        String GetSubjectivityResponse;

        RequestSaver.saveRequest(map.get("Iteration"),GetSubjectivityRequest,"GetSubjectivity Request");
        Response response = RestAssured.given().spec(GetSubjectivitySpec.getSubjectivitySpec(QuoteID)).when().post();

        GetSubjectivityResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),GetSubjectivityResponse,"GetSubjectivity Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

    public void exeGetSpecificSubjectivity(String QuoteID, Map<String,String>map, String ID1){

        SoftAssert softAssert = new SoftAssert();

        String GetSpecificSubjectivityRequest = GetSubjectivity.getSubjectivityRequest(QuoteID);
        String GetSpecificSubjectivityResponse;

        RequestSaver.saveRequest(map.get("Iteration"),GetSpecificSubjectivityRequest,"GetSpecificSubjectivity Request");
        Response response = RestAssured.given().spec(GetSubjectivitySpec.getSpecificSubjectivitySpec(QuoteID,ID1)).when().post();

        GetSpecificSubjectivityResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),GetSpecificSubjectivityResponse,"GetSpecificSubjectivity Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
