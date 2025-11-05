package RequestBuilder;

import Utilities.PropertyUtils;

public class FindPolicy {

    public static String findPolicyRequest(String QuoteNumber){

        return"{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
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
                "    \"SearchName\": \"FindPolicyV8\",\n" +
                "    \"EventName\": \"FindPolicy_4.0.0\",\n" +
                "    \"FindPolicy\": {},\n" +
                "    \"Find\": \"\",\n" +
                "    \"PolicyFullNumber\": \"\",\n" +
                "    \"InsuredName\": \"\",\n" +
                "    \"QuoteFullNumber\": \""+QuoteNumber+"\",\n" +
                "    \"PolicyStatus\": \"\",\n" +
                "    \"Region\": \"\",\n" +
                "    \"SublineName\": \"\",\n" +
                "    \"PolicyType\": \"\",\n" +
                "    \"EffectiveFromDate\": \"\",\n" +
                "    \"EffectiveToDate\": \"\",\n" +
                "    \"Spacer\": \"\",\n" +
                "    \"StartLimit\": \"0\",\n" +
                "    \"EndLimit\": \"5\"\n" +
                "}";

    }

}
