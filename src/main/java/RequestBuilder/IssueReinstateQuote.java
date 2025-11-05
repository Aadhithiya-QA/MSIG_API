package RequestBuilder;

import Utilities.PropertyUtils;

public class IssueReinstateQuote {

    public static String issueReinstateQuote(String TermGroupID){

        return "{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"EndClientUserUniqueSessionId\": \"1.0\",\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"US\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"BrowserIp\": \"\",\n" +
                "        \"UserRole\": \"Underwriter\"\n" +
                "    },\n" +
                "    \"EventName\": \"IssueReinstateAccountWrapper_1.1.0.4\",\n" +
                "    \"TermGroupId\": \""+TermGroupID+"\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }

}
