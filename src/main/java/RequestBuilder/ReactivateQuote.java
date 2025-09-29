package RequestBuilder;

import Utilities.PropertyUtils;

public class ReactivateQuote {

    public static String reactivateQuote(String QuoteID){

        return "{\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "            \"ServiceRequestVersion\": \"1.0\",\n" +
                "            \"LanguageCode\": \"en\",\n" +
                "            \"UserName\": \""+ PropertyUtils.getValue("UserName")+"\",\n" +
                "            \"RegionCode\": \"\",\n" +
                "            \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId")+"\",\n" +
                "            \"UserRole\": \"uiuxunderwriter\",\n" +
                "            \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "            \"ServiceResponseVersion\": \"1.0\",\n" +
                "            \"ResponseType\": \"json\"\n" +
                "        },\n" +
                "    \"EventName\": \"ReactivateQuoteWF_1.1.0.3\",\n" +
                "    \"LOB\": \"GL\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"ID\": \""+QuoteID+"\"\n" +
                "}";

    }

}
