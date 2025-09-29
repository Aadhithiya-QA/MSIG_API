import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.InvokeRateandForm;
import RequestSpecifier.InvokeRateandFormSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class InvokeRateandFormsExec {

    public void ExecInvokeRateandForms(Map<String,String>map,String SubID,String carrierBlock){

        SoftAssert softAssert = new SoftAssert();

        String InvokeRateandFormsRequest = InvokeRateandForm.invokeRateandFormRequest(SubID,carrierBlock);
        String InvokeRateandFormsResponse;

        RequestSaver.saveRequest(map.get("Iteration"),InvokeRateandFormsRequest,"InvokeRateandForms Request");
        Response response = RestAssured.given().spec(InvokeRateandFormSpec.SpecInvokeRate(SubID,carrierBlock)).when().post();

        InvokeRateandFormsResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),InvokeRateandFormsResponse,"InvokeRateandForms Response");

        softAssert.assertEquals(response.getStatusCode(),200,"Status code mismatch");
        softAssert.assertAll();

    }

}
