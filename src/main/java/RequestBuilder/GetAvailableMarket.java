package RequestBuilder;

import Utilities.PropertyUtils;

import java.util.Map;

public class GetAvailableMarket {

    public static String getAvailableMarketRequest(String SubID, Map<String,String>map){

        return "{\n" +
                "    \"SelectedLineOfBusiness\": [\n" +
                "        {\n" +
                "            \"LOBName\": \"SWP\",\n" +
                "            \"InsuranceType\": \"SIP4_InsuranceBusiness_V1\",\n" +
                "            \"ProductType\": \"SOL_Configured_V1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SelectedSublineList\": [\n" +
                "        {\n" +
                "            \"SublineName\": \"GL\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \"sip4_user\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"UserRole\": \"Underwriter\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"SubmissionID\": \""+SubID+"\",\n" +
                "    \"EventName\": \"GetAvailableMarkets_1.0.0.4\",\n" +
                "    \"ConfigurationType\": \"Product\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"QuoteType\": \"New Business\",\n" +
                "    \"RepositoryName\": \"Submission\",\n" +
                "    \"PolicyEffectiveDate\": \""+map.get("PolicyEffectiveDate")+"\",\n" +
                "    \"TermInMonths\": \"12\"\n" +
                "}";

    }

}
