package RequestBuilder;

import Utilities.PropertyUtils;

public class IssueCancelQuote {

    public static String issueCancelQuote(String TermGroupId){

        return "{\n" +
                "    \"EventName\": \"IssueCancelAccountWrapper_3.0.0\",\n" +
                "    \"ProductVerNumber\": \""+ PropertyUtils.getValue("ProductVerNumber") +"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
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
                "    \"TermGroupId\": \""+TermGroupId+"\"\n" +
                "}";

    }

}
