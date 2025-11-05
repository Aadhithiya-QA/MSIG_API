package RequestSpecifier;

import RequestBuilder.BindQuote;
import RequestBuilder.DiaryNotes;
import Utilities.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class DiaryNotesSpec {

    public static RequestSpecification specDiaryNotes(String QuoteID,String SubjectivityID){

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
                .body(DiaryNotes.diaryNotesSingleRequest(QuoteID,SubjectivityID));
        return requestSpecification;
    }

    public static RequestSpecification specMultipleDiaryNotes(String QuoteID,String ID1,String ID2,String ID3){

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
                .body(DiaryNotes.diaryNotesMultipleRequest(QuoteID, ID1, ID2, ID3));
        return requestSpecification;
    }

}
