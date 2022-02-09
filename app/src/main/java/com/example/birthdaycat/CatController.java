package com.example.birthdaycat;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * This class updates the color of each element as the user moves the seekbar and taps on the screen
 *
 * CAVEAT: When user taps on an element, the default color changes to a neon-like green
 *
 * @author Selena Li
 * @version February 8 2022
 */

/**
 * External Citation
 * Date: Feb 7, 2022
 * Problem: Could not figure out how to do the entire rgb color-changing
 * Resource: Jake Uyechi
 * Solution: Used his method of using arrays for each element object and rgb values
 */

public class CatController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    //Instance variables
    public int color;
    public String name;
//    public TextView rVal;
//    public TextView gVal;
//    public TextView bVal;

    // variables
    private CatView catView = null;
    private CatModel catModel = null;
    private TextView elementTV = null;
    private SeekBar redBar = null;
    private SeekBar greenBar = null;
    private SeekBar blueBar = null;
    //private TextView updateValue = null;

    /**
     * CatController constructor
     * Converts hex decimal to three individual rgb values
     *
     * @param initCat
     * @param initModel
     * @param initText
     * @param redBar
     * @param greenBar
     * @param blueBar
     */
    public CatController(CatView initCat, CatModel initModel,
                         TextView initText, SeekBar redBar,
                         SeekBar greenBar, SeekBar blueBar) {
        this.catView = initCat;
        this.catModel = initModel;
        this.elementTV = initText;
        this.redBar = redBar;
        this.greenBar = greenBar;
        this.blueBar = blueBar;
    }

    /**
     * onTouch method
     * When the user taps on the screen, the name and color of the element is set
     *
     * @param v is built into View and is needed for onTouch
     * @param event is built into MotionEvent and is needed for onTouch
     * @Return boolean
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        catView.invalidate();

        // get position coordinates from motionEvent
        int x = (int) event.getX();
        int y = (int) event.getY();

        for (CustomElement e : catModel.elementArray) {
            if (e.containsPoint(x, y)) {
                elementTV.setText(String.format("%s", e.getName()));

                int[] rgb = hexToRGB(e.getColor());
                redBar.setProgress(rgb[0]);
                greenBar.setProgress(rgb[1]);
                blueBar.setProgress(rgb[2]);
            }
        }
        return false;
    }

    /**
     * onProgressChanged method
     * Updates/sets new values according to how the seekBar values change
     *
     * @param seekBar  is a SeekBar built into the method
     * @param progress is an int value from seekBar
     * @param fromUser is a boolean built into the method
     * @Return void
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //updates rgb values as seekbar moves [0-255]
        //this.updateValue.setText("" + progress);
        catView.invalidate();

        //sets color from SeekBars
        color = Color.rgb(redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress());

        //determines the current selected object
        for(CustomElement e : catModel.elementArray){
            String textField = (String) elementTV.getText();
            String elementName = String.format("%s", e.getName());

            if (textField.equals(elementName)) {
                e.setColor(color);
                name = elementName;
                customRGB(color, name);
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {} //does nothing

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {} //does nothing

    /**
     * hexToRGB method
     * Converts hex decimal to three individual rgb values
     *
     * @param hex
     * @Return int[]
     */
    public int[] hexToRGB(int hex) {
        //holds red, green, and blue values
        int[] rgb = new int[3];

        //separates each rgb value
        rgb[0] = (0x00FF0000 & hex) >> 16;
        rgb[1] = (0x0000FF00 & hex) >> 8;
        rgb[2] = (0x000000FF & hex);

        return rgb;
    }

    /**
     * customRGB method
     * Sets color of each element as user taps and moves the seekbars
     *
     * @param rgb
     * @param n
     * @Return void
     */
    public void customRGB(int rgb, String n) {
        switch (n) {
            case "Head":
                catView.setHeadColor(rgb);
                break;
            case "Body":
                catView.setBodyColor(rgb);
                break;
            case "Bow":
                catView.setBowColor(rgb);
                break;
            case "Top Hat Decor":
                catView.setTHDColor(rgb);
                break;
            case "Tail":
                catView.setTailColor(rgb);
                break;
            case "Mouth":
                catView.setMouthColor(rgb);
                break;
            default:
                break;
        }
    }
}


