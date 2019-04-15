package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Color;
import android.text.TextPaint;

import org.tensorflow.lite.examples.detection.env.BorderedText;

public class TextField {
    private final BorderedText borderedText;

    TextField() {
        borderedText = new BorderedText(Color.WHITE, Color.BLACK, 40);
    }

    TextField(final int textSize) {
        borderedText = new BorderedText(textSize);
    }

    // int[] coords - 4 coordinates of box model
    // String hint - string which contains a hint (max. 100 letters)
    public void drawTextField(int[] coords, String hint) {
        // TODO
        borderedText.drawText();



    }
}
