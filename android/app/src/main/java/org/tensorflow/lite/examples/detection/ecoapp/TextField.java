package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Canvas;
import android.graphics.Rect;

import org.tensorflow.lite.examples.detection.env.BorderedText;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TextField {
    private BorderedText borderedText;

    private static final char NEWLINE = '\n';
    private static final String SPACE_SEPARATOR = " ";
    private static final String SPLIT_REGEXP= "\\s+";

    public TextField() {
        borderedText = new BorderedText(20);
    }

    public TextField(final int textSize) {
        borderedText = new BorderedText(textSize);
    }

    // int[] coords - 4 coordinates of box model
    // String hint - string which contains a hint (max. 100 letters)
    public void drawTextField(Canvas canvas, int x, int y, String hint) {
        String[] parts = breakLines(hint, 20);
        for (int i = 0; i < 5; i++) {
            borderedText.drawText(canvas, x, y, parts[i]);
            y += 50;
        }
    }

    private String[] breakLines(String input, int maxLineLength) {
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (lineLen + word.length() > maxLineLength) {
                output.append("\n");
                lineLen = 0;
            }
            output.append(word);
            lineLen += word.length();
        }
        return output.toString().split("\n");
    }
}