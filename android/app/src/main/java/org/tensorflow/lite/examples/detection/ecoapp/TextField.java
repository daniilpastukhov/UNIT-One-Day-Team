package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import org.tensorflow.lite.examples.detection.env.BorderedText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextField {
    private BorderedText borderedText;

    private static final char NEWLINE = '\n';
    private static final String SPACE_SEPARATOR = " ";
    private static final String SPLIT_REGEXP= "\\s+";
    private static final int rowLength = 30;

    public TextField() {
        borderedText = new BorderedText(20);

    }

    public TextField(final int textSize) {
        borderedText = new BorderedText(textSize);
    }

    public int[] getTextBoxSize(String hint) {
        int size[] = new int[2];
        List<String> parts = splitString(hint, rowLength);

        Rect bounds = new Rect();
        Paint paint = new Paint();
        paint.getTextBounds(hint, 0, rowLength, bounds);
        int height = bounds.height() * 2;
        for (int i = 0; i < parts.size(); i++) { height += 50; }
        size[0] = bounds.width();
        size[1] = height;
        return size; // width x height
    }

    // int[] coords - 4 coordinates of box model
    // String hint - string which contains a hint (max. 100 letters)
    public void drawTextField(Canvas canvas, int x, int y, String hint) {
        List<String> parts = splitString(hint, rowLength);
        y += 50;
        for (int i = 0; i < parts.size(); i++) {
            borderedText.drawText(canvas, x, y, parts.get(i));
            y += 50;
        }
    }

    public static List<String> splitString(String msg, int lineSize) {
        List<String> res = new ArrayList<>();

        Pattern p = Pattern.compile("\\b.{1," + (lineSize-1) + "}\\b\\W?");
        Matcher m = p.matcher(msg);

        while(m.find()) {
            res.add(m.group());
        }
        return res;
    }
}