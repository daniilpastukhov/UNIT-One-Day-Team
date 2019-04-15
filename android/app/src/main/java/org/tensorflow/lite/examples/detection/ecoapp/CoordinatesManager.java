package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Rect;

import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class CoordinatesManager {
    /*to do
    get detected box coordinates Rect (x,y,width,height)
    compute text box position
    return Rect  (x,y,width,height)
     */
    private static ArrayList<Rect> textBoxes;

    public static void clearTextBoxes(){
        textBoxes = new ArrayList<>();
    }
/*
    public static Rect getTextBoxPosition(Rect detectedBox) {
        Rect textBox = new Rect();
        //join left
        if (detectedBox.left + Constants.textBoxWidth < Constants.SCREENWIDTH){
            textBox.left = detectedBox.left;
        }
        else if(detectedBox.left - Constants.textBoxWidth >= 0){
            textBox.left = detectedBox.left - Constants.textBoxWidth;
        }
        else{
            textBox.left = detectedBox.right - Constants.textBoxWidth;
        }
        textBox.right = textBox.left + Constants.textBoxWidth;
        //join top
        if (detectedBox.bottom + Constants.textBoxWHeight < Constants.SCREENHEIGHT){
            textBox.top = detectedBox.bottom;
        }
        else if (detectedBox.top - Constants.textBoxWHeight >= 0){
            textBox.top = detectedBox.top - Constants.textBoxWHeight;
        }
        else if(detectedBox.bottom - Constants.textBoxWHeight >= 0){
            textBox.top = detectedBox.bottom - Constants.textBoxWHeight;
        }
        else {
            textBox.top = detectedBox.top;
        }
        textBox.bottom = textBox.top + Constants.textBoxWHeight;
        if (!isIntersect(textBox)){
            textBoxes.add(textBox);
            return textBox;
        }
        return null;
    }*/

    public static Rect getTextBoxPosition(Rect detectedBox){
        Rect textBox = new Rect();
        if (detectedBox.left - Constants.textBoxWidth >= 0){
            textBox.left = detectedBox.left - Constants.textBoxWidth;
        }
        else if (detectedBox.left + Constants.textBoxWidth < Constants.SCREENWIDTH){
            textBox.left = detectedBox.left;
        }
        else {
            textBox.left = detectedBox.right - Constants.textBoxWidth;
        }
        textBox.right = textBox.left + Constants.textBoxWidth;
        textBox.top = detectedBox.top;
        textBox.bottom = textBox.top + Constants.textBoxWHeight;
        do {
            if (isIntersect(textBox)){
                textBox.top += Constants.boxShift;
                textBox.bottom = textBox.top + Constants.textBoxWHeight;
            }else {
                textBoxes.add(textBox);
                return textBox;
            }
        } while (textBox.top < detectedBox.bottom - Constants.boxShift);
        return null;
    }

    private static boolean isIntersect(Rect textBox){
        for (Rect box: textBoxes){
            if (Rect.intersects(textBox, box)){
                return true;
            }
        }
        return false;
    }
}