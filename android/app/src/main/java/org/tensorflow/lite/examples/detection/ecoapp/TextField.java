package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Canvas;

import org.tensorflow.lite.examples.detection.env.BorderedText;

public class TextField {
    private final BorderedText borderedText;

    TextField() {
        borderedText = new BorderedText(40);
    }

    TextField(final int textSize) {
        borderedText = new BorderedText(textSize);
    }

    // int[] coords - 4 coordinates of box model
    // String hint - string which contains a hint (max. 100 letters)
    public void drawTextField(Canvas canvas, final int x, final int y, String hint) {
        borderedText.drawText(canvas, x, y, hint);
    }
}
