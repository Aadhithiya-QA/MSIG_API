package RequestBuilder;

import Utilities.PropertyUtils;

public class ReactivateSubmission {

    public static String reactivateSubmissionRequest(String SubID){

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
                "        \"Lob\": \"SWP\"\n" +
                "    },\n" +
                "    \"ID\": \""+SubID+"\",\n" +
                "    \"EventName\": \"ReactivateSubmissionWF_1.0.1\",\n" +
                "    \"LOB\": \"SWP\"\n" +
                "}";

    }

}
