import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.DiaryNotes;
import RequestSpecifier.DiaryNotesSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class DiaryNotesExec {
    
    public void exeDiaryNotes(String QuoteID, String SubjectivityID, Map<String ,String>map){

        SoftAssert softAssert = new SoftAssert();

        String DiaryNotesRequest = DiaryNotes.diaryNotesSingleRequest(QuoteID,SubjectivityID);
        String DiaryNotesResponse;

        RequestSaver.saveRequest(map.get("Iteration"),DiaryNotesRequest,"DiaryNotes Request");
        Response response = RestAssured.given().spec(DiaryNotesSpec.specDiaryNotes(QuoteID,SubjectivityID)).when().post();

        DiaryNotesResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),DiaryNotesResponse,"DiaryNotes Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();
        
    }
    
}
