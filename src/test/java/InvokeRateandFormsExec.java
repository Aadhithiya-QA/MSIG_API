import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.InvokeRateandForm;
import RequestSpecifier.InvokeRateandFormSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class InvokeRateandFormsExec {

    public void ExecInvokeRateandForms(Map<String,String>map,String SubID){

        String InvokeRateandFormsRequest = InvokeRateandForm.invokeRateandFormRequest(SubID);
        String InvokeRateandFormsResponse;

        RequestSaver.saveRequest(map.get("Iteration"),InvokeRateandFormsRequest,"InvokeRateandForms Request");
        Response response = RestAssured.given().spec(InvokeRateandFormSpec.SpecInvokeRate(SubID)).when().post();

        InvokeRateandFormsResponse = response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),InvokeRateandFormsResponse,"InvokeRateandForms Response");

    }

}
