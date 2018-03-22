package com.example.jacobsa20.pong;

import android.graphics.*;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.jacobsa20.animation.Animator;

import java.util.ArrayList;
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
    private int xnums;
    private int ynums;
    private boolean backwardsx = false; // whether clock is ticking backwards
    private boolean backwardsy= false;
    Random rand = new Random();
    int speed= rand.nextInt(15);
    int ballPlaceX= rand.nextInt(880);//places ball anywhere on the top of game
    private int movex = ballPlaceX; // counts the number of logical clock ticks
    private int movey= 0;

    ArrayList<Ball>allBalls= new ArrayList<>();

    @Override
    public int interval() {
        return 0;
    }

    @Override
    public int backgroundColor() {
        //makes background color black
        return Color.BLACK;
    }
    public void goBackwards(boolean b) {
        // set the instance variable
        backwardsx = b;
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
    public void tick(Canvas g){//draws walls, ball, and controls motion of ball

        if(allBalls.isEmpty()){
            allBalls.add(new Ball(ballPlaceX,0,speed,
                    rand.nextBoolean(),rand.nextBoolean()));
        }

        int j= rand.nextInt(1000);
        Paint wall= new Paint();
        wall.setColor(Color.WHITE);
        //I hard coded the sizes of the walls because I wanted the game to be
        //smaller than the height of the screen
        g.drawRect(0f,0f,1770f,10f,wall);
        g.drawRect(0f,0f,10f,1000f,wall);
        g.drawRect(0f,990f,1770f,1000f,wall);
        //paddle
        g.drawRect(1750f,400f,1760f,600f,wall);
        //changing direction of ball
        if (backwardsx){movex--;}
        else {movex++;}

        if (backwardsy){movey--;}
        else {movey++;}
        xnums = (movex * speed);
        ynums = (movey * speed);
        if (xnums < 0) xnums += 1000;
        if (ynums < 0) ynums += 1000;
        if (xnums == 0) {
            backwardsx = !backwardsx;
        }
        if (ynums== 0 || ynums>= 990) {
            backwardsy = !backwardsy;
        }
        if (xnums >= 1740) {
            if (ynums > 400 && ynums < 600) {
                backwardsx = !backwardsx;
            } else {
                movex = j;
            }

        for(Ball i: allBalls){
            g.drawCircle(i.getxPos(),i.getyPos(), 15, wall);
        }

       // g.drawCircle(xnum, ynum, 15, wall);

        }
    }

    @Override
    public void onTouch(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            backwardsx = !backwardsx;
        }

    }

}

