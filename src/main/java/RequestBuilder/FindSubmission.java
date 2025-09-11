package RequestBuilder;

import Utilities.PropertyUtils;

public class FindSubmission {

    public static String findSubmissionRequest(String SubNumber){

        return "{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\"\n" +
                "    },\n" +
                "    \"SearchName\": \"FindSubmissionInfoV1\",\n" +
                "    \"EventName\": \"FindSubmission_2.0.0\",\n" +
                "    \"StartLimit\": \"0\",\n" +
                "    \"EndLimit\": \"5\",\n" +
                "    \n" +
                "    \"SubmissionNumber\": \""+SubNumber+"\",\n" +
                "    \"InsuredName\": \"\",\n" +
                "    \"AgentName\": \"\",\n" +
                "    \"AgencyName\": \"\",\n" +
                "    \"SubmissionStatus\": \"\",\n" +
                "    \"CreatedBy\": \"\",\n" +
                "    \"CreatedFromDate\": \"\",\n" +
                "    \"CreatedToDate\": \"\"\n" +
                "    \n" +
                "}";

    }

}
