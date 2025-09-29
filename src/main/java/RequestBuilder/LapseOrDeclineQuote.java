package RequestBuilder;

import Utilities.PropertyUtils;

public class LapseOrDeclineQuote {

    public static String lapseQuote(String QuoteID){

        return "{\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
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
                "    \"EventName\": \"LapseOrDeclineQuote_WF_1.0.3\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"QuoteStatus\": \"Lapsed\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"LapseOrDeclineReason\": \"Other\",\n" +
                "    \"LapseOrDeclineNotes\": \"Other\"\n" +
                "}";

    }

    public static String declineQuote(String QuoteID){

        return "{\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
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
                "    \"EventName\": \"LapseOrDeclineQuote_WF_1.0.3\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"QuoteStatus\": \"Declined\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"LapseOrDeclineReason\": \"Other\",\n" +
                "    \"LapseOrDeclineNotes\": \"Other\"\n" +
                "}";

    }

}
