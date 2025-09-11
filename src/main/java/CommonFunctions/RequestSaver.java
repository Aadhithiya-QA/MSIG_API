package CommonFunctions;

import FrameWork.FrameWorkPilot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class RequestSaver {

    public static void saveRequest(String iteration, String stringRequestObject, String JsonName){

        try {
            Files.writeString(Path.of(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+iteration+"\\Request\\"+JsonName+".txt"),stringRequestObject, StandardCharsets.UTF_8);
//            Path filePath = Path.of(FrameWorkPilot.getDynamicPath("resultDir"),iteration,"Request",JsonName+".txt");
//            Files.createDirectories(filePath.getParent());
//            Files.writeString(filePath,stringRequestObject,StandardCharsets.UTF_8);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}
