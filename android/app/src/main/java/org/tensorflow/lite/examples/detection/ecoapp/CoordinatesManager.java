package org.tensorflow.lite.examples.detection.ecoapp;

import android.graphics.Rect;

public class CoordinatesManager {
    /*to do
    get detected box coordinates Rect (x,y,width,height)
    compute text box position
    return Rect  (x,y,width,height)
     */
    public static Rect getTextBoxPosition(Rect detectedBox) {
        Rect boxParams = new Rect();
        if (detectedBox.left + Constants.textBoxWidth < Constants.SCREENWIDTH){
            boxParams.left = detectedBox.left;
        }
        else{
            boxParams.left = Constants.SCREENWIDTH - Constants.textBoxWidth;
        }
        boxParams.right = boxParams.left + Constants.textBoxWidth;

        return boxParams;
    }

    private boolean checkCorner(boolean up, int x, int y){
        int posCoef = (up)? -1:1;
        return true;
    }
}