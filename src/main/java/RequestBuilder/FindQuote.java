package RequestBuilder;

import Utilities.PropertyUtils;

public class FindQuote {

    public static String findQuote(String QuoteNumber){

        return "{\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "            \"ServiceRequestVersion\": \"1.0\",\n" +
                "            \"LanguageCode\": \"en\",\n" +
                "            \"UserName\": \""+ PropertyUtils.getValue("UserName")+"\",\n" +
                "            \"RegionCode\": \"\",\n" +
                "            \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "            \"UserRole\": \"uiuxunderwriter\",\n" +
                "            \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "            \"ServiceResponseVersion\": \"1.0\",\n" +
                "            \"ResponseType\": \"json\"\n" +
                "        },\n" +
                "    \"EventName\": \"FindQuote_2.0.0\",\n" +
                "    \"SearchName\": \"FindQuoteInfoV1\",\n" +
                "    \"Name\": \"\",\n" +
                "    \"CreatedFromDate\": \"\",\n" +
                "    \"CreatedToDate\": \"\",\n" +
                "    \"EffectiveFromDate\": \"\",\n" +
                "    \"EffectiveToDate\": \"\",\n" +
                "    \"QuoteType\": \"\",\n" +
                "    \"QuoteStatus\": \"\",\n" +
                "    \"QuoteFullNumber\": \""+QuoteNumber+"\",\n" +
                "    \"InsuredName\": \"\"\n" +
                "}";

    }

}
