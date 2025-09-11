package RequestBuilder;

import Utilities.PropertyUtils;

public class ReferSubmission {

    public static String referSubmissionRequest(String SubID){

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
                "        \"Token\": \""+ PropertyUtils.getValue("Token") +"\",\n" +
                "        \"UserRole\": \"Underwriter\",\n" +
                "        \"Lob\": \"SWP\"\n" +
                "    },\n" +
                "    \"EventName\": \"ReferSubmissionWF_1.0.2\",\n" +
                "    \"LOB\": \"SWP\",\n" +
                "    \"ID\": \""+SubID+"\",\n" +
                "    \"ReferralReason\": \"Other\",\n" +
                "    \"ReferralNotes\": \"Others\"\n" +
                "}";

    }

}
