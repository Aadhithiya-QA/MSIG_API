package RequestBuilder;

import Utilities.PropertyUtils;

import java.util.Map;

public class GetPolicy {

    public static String getPolicyRequest(String PolicyID){

        return "{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"EventName\": \"GetPolicy_1.0.0\",\n" +
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
                "        \"BrowserIp\": \"\"\n" +
                "    },\n" +
                "    \"RepositoryName\": \"Policy\",\n" +
                "    \"ID\": \""+PolicyID+"\"\n" +
                "}";

    }

}
