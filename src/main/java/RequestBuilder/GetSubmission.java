package RequestBuilder;

import Utilities.PropertyUtils;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class GetSubmission {

    public static String getSubmissionRequest(String SubID){

        return "{\n" +
                "  \"OwnerId\":  \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "  \"EventName\": \"GetSubmission_2.0.0\",\n" +
                "  \"ServiceRequestDetail\": {\n" +
                "    \"OwnerId\":  \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"EndClientUserUniqueSessionId\": \"1.0\",\n" +
                "    \"ServiceRequestVersion\": \"1.0\",\n" +
                "    \"LanguageCode\": \"en\",\n" +
                "    \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "    \"RegionCode\": \"US\",\n" +
                "    \"ServiceResponseVersion\": \"1.0\",\n" +
                "    \"ResponseType\": \"json\",\n" +
                "    \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "    \"Lob\": \"CP\",\n" +
                "    \"BrowserIp\": \"\"\n" +
                "  },\n" +
                "  \"ID\": \""+SubID+"\"\n" +
                "}";

    }

}
