package CommonFunctions;

import FrameWork.FrameWorkPilot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResponseSaver {

    public static void saveResponse(String iteration, String stringResponseObject, String JsonName){

        try {
            Files.writeString(Path.of(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+iteration+"\\Response\\"+JsonName+".txt"),stringResponseObject, StandardCharsets.UTF_8);
//            Path filePath = Path.of(FrameWorkPilot.getDynamicPath("resultDir"),iteration,"Response",JsonName+".txt");
//            Files.createDirectories(filePath.getParent());
//            Files.writeString(filePath,stringResponseObject,StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}
