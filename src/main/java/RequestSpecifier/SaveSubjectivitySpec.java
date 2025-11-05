package RequestSpecifier;

import RequestBuilder.SaveSubjectivity;
import Utilities.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class SaveSubjectivitySpec {

    public static RequestSpecification specSaveSubjectivity(String QuoteID,String ID1,String ID2, String ID3,String ID4,String ID5,String ID6, String ID7,String ID8) {

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
                .header("EventName", "SaveSubjectivity_5.0.0")
                .header("Token",PropertyUtils.getValue("Token"))
                .header("OwnerId", PropertyUtils.getValue("OwnerId"))
                .header("Mode", PropertyUtils.getValue("Mode"))
                .header("Environment", PropertyUtils.getValue("Env"))
                .body(SaveSubjectivity.saveSubjectivityRequest(QuoteID,ID1,ID2,ID3,ID4,ID5,ID6,ID7,ID8));
        return requestSpecification;

    }

}
