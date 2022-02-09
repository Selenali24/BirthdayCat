package com.example.birthdaycat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * This class sets up the rgb TextViews and Seekbars
 *
 * CAVEAT: N/A
 *
 * @author Selena Li
 * @version February 8 2022
 */

public class MainActivity extends AppCompatActivity {

    /**
     * onCreate method
     *
     * @param savedInstanceState
     * @Return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CatView catView = findViewById(R.id.surfaceView);
        TextView text = findViewById(R.id.elementTextView);


        CatModel catModel = new CatModel(text);
        catView.setModel(catModel);

        SeekBar redBar = findViewById(R.id.redSeekBar);
        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        SeekBar blueBar = findViewById(R.id.blueSeekBar);

        catModel.setTextView(text);

        CatController catController = new CatController(catView, catModel, text, redBar, greenBar, blueBar);

        catView.setOnTouchListener(catController);

        redBar.setOnSeekBarChangeListener(catController);
        greenBar.setOnSeekBarChangeListener(catController);
        blueBar.setOnSeekBarChangeListener(catController);

        drawCat(catModel);

        //Sets the rgb values on seekbars
        //TextView rValue = findViewById(R.id.redValue);
//        SeekBar.OnSeekBarChangeListener redSBListener = new CatController(rValue);
        //TextView gValue = findViewById(R.id.greenValue);
//        SeekBar.OnSeekBarChangeListener greenSBListener = new CatController(gValue);
        //TextView bValue = findViewById(R.id.blueValue);
//        SeekBar.OnSeekBarChangeListener blueSBListener = new CatController(bValue);

        //Sets the space changer on rgb seekbars
//        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
//        redSeekBar.setOnSeekBarChangeListener(redSBListener);
//        redSeekBar.setProgress(0);
//        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
//        greenSeekBar.setOnSeekBarChangeListener(greenSBListener);
//        greenSeekBar.setProgress(0);
//        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
//        blueSeekBar.setOnSeekBarChangeListener(blueSBListener);
//        blueSeekBar.setProgress(0);
    }

    /**
     * drawCat method
     * Draws a cat from a given CatModel array
     *
     * @param catModel
     * @Return void
     */
    public void drawCat(CatModel catModel){
        catModel.addElement(new CustomCircle("Head", 0xFF98FF98, 600, 700, 375));
        catModel.addElement(new CustomCircle("Body", 0xFF98FF98, 600, 1150, 200));
        catModel.addElement(new CustomCircle("Top Hat Decor", 0xFF98FF98, 780, 120, 40));
        catModel.addElement(new CustomRect("Tail", 0xFF98FF98, 800, 1100, 900, 1250));
        catModel.addElement(new CustomCircle("Mouth", 0xFF98FF98, 600, 850, 30));
        catModel.addElement(new CustomRect("Bow", 0xFF98FF98, 490, 1000, 750, 1110));

    }
}