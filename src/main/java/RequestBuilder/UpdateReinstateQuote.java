package RequestBuilder;

import Utilities.PropertyUtils;

public class UpdateReinstateQuote {

    public static String updateReinstateQuote(String TermGroupID){

        return "{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"US\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"UserRole\": \"Underwriter\",\n" +
                "        \"EndClientUserUniqueSessionId\": \"1.0\"\n" +
                "    },\n" +
                "    \"EventName\": \"UpdateReinstateQuoteByAccount_3.1.0.0\",\n" +
                "    \"TermGroupId\": \""+TermGroupID+"\",\n" +
                "    \"ReinstateReasons\": [\n" +
                "        {\n" +
                "            \"Reason\": \"Other\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }

}
