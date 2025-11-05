package RequestBuilder;

import Utilities.PropertyUtils;

public class GetDiaryNotes {

    public static String getAllSubjectivityDiaryNotes(String QuoteID){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \"uiuxAdmin\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"SubjectivityNotesID\": \"\",\n" +
                "    \"Type\": \"Notes\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"EventName\": \"GetSubjectivity_3.1.0.0\"\n" +
                "}";

    }

    public static String getSpecificSubjectivityDiaryNotes(String QuoteID, String SubjectivityID){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \"uiuxAdmin\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"SubjectivityNotesID\": \""+SubjectivityID+"\",\n" +
                "    \"Type\": \"Notes\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"EventName\": \"GetSubjectivity_3.1.0.0\"\n" +
                "}";

    }

}
