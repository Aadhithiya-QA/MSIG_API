package CommonFunctions;

import FrameWork.FrameWorkPilot;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;

public class CarrierExtractor {

    public static String buildPreferredCarrierBlock(String carrierDisplayName, String iteration) {
        try {
            // Locate the response file
            String filePath = FrameWorkPilot.getDynamicPath("resultDir") + "\\" + iteration + "\\Response\\GetAvailableMarket Response.txt";
            File responseFile = Paths.get(filePath).toFile();

            // Parse JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseFile);

            // Navigate to SelectedCarriers (assuming response structure has it)
            JsonNode carriers = root.at("/SelectedSublines/0/SelectedCarriers");
            if (carriers.isMissingNode() || !carriers.isArray()) {
                throw new RuntimeException("No carriers found in GetAvailableMarket response");
            }

            // Find matching carrier
            for (JsonNode carrier : carriers) {
                String displayName = carrier.path("CarrierDisplayName").asText();
                if (displayName.equalsIgnoreCase(carrierDisplayName)) {
                    // Build PreferredCarrier JSON fragment
                    return "{\n" +
                            "                    \"SublineName\": \"GL\",\n" +
                            "                    \"CarrierName\": \""+carrier.path("CarrierName").asText()+"\",\n" +
                            "                    \"CarrierID\": \""+carrier.path("CarrierID").asText()+"\",\n" +
                            "                    \"CarrierAddress\": \"\",\n" +
                            "                    \"AMBESTRATING\": \"A+\",\n" +
                            "                    \"CarrierType\": \"Admitted\",\n" +
                            "                    \"State\": \""+carrier.path("State").asText()+"\",\n" +
                            "                    \"CarrierCode\": \""+carrier.path("CarrierCode").asText()+"\",\n" +
                            "                    \"ProductVerNumber\": \"SWP_16573_14_V1\",\n" +
                            "                    \"CarrierDisplayName\": \""+displayName+"\",\n" +
                            "                    \"AdmittedCarrier\": \"Y\",\n" +
                            "                    \"ProductNumber\": \"SWP_16573_14\"\n" +
                            "                }";
                }
            }

            throw new RuntimeException("Carrier not found: " + carrierDisplayName);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
