package RequestBuilder;

import Utilities.PropertyUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;
import java.util.Map;

public class SaveSubjectivity {

    public static String saveSubjectivityRequest(String QuoteID,String ID1,String ID2, String ID3,String ID4,String ID5,String ID6,String ID8, String ID7){

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
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"Action\": \"Update\",\n" +
                "    \"Type\": \"Subjectivity\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"Subjectivity\": [\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Satisfied\",\n" +
                "            \"ID\": \""+ID1+"\",\n" +
                "            \"RequiredProcess\": \"Pre Bind\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Satisfied\",\n" +
                "            \"ID\": \""+ID2+"\",\n" +
                "            \"RequiredProcess\": \"Post Bind\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Satisfied\",\n" +
                "            \"ID\": \""+ID3 +"\",\n" +
                "            \"RequiredProcess\": \"Post Bind\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Not Required\",\n" +
                "            \"ID\": \""+ID4+"\",\n" +
                "            \"RequiredProcess\": \"Post Bind\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Satisfied\",\n" +
                "            \"ID\": \""+ID5+"\",\n" +
                "            \"RequiredProcess\": \"Post Bind\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Not Required\",\n" +
                "            \"ID\": \""+ID6+"\",\n" +
                "            \"RequiredProcess\": \"Post Bind\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Satisfied\",\n" +
                "            \"ID\": \""+ID7+"\",\n" +
                "            \"RequiredProcess\": \"Post Issuance\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubjectivityStatus\": \"Satisfied\",\n" +
                "            \"ID\": \""+ID8+"\",\n" +
                "            \"RequiredProcess\": \"Post Issuance\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"EventName\": \"SaveSubjectivity_5.0.0\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }





   /* public static String saveSubjectivityRequest(String QuoteID, List<Map<String,String>>subjList) throws Exception {

        return"{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \""+PropertyUtils.getValue("UserName")+"\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \""+ PropertyUtils.getValue("OwnerId") +"\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \""+PropertyUtils.getValue("OwnerId")+"\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"Action\": \"Update\",\n" +
                "    \"Type\": \"Subjectivity\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"Subjectivity\": [\n" +
                "    "+subjectivityBuild(subjList)+" \n"+
                "    ],\n" +
                "    \"EventName\": \"SaveSubjectivity_5.0.0\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }

    private static String subjectivityBuild(List<Map<String, String>> subjList)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode request = mapper.createObjectNode();
        ArrayNode subjArray = mapper.createArrayNode();
        for (Map<String, String> subj : subjList) {
            ObjectNode subjNode = mapper.createObjectNode();
            subjNode.put("ID", subj.get("ID"));
            String reqProcess = subj.get("RequiredProcess");
            subjNode.put("RequiredProcess", reqProcess);

            // Conditional logic
            if ("Post Bind".equalsIgnoreCase(reqProcess)) {
                subjNode.put("SubjectivityStatus", "Satisfied");
            } else {
                subjNode.put("SubjectivityStatus", subj.get("SubjectivityStatus"));
            }

            subjArray.add(subjNode);
        }
        request.set("Subjectivity", subjArray);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);

    }*/

}
