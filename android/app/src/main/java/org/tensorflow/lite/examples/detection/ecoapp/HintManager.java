package org.tensorflow.lite.examples.detection.ecoapp;

import java.util.HashMap;

public class HintManager {
    private static HashMap<String, String> hints = new HashMap<String, String>() {
        {
            put("person", "Be mindful of what you throw in the trash.");
            put("sandwich", "Stop eating meat (or at least reduce it).");
            put("cup", "Be mindful of what you throw in the trash");
            put("laptop", "If you're still using that old desktop, recycle it and switch to your laptop. ");
            put("tv", "Recycle or donate your old T.V..");
            put("bottle", "Use a refillable water bottle and reusable lunch containers.");
        }
    };

    public static String getHint(String objectName) {
        return objectName + System.getProperty("line.separator") + hints.get(objectName);
    }

    public static void changeText(String key, String newText) {
        hints.remove(key);
        hints.put(key, newText);
    }
}
