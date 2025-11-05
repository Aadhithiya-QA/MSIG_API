import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.BindRequest;
import RequestBuilder.PreviewDocument;
import RequestSpecifier.BindRequestSpec;
import RequestSpecifier.PreviewDocumentSpec;
import com.github.javafaker.Dune;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class PreviewDocumentExec {

    public void exePreviewDocument(String QuoteID, Map<String,String>map){

        SoftAssert softAssert = new SoftAssert();

        String PreviewDocumentRequest = PreviewDocument.previewDocumentRequest(QuoteID);
        String PreviewDocumentResponse;

        RequestSaver.saveRequest(map.get("Iteration"),PreviewDocumentRequest,"PreviewDocument Request");
        Response response = RestAssured.given().spec(PreviewDocumentSpec.previewDocumentSpec(QuoteID)).when().post();

        PreviewDocumentResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),PreviewDocumentResponse,"PreviewDocument Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
