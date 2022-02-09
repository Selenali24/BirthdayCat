package com.example.birthdaycat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

/**
 * This class draws a cat onto the surface view
 *
 * CAVEAT: N/A
 *
 * @author Selena Li
 * @version February 8 2022
 */

public class CatView extends SurfaceView {
    public CatModel catModel;

    //Creates paths
    Path ears = new Path();
    Path hat = new Path();
    Path nose = new Path();
    Path bow = new Path();

    //Creates points for paths
    Point leftEar1 = new Point(240, 390);
    Point leftEar2 = new Point(240, 640);
    Point leftEar3 = new Point(360, 420);
    Point rightEar1 = new Point(950, 370);
    Point rightEar2 = new Point(950, 580);
    Point rightEar3 = new Point(820, 410);
    Point hat1 = new Point(565, 330);
    Point hat2 = new Point(820, 395);
    Point hat3 = new Point(780, 130);
    Point nose1 = new Point(600, 750);
    Point nose2 = new Point(570, 710);
    Point nose3 = new Point(630, 710);
    Point leftBow1 = new Point(600, 1050);
    Point leftBow2 = new Point(450, 1000);
    Point leftBow3 = new Point(450, 1100);
    Point rightBow1 = new Point(600, 1050);
    Point rightBow2 = new Point(750, 1000);
    Point rightBow3 = new Point(750, 1100);

    //Creates colors
    Paint white = new Paint();
    Paint black = new Paint();
    Paint red = new Paint();
    Paint lightGray = new Paint();
    Paint pink = new Paint();
    Paint lightPurple = new Paint();
    Paint beige = new Paint();
    Paint myPaint = new Paint();
    int hatDecorations = Color.rgb(242, 207, 157);
    int bowColor = Color.rgb(247, 176, 176);
    int hatColor = Color.rgb(129, 126, 217);
    int catColor = Color.rgb(158, 155, 155);
    int rgbHeadColor = Color.rgb(158, 155, 155);
    int rgbBodyColor = Color.rgb(158, 155, 155);
    int rgbTailColor = Color.rgb(158, 155, 155);
    int rgbTHDColor = Color.rgb(242, 207, 157);
    int rgbMouthColor = Color.rgb(0, 0, 0);
    int rgbBowColor = Color.rgb(247, 176, 176);
    int backgroundColor = Color.rgb(188,223,245);

    /**
     * External Citation
     * Date: Jan 28, 2022
     * Problem: Could not change background of SurfaceView
     * Resource: https://stackoverflow.com/questions/5316686/
     what-is-attributeset-and-how-can-i-use-it#:~:
     text=AttributeSet%20(Android%20Docs),
     can%20do%20so%20with%20AttributeSet%20.
     * Solution: Added AttributeSet to Cat constructor parameters
     */

    /**
     * Cat constructor which initializes variables
     *
     * @param context
     * @param attr
     * @Return N/A
     */
    public CatView(Context context, AttributeSet attr) {
        super(context, attr);

        //allows the onDraw method to be called
        setWillNotDraw(false);

        setBackgroundColor(backgroundColor);

        white.setColor(Color.WHITE);
        black.setColor(Color.BLACK);
        red.setColor(Color.RED);
        lightGray.setColor(catColor);
        lightPurple.setColor(hatColor);
        pink.setColor(bowColor);
        beige.setColor(hatDecorations);
    }

    /**
     * onDraw method
     * Draws each element of the cat
     *
     * @param canvas
     * @Return void
     */
    protected void onDraw(Canvas canvas) {
        for(CustomElement e : catModel.elementArray){
            String textField = (String) catModel.textView.getText();
            String elementName = String.format("%s", e.getName());
            if (textField.equals(elementName)) {
                 myPaint.setColor(e.getColor());
            }
        }

        drawTail(canvas);
        drawArms(canvas);
        drawLegs(canvas);
        drawBody(canvas);
        drawEars(canvas);
        drawHead(canvas);
        drawEyes(canvas);
        drawWhiskers(canvas);
        drawNose(canvas);
        drawMouth(canvas);
        drawHat(canvas);
        drawBow(canvas);

        invalidate();

    }

    /**
     * drawTail method
     *
     * @param canvas
     * @Return void
     */
    public void drawTail(Canvas canvas) {
        Paint tColor = new Paint();
        tColor.setColor(rgbTailColor);
        tColor.setStrokeWidth(20.f);
        canvas.drawLine(900.f, 1100.f, 750.f, 1250.f, tColor);
    }

    /**
     * drawArms method
     *
     * @param canvas
     * @Return void
     */
    public void drawArms(Canvas canvas) {
        //left arm
        canvas.drawOval(360.f, 1100.f, 500.f, 1150.f, lightGray);

        //right arm
        //canvas.drawOval(560.f, 1100.f, 700.f, 1150.f, black);
        canvas.drawOval(700.f, 1100.f, 840.f, 1150.f, lightGray);
    }

    /**
     * drawLegs method
     *
     * @param canvas
     * @Return void
     */
    public void drawLegs(Canvas canvas) {
        //left leg
        canvas.drawOval(510.f, 1300.f, 570.f, 1370.f, lightGray);

        //right leg
        canvas.drawOval(640.f, 1300.f, 700.f, 1370.f, lightGray);
    }

    /**
     * drawBody method
     *
     * @param canvas
     * @Return void
     */
    public void drawBody(Canvas canvas) {
        Paint bColor = new Paint();
        bColor.setColor(rgbBodyColor);
        canvas.drawCircle(600.f, 1150.f, 200.f, bColor);
    }

    /**
     * External Citation
     * Date: Jan 30, 2022
     * Problem: Could not figure out how to draw triangles
     * Resource: https://www.semicolonworld.com/question/47862/
     * how-to-draw-a-filled-triangle-in-android-canvas
     * Solution: Used some parts of the code example and modified
     * it for my own desired output
     */

    /**
     * drawEars method
     * Draws a triangle shaped path
     *
     * @param canvas
     * @Return void
     */
    public void drawEars(Canvas canvas) {
        //Left ear
        ears.moveTo(leftEar1.x, leftEar1.y);
        ears.lineTo(leftEar2.x, leftEar2.y);
        ears.lineTo(leftEar3.x, leftEar3.y);
        ears.lineTo(leftEar1.x, leftEar1.y);
        ears.close();
        canvas.drawPath(ears, lightGray);

        //Right ear
        ears.moveTo(rightEar1.x, rightEar1.y);
        ears.lineTo(rightEar2.x, rightEar2.y);
        ears.lineTo(rightEar3.x, rightEar3.y);
        ears.lineTo(rightEar1.x, rightEar1.y);
        ears.close();
        canvas.drawPath(ears, lightGray);
    }

    /**
     * drawHead method
     *
     * @param canvas
     * @Return void
     */
    public void drawHead(Canvas canvas) {
        Paint hColor = new Paint();
        hColor.setColor(rgbHeadColor);
        canvas.drawCircle(600.f, 700.f, 375.f, hColor);
    }

    /**
     * drawEyes method
     *
     * @param canvas
     * @Return void
     */
    public void drawEyes(Canvas canvas) {
        //left eye
        canvas.drawOval(450.f, 620.f, 500.f, 670.f, black);

        //right eye
        canvas.drawOval(700.f, 620.f, 750.f, 670.f, black);
    }

    /**
     * drawWhiskers method
     *
     * @param canvas
     * @Return void
     */
    public void drawWhiskers(Canvas canvas) {
        white.setStrokeWidth(4.f);

        //left side
        canvas.drawLine(500.f, 725.f, 380.f, 700.f, white);
        canvas.drawLine(500.f, 740.f, 380.f, 740.f, white);
        canvas.drawLine(500.f, 755.f, 380.f, 790.f, white);

        //right side
        canvas.drawLine(700.f, 725.f, 820.f, 700.f, white);
        canvas.drawLine(700.f, 740.f, 820.f, 740.f, white);
        canvas.drawLine(700.f, 755.f, 820.f, 790.f, white);
    }

    /**
     * drawNose method
     * Draws a triangle shaped path
     *
     * @param canvas
     * @Return void
     */
    public void drawNose(Canvas canvas) {
        nose.moveTo(nose1.x, nose1.y);
        nose.lineTo(nose2.x, nose2.y);
        nose.lineTo(nose3.x, nose3.y);
        nose.lineTo(nose1.x, nose1.y);
        nose.close();
        canvas.drawPath(nose, black);
    }

    /**
     * drawMouth method
     *
     * @param canvas
     * @Return void
     */
    public void drawMouth(Canvas canvas) {
        Paint mColor = new Paint();
        mColor.setColor(rgbMouthColor);
        canvas.drawOval(575.f, 820.f, 625.f, 880.f, mColor);
    }

    /**
     * drawHat method
     *
     * @param canvas
     * @Return void
     */
    public void drawHat(Canvas canvas) {
        Paint thdColor = new Paint();
        thdColor.setColor(rgbTHDColor);

        //draws triangle hat
        hat.moveTo(hat1.x, hat1.y);
        hat.lineTo(hat2.x, hat2.y);
        hat.lineTo(hat3.x, hat3.y);
        hat.lineTo(hat1.x, hat1.y);
        hat.close();
        canvas.drawPath(hat, lightPurple);

        //draws circular pompom on top of hat
        canvas.drawCircle(780.f, 120, 40, thdColor);

        //draws bottom design of hat
        canvas.drawCircle(600.f, 320.f, 30, beige);
        canvas.drawCircle(650.f, 335.f, 30, beige);
        canvas.drawCircle(700.f, 350.f, 30, beige);
        canvas.drawCircle(750.f, 365.f, 30, beige);
        canvas.drawCircle(800.f, 380.f, 30, beige);
    }

    /**
     * drawBow method
     *
     * @param canvas
     * @Return void
     */
    public void drawBow(Canvas canvas) {
        Paint bColor = new Paint();
        bColor.setColor(rgbBowColor);

        //left triangle
        bow.moveTo(leftBow1.x, leftBow1.y);
        bow.lineTo(leftBow2.x, leftBow2.y);
        bow.lineTo(leftBow3.x, leftBow3.y);
        bow.lineTo(leftBow1.x, leftBow1.y);
        bow.close();
        canvas.drawPath(bow, bColor);

        //right triangle
        bow.moveTo(rightBow1.x, rightBow1.y);
        bow.lineTo(rightBow2.x, rightBow2.y);
        bow.lineTo(rightBow3.x, rightBow3.y);
        bow.lineTo(rightBow1.x, rightBow1.y);
        bow.close();
        canvas.drawPath(bow, bColor);

        //draws middle circle
        canvas.drawCircle(600.f, 1050.f, 15, black);
    }

    /**
     * setModel method
     * Sets the Model for this View class
     *
     * @param initModel
     * @Return void
     */
    public void setModel(CatModel initModel){

        this.catModel = initModel;
    }

    /**
     * setColor method
     * Sets the color
     *
     * @param color
     * @Return void
     */
    public void setColor(int color) {

        if (color == myPaint.getColor()) return;
        this.myPaint.setColor(color);
    }

    /**
     * setHeadColor method
     * Sets the color for head element based on rgb seekbars
     *
     * @param color
     * @Return void
     */
    public void setHeadColor(int color) {

        rgbHeadColor = color;
    }

    /**
     * setBodyColor method
     * Sets the body color
     *
     * @Param color
     * @Return void
     */
    public void setBodyColor(int color) {
        rgbBodyColor = color;
    }

    /**
     * setTailColor method
     * Sets the tail color
     *
     * @Param color
     * @Return void
     */
    public void setTailColor(int color) {

        rgbTailColor = color;
    }

    /**
     * setMouthColor method
     * Sets the mouth color
     *
     * @Param color
     * @Return void
     */
    public void setMouthColor(int color) {

        rgbMouthColor = color;
    }

    /**
     * setBowColor method
     * Sets the bow color
     *
     * @Param color
     * @Return void
     */
    public void setBowColor(int color) {
        rgbBowColor = color;
    }

    /**
     * setTHDColor method
     * Sets the top hat decoration color
     *
     * @Param color
     * @Return void
     */
    public void setTHDColor(int color) {

        rgbTHDColor = color;
    }

    /**
     * getColor method
     * Gets the color for the setter
     *
     * @Return int
     */
    public int getColor() {

        return this.myPaint.getColor();
    }
}