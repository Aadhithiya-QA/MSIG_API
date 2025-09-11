package RequestBuilder;

import Utilities.PropertyUtils;

public class FindAccount {

    public static String findAccountRequest(String AccountID){

        return "{\n" +
                "    \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\",\n" +
                "        \"Token\": \""+ PropertyUtils.getValue("Token")+ "\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\"\n" +
                "    },\n" +
                "    \"LastModifiedBy\":\"\",\n" +
                "    \"SearchName\": \"FindAccount_V1\",\n" +
                "    \"EventName\": \"FindAccount_1.0.0\",\n" +
                "    \"EndLimit\": \"5\",\n" +
                "    \"StartLimit\": \"0\",\n" +
                "    \"ProductVerNumber\": \""+ PropertyUtils.getValue("ProductVerNumber") +"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\",\n" +
                "    \"ID\":\""+AccountID+"\",\n" +
                "    \"AccountNumber\": \"\",\n" +
                "    \"AccountName\": \" \",\n" +
                "    \"CreatedBy\": \"\",\n" +
                "    \"CreatedFromDate\":\"\",\n" +
                "    \"CreatedToDate\": \"\"\n" +
                "}";

    }

}
