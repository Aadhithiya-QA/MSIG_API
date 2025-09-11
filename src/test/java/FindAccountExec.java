import CommonFunctions.RequestSaver;
import CommonFunctions.ResponseSaver;
import RequestBuilder.FindAccount;
import RequestSpecifier.FindAccountSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class FindAccountExec {

    public void ExecFindAccount(Map<String,String>map,String AccountID){

        String FindAccountRequest = FindAccount.findAccountRequest(AccountID);
        String FindAccountResponse;

        RequestSaver.saveRequest(map.get("Iteration"),FindAccountRequest,"FindAccount Request");
        Response response = RestAssured.given().spec(FindAccountSpec.SpecFindAccount(AccountID)).when().post();

        FindAccountResponse=response.then().extract().body().asPrettyString();
        ResponseSaver.saveResponse(map.get("Iteration"),FindAccountResponse,"FindAccount Response");

    }

}
