package DataProviderUtil;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    private MapUtils() {
        // prevent instantiation
    }

    public static Map<String, String> toStringMap(Map<String, Object> objectMap) {
        Map<String, String> stringMap = new HashMap<>();
        if (objectMap != null) {
            for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                stringMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return stringMap;
    }
}
