package RequestBuilder;

import Utilities.PropertyUtils;

import java.util.Map;

public class UpdateCancelQuote {

    public static String updateCancelQuote(Map<String,String>map,String TermGroupId){

        return "{\n" +
                "    \"EventName\": \"UpdateCancelQuoteByAccount_3.1.0.0\",\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"UserRole\": \"Underwriter\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"TermGroupId\": \""+TermGroupId+"\",\n" +
                "    \"CancellationReasons\": [\n" +
                "        {\n" +
                "            \"Reason\": \"Insured Request\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"CancellationDate\": \""+map.get("CancelDate")+"\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";
    }

}
