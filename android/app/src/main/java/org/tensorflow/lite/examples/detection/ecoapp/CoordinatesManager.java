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

        if (detectedBox.bottom + Constants.textBoxWHeight < Constants.SCREENHEIGHT){
            boxParams.top = detectedBox.bottom;
        }
        else if (detectedBox.top - Constants.textBoxWHeight >= 0){
            boxParams.top = detectedBox.top - Constants.textBoxWHeight;
        }
        else if(detectedBox.bottom - Constants.textBoxWHeight >= 0){
            boxParams.top = detectedBox.bottom - Constants.textBoxWHeight;
        }
        else {
            boxParams.top = detectedBox.top;
        }
        boxParams.bottom = boxParams.top + Constants.textBoxWHeight;
        return boxParams;
    }
}