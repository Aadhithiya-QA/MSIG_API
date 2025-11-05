package RequestBuilder;

import Utilities.PropertyUtils;

public class SubjectivityRequiresProcessUpdation {

    public static String subjectivityRequiredProcess(String QuoteID, String SubjectivityID){

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
                "    \"Action\": \"Pre Bind\",\n" +
                "    \"Type\": \"Subjectivity\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"Subjectivity\": [\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Open\",\n" +
                "            \"ID\": \""+SubjectivityID+"\",\n" +
                "            \"RequiredProcess\": \"Post Issuance\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"EventName\": \"SaveSubjectivity_5.0.0\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }

}
