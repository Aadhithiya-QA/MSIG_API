package RequestBuilder;

import Utilities.PropertyUtils;

public class LapseandDeclineSubmission {

    public static String lapseSubmissionRequest(String SubID){

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
                "        \"Token\": \""+ PropertyUtils.getValue("Token")+ "\",\n" +
                "        \"UserRole\": \"Underwriter\",\n" +
                "        \"EndClientUserUniqueSessionId\": \"1.0\",\n" +
                "        \"Lob\": \"SWP\",\n" +
                "        \"BrowserIp\": \"192.158. 1.38\",\n" +
                "        \"RMSModeledPremium\": \"425.21\"\n" +
                "    },\n" +
                "    \"EventName\": \"LapseOrDeclineSubmission_WF_2.0.0\",\n" +
                "    \"LOB\": \"SWP\",\n" +
                "    \"ID\": \""+SubID+"\",\n" +
                "    \"SubmissionStatus\": \"Lapsed\",\n" +
                "    \"LapseOrDeclineReason\": \"Other\",\n" +
                "    \"LapseOrDeclineNotes\": \"Others\",\n" +
                "    \"ProductVerNumber\":\""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"RepositoryName\": \"Submission\"\n" +
                "}";

    }

    public static String declineSubmissionRequest(String SubID){

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
                "        \"EndClientUserUniqueSessionId\": \"1.0\",\n" +
                "        \"Lob\": \"SWP\",\n" +
                "        \"BrowserIp\": \"192.158. 1.38\",\n" +
                "        \"RMSModeledPremium\": \"425.21\"\n" +
                "    },\n" +
                "    \"EventName\": \"LapseOrDeclineSubmission_WF_2.0.0\",\n" +
                "    \"LOB\": \"SWP\",\n" +
                "    \"ID\": \""+SubID+"\",\n" +
                "    \"SubmissionStatus\": \"Declined\",\n" +
                "    \"LapseOrDeclineReason\": \"Other\",\n" +
                "    \"LapseOrDeclineNotes\": \"Others\",\n" +
                "    \"ProductVerNumber\":\""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"RepositoryName\": \"Submission\"\n" +
                "}";

    }

}
