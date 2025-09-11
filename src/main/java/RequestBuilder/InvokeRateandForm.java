package RequestBuilder;

import Utilities.PropertyUtils;

public class InvokeRateandForm {

    public static String invokeRateandFormRequest(String SubID){

        return "{\n" +
                "    \"ID\": \""+SubID+"\",\n" +
                "    \"PolicyEffectiveDate\": \""+ PropertyUtils.getValue("PolicyEffectiveDate") +"\",\n" +
                "    \"PolicyExpirationDate\": \""+PropertyUtils.getValue("PolicyExpirationDate")+"\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \"sasi\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"UserRole\": \"uiuxunderwriter\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"EventName\": \"InvokeRateFormWorkFlow_9.0.0\",\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"LastRateLookUpDate\": \"08/27/2025\",\n" +
                "    \"ConfigurationType\": \"Product\",\n" +
                "    \"IsTaxInvocationNeeded\": \"N\"\n" +
                "}";

    }

}
