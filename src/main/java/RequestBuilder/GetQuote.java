package RequestBuilder;

import Utilities.PropertyUtils;

public class GetQuote {

    public static String getQuote(String QuoteID){

        return "{\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"EventName\": \"GetQuote_1.0.0\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "            \"ServiceRequestVersion\": \"1.0\",\n" +
                "            \"LanguageCode\": \"en\",\n" +
                "            \"UserName\": \""+ PropertyUtils.getValue("UserName")+"\",\n" +
                "            \"RegionCode\": \"\",\n" +
                "            \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "            \"UserRole\": \"uiuxunderwriter\",\n" +
                "            \"Token\": \""+ PropertyUtils.getValue("Token")+"\",\n" +
                "            \"ServiceResponseVersion\": \"1.0\",\n" +
                "            \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"RepositoryName\": \"Quote\"\n" +
                "}";

    }

}
