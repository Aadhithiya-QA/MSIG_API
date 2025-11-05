package RequestBuilder;

import Utilities.PropertyUtils;
import org.checkerframework.checker.units.qual.A;

import java.util.Map;

public class CreateCancelQuote {

    public static String createCancelQuoteRequest(Map<String,String>map,String AccountID){

        return "{\n" +
                "    \"EventName\": \"CreateCancelQuoteByAccount_3.1.0.0\",\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"UserRole\": \"Underwriter\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"AccountID\": \""+AccountID+"\",\n" +
                "    \"CancellationReasons\": [\n" +
                "        {\n" +
                "            \"Reason\": \"Payment not received\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"CancellationDate\": \""+map.get("CancelDate")+"\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";
    }

}
