package RequestBuilder;

import Utilities.PropertyUtils;
import com.github.javafaker.Dune;

public class DiaryNotes {

    public static String diaryNotesSingleRequest(String QuoteID,String SubjectivityID){

        return "{\n" +
                "    \"ServiceRequestDetail\": {\n" +
                "        \"ServiceRequestVersion\": \"1.0\",\n" +
                "        \"LanguageCode\": \"en\",\n" +
                "        \"UserName\": \"MsigExcess\",\n" +
                "        \"RegionCode\": \"\",\n" +
                "        \"OwnerId\": \"16573\",\n" +
                "        \"UserRole\": \"Admin\",\n" +
                "        \"Token\": \""+PropertyUtils.getValue("Token")+"\",\n" +
                "        \"ServiceResponseVersion\": \"1.0\",\n" +
                "        \"ResponseType\": \"json\"\n" +
                "    },\n" +
                "    \"OwnerId\": \"16573\",\n" +
                "    \"ID\": \""+QuoteID+"\",\n" +
                "    \"Action\": \"Add\",\n" +
                "    \"Type\": \"Diary Notes\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"SubjectivityNotes\": [\n" +
                "        {\n" +
                "            \"PARENTID\": \""+QuoteID+"\",\n" +
                "            \"ROOTID\": \""+QuoteID+"\",\n" +
                "            \"NotesDescription\": \"<p>TestNotes2</p>\",\n" +
                "            \"DiaryNoteDateCreated\": \"10/13/2025\",\n" +
                "            \"SubjectivityID\": [\n" +
                "                \""+SubjectivityID+"\"\n" +
                "            ],\n" +
                "            \"Name\": \"TestNotes2\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"EventName\": \"SaveSubjectivity_5.0.0\",\n" +
                "    \"ProductVerNumber\": \"SWP_16573_14_V1\",\n" +
                "    \"ProductNumber\": \"SWP_16573_14\"\n"+
                "}\n";

    }

    public static String diaryNotesMultipleRequest(String QuoteID, String ID1,String ID2,String ID3){

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
                "    \"Action\": \"Add\",\n" +
                "    \"Type\": \"Diary Notes\",\n" +
                "    \"RepositoryName\": \"Quote\",\n" +
                "    \"SubjectivityNotes\": [\n" +
                "        {\n" +
                "            \"PARENTID\": \""+QuoteID+"\",\n" +
                "            \"ROOTID\": \""+QuoteID+"\",\n" +
                "            \"NotesDescription\": \"<p>TestNotes2</p>\",\n" +
                "            \"DiaryNoteDateCreated\": \"09/03/2025\",\n" +
                "            \"SubjectivityID\": [\n" +
                "                \""+ID1+"\",\n" +
                "                \""+ID2+"\",\""+ID3+"\",\n" +
                "            ],\n" +
                "            \"Name\": \"TestNotes2\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"EventName\": \"SaveSubjectivity_5.0.0\",\n" +
                "    \"ProductVerNumber\": \""+PropertyUtils.getValue("ProductVerNumber")+"\",\n" +
                "    \"ProductNumber\": \""+PropertyUtils.getValue("ProductNumber")+"\"\n" +
                "}";

    }

}
