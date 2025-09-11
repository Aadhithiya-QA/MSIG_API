package CommonFunctions;

import io.restassured.path.json.JsonPath;

import java.io.File;

public class ParamGetter {

    public synchronized static String getPropertyUsingPath(String fileLocation, String path){

        JsonPath jsonPath =new JsonPath(new File(fileLocation));
        return jsonPath.getString(path);

    }

}