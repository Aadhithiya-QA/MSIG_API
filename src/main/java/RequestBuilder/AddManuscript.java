package RequestBuilder;

import Utilities.PropertyUtils;

public class AddManuscript {

    public static String addManuscriptRequest(String QuoteID){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+ PropertyUtils.getValue("UserName") +"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"Action\": \"Add\",\n" +
                "    \"Type\": \"Manuscript\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"Subjectivity\": [\n" +
                "        {\n" +
                "            \"SubjectivityName\": \"Test1Subjectivity\",\n" +
                "            \"SubjectivityDesc\": \"\",\n" +
                "            \"SubjectivityLevel\": \"Policy\",\n" +
                "            \"SubjectivityType\": \"Manuscript\",\n" +
                "            \"RequiredProcess\": \"Pre Bind\",\n" +
                "            \"SubjectivityReason\": \"\",\n" +
                "            \"SubjectivityDueDate\": \"05/28/2025\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"EventName\": \"SaveSubjectivity_5.0.0\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }

}
