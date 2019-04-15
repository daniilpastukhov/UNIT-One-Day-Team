package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Rect;

import java.util.ArrayList;

public class CoordinatesManager {
    /*to do
    get detected box coordinates Rect (x,y,textBoxWidth,textBoxHeight)
    compute text box position
    return Rect  (x,y,textBoxWidth,textBoxHeight)
     */
    private static int textBoxWidth;
    private static int textBoxHeight;
    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;


    private static ArrayList<Rect> textBoxes;

    public static void setTextBoxParams(int[] boxParams){
        textBoxWidth = boxParams[WIDTH];
        textBoxHeight = boxParams[HEIGHT];
    }

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
        if (detectedBox.bottom + Constants.textBoxHeight < Constants.SCREENHEIGHT){
            textBox.top = detectedBox.bottom;
        }
        else if (detectedBox.top - Constants.textBoxHeight >= 0){
            textBox.top = detectedBox.top - Constants.textBoxHeight;
        }
        else if(detectedBox.bottom - Constants.textBoxHeight >= 0){
            textBox.top = detectedBox.bottom - Constants.textBoxHeight;
        }
        else {
            textBox.top = detectedBox.top;
        }
        textBox.bottom = textBox.top + Constants.textBoxHeight;
        if (!isIntersect(textBox)){
            textBoxes.add(textBox);
            return textBox;
        }
        return null;
    }*/

    public static Rect getTextBoxPosition(Rect detectedBox){
        if (textBoxes.size() > Constants.maxObjectsNumber) return null;
        Rect textBox = new Rect();
        /*
        if (detectedBox.left - textBoxWidth >= 0){
            textBox.left = detectedBox.left - textBoxWidth;
        }
        else if (detectedBox.left + textBoxWidth < Constants.SCREENWIDTH){
            textBox.left = detectedBox.left;
        }
        else {
            textBox.left = detectedBox.right - textBoxWidth;
        }*/
        textBox.left = detectedBox.left;
        textBox.right = textBox.left + textBoxWidth;
        textBox.top = detectedBox.top;
        textBox.bottom = textBox.top + textBoxHeight;
        do {
            if (isIntersect(textBox)){
                textBox.top += Constants.boxShift;
                textBox.bottom = textBox.top + textBoxHeight;
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