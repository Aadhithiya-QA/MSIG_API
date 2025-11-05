package RequestBuilder;

import Utilities.PropertyUtils;

public class PreviewDocument {

    public static String previewDocumentRequest(String QuoteID){

        return "{\n" +
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
                "    \"EventName\": \"PreviewDocument_1.0.0\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"DocumentType\": \"Binder\"\n" +
                "}";

    }

}
