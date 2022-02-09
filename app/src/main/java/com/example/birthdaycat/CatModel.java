package com.example.birthdaycat;

import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This class declares the variables for drawing
 *
 * CAVEAT: N/A
 *
 * @author Selena Li
 * @version February 8 2022
 */

public class CatModel {
    //array of elements
    public ArrayList<CustomElement> elementArray;

    public TextView textView;

    /**
     * CatModel method
     * Allows the textView to change as the user taps on an element
     *
     * @param initText
     */
    public CatModel(TextView initText) {
        elementArray = new ArrayList<>();
        this.textView = initText;
    }

    /**
     * setTextView method
     * Sets the textView
     *
     * @param text
     * @Return void
     */
    public void setTextView(TextView text) {
        this.textView = text;
    }

    /**
     * addElement method
     * Individually adds elements into elementArray
     *
     * @param e
     * @Return void
     */
    public void addElement(CustomElement e){
        elementArray.add(e);
    }
}
