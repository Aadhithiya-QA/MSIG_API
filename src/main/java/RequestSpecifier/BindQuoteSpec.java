package RequestSpecifier;

import RequestBuilder.BindQuote;
import RequestBuilder.BindRequest;
import Utilities.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class BindQuoteSpec {

    public static RequestSpecification bindQuoteSpec(Map<String,String>map,String QuoteID){

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
                .header("EventName", "BindQuoteWF_1.0.12")
                .header("Token",PropertyUtils.getValue("Token"))
                .header("OwnerId", PropertyUtils.getValue("OwnerId"))
                .header("Mode", PropertyUtils.getValue("Mode"))
                .header("Environment", PropertyUtils.getValue("Env"))
                .body(BindQuote.bindQuoteRequest(map,QuoteID));
        return requestSpecification;

    }

}
