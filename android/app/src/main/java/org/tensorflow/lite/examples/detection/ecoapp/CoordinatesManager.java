package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Rect;

import java.util.ArrayList;

public class CoordinatesManager {
    /*to do
    get detected box coordinates Rect (x,y,width,height)
    compute text box position
    return Rect  (x,y,width,height)
     */
    private static int width;
    private static int height;
    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;


    private static ArrayList<Rect> textBoxes;

    public static void setTextBoxParams(int[] boxParams){
        width = boxParams[WIDTH];
        height = boxParams[HEIGHT];
    }

    public static void clearTextBoxes(){
        textBoxes = new ArrayList<>();
    }
/*
    public static Rect getTextBoxPosition(Rect detectedBox) {
        Rect textBox = new Rect();
        //join left
        if (detectedBox.left + Constants.width < Constants.SCREENWIDTH){
            textBox.left = detectedBox.left;
        }
        else if(detectedBox.left - Constants.width >= 0){
            textBox.left = detectedBox.left - Constants.width;
        }
        else{
            textBox.left = detectedBox.right - Constants.width;
        }
        textBox.right = textBox.left + Constants.width;
        //join top
        if (detectedBox.bottom + Constants.height < Constants.SCREENHEIGHT){
            textBox.top = detectedBox.bottom;
        }
        else if (detectedBox.top - Constants.height >= 0){
            textBox.top = detectedBox.top - Constants.height;
        }
        else if(detectedBox.bottom - Constants.height >= 0){
            textBox.top = detectedBox.bottom - Constants.height;
        }
        else {
            textBox.top = detectedBox.top;
        }
        textBox.bottom = textBox.top + Constants.height;
        if (!isIntersect(textBox)){
            textBoxes.add(textBox);
            return textBox;
        }
        return null;
    }*/

    public static Rect getTextBoxPosition(Rect detectedBox){
        Rect textBox = new Rect();
        if (detectedBox.left - width >= 0){
            textBox.left = detectedBox.left - width;
        }
        else if (detectedBox.left + width < Constants.SCREENWIDTH){
            textBox.left = detectedBox.left;
        }
        else {
            textBox.left = detectedBox.right - width;
        }
        textBox.right = textBox.left + width;
        textBox.top = detectedBox.top;
        textBox.bottom = textBox.top + height;
        do {
            if (isIntersect(textBox)){
                textBox.top += Constants.boxShift;
                textBox.bottom = textBox.top + height;
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