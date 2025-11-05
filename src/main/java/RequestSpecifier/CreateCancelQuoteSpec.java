package RequestSpecifier;

import RequestBuilder.CreateCancelQuote;
import RequestBuilder.CreateQuote;
import Utilities.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class CreateCancelQuoteSpec {

    public static RequestSpecification SpecCreateCancelQuote(Map<String,String>map,String AccountID){

        String url = "";
        if (PropertyUtils.getValue("EnvironmentToRun").equalsIgnoreCase("UAT")){
            url = "https://commonmultikb.uat.solartis.net/KnowledgeEngineV6_11/KnowledgeBase/FireEventV4";
        } else if (PropertyUtils.getValue("EnvironmentToRun").equalsIgnoreCase("PROD")) {
            url = "https://commonmultikb.solartis.net/KnowledgeEngineV6_11/KnowledgeBase/FireEventV4";
        }

        RequestSpecification requestSpecification = new RequestSpecBuilder().build();

        requestSpecification
                .baseUri(url)
                .header("Content-Type", "application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("EventName", "CreateCancelQuoteByAccount_3.1.0.0")
                .header("Token",PropertyUtils.getValue("Token"))
                .header("OwnerId", PropertyUtils.getValue("OwnerId"))
                .header("Mode", PropertyUtils.getValue("Mode"))
                .header("Environment", PropertyUtils.getValue("Env"))
                .body(CreateCancelQuote.createCancelQuoteRequest(map,AccountID));
        return requestSpecification;

    }

}
