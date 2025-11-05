package RequestBuilder;

import Utilities.PropertyUtils;

import java.util.Map;

public class IssuePolicy {

    public static String issuePolicyRequest(String PolicyID, Map<String,String>map){

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
                "        \"EndClientUserUniqueSessionId\": \"1.0\",\n" +
                "        \"BrowserIp\": \"192.158. 1.38\"\n" +
                "    },\n" +
                "    \"EventName\": \"IssuePolicyWF_7.1.0.0\",\n" +
                "    \"RequiredProcess\": \"Pre Bind\",\n" +
                "    \"TransactionType\": \"Policy\",\n" +
                "    \"IsCheckClearanceRequired\": \"N\",\n" +
                "    \"IsClearanceRequired\": \"N\",\n" +
                "    \"RepositoryName\": \"Policy\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"PolicyEffectiveDate\": \""+map.get("PolicyEffectiveDate")+"\",\n" +
                "    \"PolicyExpirationDate\": \""+map.get("PolicyExpirationDate")+"\",\n" +
                "    \"ID\": \""+PolicyID+"\"\n" +
                "}";

    }

}
