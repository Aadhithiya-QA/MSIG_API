package RequestSpecifier;

import RequestBuilder.SaveSubmission;
import Utilities.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class SaveSubmissionSpec {

    public static RequestSpecification SpecSaveSubmission(String iteration,
                                                          Map<String, String> mainSheet,
                                                          List<Map<String, String>> policySheet,
                                                          List<Map<String, String>> locationSheet,
                                                          List<Map<String, String>> classificationSheet){

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
                .header("EventName", "SaveSubmission_1.0.7")
                .header("Token",PropertyUtils.getValue("Token"))
                .header("OwnerId", PropertyUtils.getValue("OwnerId"))
                .header("Mode", PropertyUtils.getValue("Mode"))
                .header("Environment", PropertyUtils.getValue("Env"))
                .body(SaveSubmission.buildFinalRequest(iteration,mainSheet,policySheet,locationSheet,classificationSheet));
        return requestSpecification;

    }

}
