package RequestBuilder;

import Utilities.PropertyUtils;

public class InvokeRateandForm {

    public static String invokeRateandFormRequest(String SubID,String carrierBlock){

        return "    {\n" +
                "        \"ID\": \""+SubID+"\",\n" +
                "        \"PolicyEffectiveDate\": \""+PropertyUtils.getValue("PolicyEffectiveDate")+"\",\n" +
                "        \"PolicyExpirationDate\": \""+PropertyUtils.getValue("PolicyExpirationDate")+"\",\n" +
                "        \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "        \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
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
                "        \"ServiceRequestDetail\": {\n" +
                "            \"ServiceRequestVersion\": \"1.0\",\n" +
                "            \"LanguageCode\": \"en\",\n" +
                "            \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "            \"RegionCode\": \"\",\n" +
                "            \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "            \"UserRole\": \"uiuxunderwriter\",\n" +
                "            \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "            \"ServiceResponseVersion\": \"1.0\",\n" +
                "            \"ResponseType\": \"json\"\n" +
                "        },\n" +
                "        \"EventName\": \"InvokeRateFormWorkFlow_10.0.0\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"LastRateLookUpDate\": \"09/11/2025\",\n" +
                "        \"ConfigurationType\": \"Product\",\n" +
                "        \"RepositoryName\": \"Submission\",\n" +
                "        \"IsTaxInvocationNeeded\": \"N\",\n" +
                "        \"IS_SUBJECTIVITY_NEEDED\": \"Y\"\n" +
                "    }";

    }

}
