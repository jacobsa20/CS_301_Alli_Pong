package com.example.jacobsa20.pong;

import android.graphics.*;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.jacobsa20.animation.Animator;

import java.util.Random;

/**
 * Created by jacobsa20 on 3/19/2018.
 **/

/**
 * EXTERNAL CITATION
 * Date: 3/19/2018
 * Problem: needed help getting started on PongGame class
 * Because I'm supposed to delete the testAnimator class
 * Resource: TestAnimator code by Nux and Vegdahl.
 * Solution: I used the code present
 * (I don't know if this is citation worthy, but better safe
 * than sorry)
 */

public class PongGame implements Animator {

    // instance variables
    private boolean backwards = false; // whether clock is ticking backwards
    private boolean backwardsy= false;
    Random rand = new Random();
    int speed= rand.nextInt(15);
    int ballPlaceX= rand.nextInt(880);//places ball anywhere on the top of game
    private int move = ballPlaceX; // counts the number of logical clock ticks
    private int movey= 0;

    @Override
    public int interval() {

        return speed;
    }

    @Override
    public int backgroundColor() {
        //makes background color black
        return Color.BLACK;
    }
    public void goBackwards(boolean b) {
        // set the instance variable
        backwards = b;
    }

    @Override
    public boolean doPause() {
        return false;
    }

    @Override
    public boolean doQuit() {
        return false;
    }

    @Override
    public void tick(Canvas g) {

        int j= rand.nextInt(1000);
        Paint wall= new Paint();
        wall.setColor(Color.WHITE);
        //I hard coded the sizes of the walls so then I can add buttons later
        g.drawRect(0f,0f,1770f,10f,wall);
        g.drawRect(0f,0f,10f,1000f,wall);
        g.drawRect(0f,990f,1770f,1000f,wall);
        //paddle
        g.drawRect(1750f,400f,1760f,600f,wall);

        if (backwards) {move--;}
        else {move++;}

        if (backwardsy) {movey--;}
        else {movey++;}

        int xnum = (move*speed);
        int ynum = (movey*speed);
        if (xnum < 0) xnum += 1000;
        if (ynum < 0) ynum += 1000;
        if (xnum==0){backwards=!backwards;}
        if (ynum==0 || ynum>= 990){backwardsy=!backwardsy;}
        if (xnum>=1740){
            if (ynum>400 && ynum<600){backwards=!backwards;}
            else {move = j;}
        }
        g.drawCircle(xnum, ynum, 15, wall);

        for(int i=0;i<100;i++){

         //   int xPos=rand.nextInt(xnum);
          //  int yPos=rand.nextInt(ynum);
            wall.setColor(Color.rgb(175, 238, 247));
            g.drawCircle(xnum+(i), ynum+(i), 15, wall);
            i++;
        }

    }

    @Override
    public void onTouch(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            backwards = !backwards;
        }

    }

}

