package RequestBuilder;

import Utilities.PropertyUtils;
import com.github.javafaker.Dune;

public class GetSubjectivity {

    public static String getSubjectivityRequest(String QuoteID){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \"uiuxAdmin\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"Type\": \"Subjectivity\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"EventName\": \"GetSubjectivity_2.0.0\"\n" +
                "}";

    }

    public static String getSpecificSubjectivityRequest(String QuoteID, String ID1){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ID\": \""+ QuoteID +"\",\n" +
                "    \"Type\": \"Subjectivity\",\n" +
                "    \"SubjectivityID\" : \""+ID1+"\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"EventName\": \"GetSubjectivity_3.1.0.0\"\n" +
                "}";

    }

}
