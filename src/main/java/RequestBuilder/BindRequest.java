package RequestBuilder;

import Utilities.PropertyUtils;

public class BindRequest {

    public static String bindRequest(String QuoteID){

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
                "    \"EventName\": \"BindRequest_2.0.0\",\n" +
                "    \"RepositoryName\":\"Quote\",\n" +
                "    \"ID\": \""+QuoteID+"\"\n" +
                "}";

    }

}
