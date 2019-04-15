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
            put("book", "Read as much as you can to become stronger.");
            put("cell phone", "The manufacturing process generates waste that is 200 times the weight of the phone.");
            put("mouse", "It's impossible to imagine our existence without this small friend ");
            put("keyboard", "Type regular characters and to take advantage of the keyboard shortcuts.");
            put("refrigerator", "Try to save energy wasting by refrigerator");
            put("backpack", "Take any trip you wish with the pack on your back");
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
