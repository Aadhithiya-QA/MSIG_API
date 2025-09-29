package RequestBuilder;

import Utilities.PropertyUtils;

public class CreateQuote {

    public static String createQuote(String SubID,String carrierBlock){

        return "{\n" +
                "        \"ServiceRequestDetail\": {\n" +
                "            \"ServiceRequestVersion\": \"1.0\",\n" +
                "            \"LanguageCode\": \"en\",\n" +
                "            \"UserName\": \""+ PropertyUtils.getValue("UserName")+"\",\n" +
                "            \"RegionCode\": \"\",\n" +
                "            \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "            \"UserRole\": \"uiuxunderwriter\",\n" +
                "            \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "            \"ServiceResponseVersion\": \"1.0\",\n" +
                "            \"ResponseType\": \"json\"\n" +
                "        },\n" +
                "        \"SelectedSublines\": [\n" +
                "            {\n" +
                "                \"SublineName\": \"GL\",\n" +
                "                \"SelectedCarriers\": [\n" +
                                        carrierBlock +
                "                ],\n" +
                "                \"SublineID\": \"132\",\n" +
                "                \"SublineDisplayName\": \"For ISO GL entries\"\n" +
                "            }\n" +
                "        ],\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"QuoteType\": \"New Business\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"SubmissionID\": \""+SubID+"\",\n" +
                "    \"EventName\": \"CreateQuoteWF_9.0.0\",\n" +
                "    \"IsValidationRequired\": \"N\",\n" +
                "    \"PolicyEffectiveDate\": \""+PropertyUtils.getValue("PolicyEffectiveDate")+"\",\n" +
                "    \"PolicyExpirationDate\": \""+PropertyUtils.getValue("PolicyExpirationDate")+"\",\n" +
                "    \"IsCheckClearanceRequired\": \"N\",\n" +
                "    \"IsClearanceRequired\": \"N\",\n" +
                "    \"RepositoryName\": \"Submission\",\n" +
                "    \"IsTaxInvocationNeeded\": \"N\",\n" +
                "    \"IS_SUBJECTIVITY_NEEDED\": \"N\"\n" +
                "}";

    }

}
