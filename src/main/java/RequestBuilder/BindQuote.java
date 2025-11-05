package RequestBuilder;

import Utilities.PropertyUtils;

import java.util.Map;

public class BindQuote {

    public static String bindQuoteRequest(Map<String,String>map,String QuoteID){

        return "{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"PolicyEffectiveDate\": \""+map.get("PolicyEffectiveDate")+"\",\n" +
                "    \"PolicyExpirationDate\": \""+map.get("PolicyExpirationDate")+"\",\n" +
                "    \"IsClearanceRequired\": \"N\",\n" +
                "    \"IsCheckClearanceRequired\": \"N\",\n" +
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
                "    \"EventName\": \"BindQuoteWF_1.0.12\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"TransactionType\": \"New Business\",\n" +
                "    \"RequiredProcess\": \"Pre Bind\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"IsTaxInvocationNeeded\": \"N\",\n" +
                "    \"LogHistory\": \"Yes\"\n" +
                "}";

    }

}
