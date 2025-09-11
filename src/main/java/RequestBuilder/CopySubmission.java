package RequestBuilder;

import Utilities.PropertyUtils;

public class CopySubmission {

    public static String copySubmissionRequest(String SubID){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId")+ "\",\n" +
                "        \"EndClientUserUniqueSessionId\": \"\",\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"ServiceResponseVersion\": \"\",\n" +
                "        \"ResponseType\": \"Json\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"Lob\": \"\",\n" +
                "        \"BrowserIp\": \"\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"EventName\": \"CopySubmission_WF_3.0.0\",\n" +
                "    \"ID\": \""+SubID+"\"\n" +
                "}";

    }

}
