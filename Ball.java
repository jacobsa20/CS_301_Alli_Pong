package com.example.jacobsa20.pong;

/**
 * Created by jacobsa20 on 3/22/2018.
 */

import java.util.Random;

/**
 * EXTERNAL CITATION
 * Date: 3/22/2018
 * Problem: needed help changing my ball for loop into a new class.
 * Solution: Mason and I worked on building a ball class together.
 */


public class Ball {
    private int xPos;
    private int yPos;
    private int speed;
    private int xCount;
    private int yCount;

    private boolean xBackwards;
    private boolean yBackwards;

    private Random rand = new Random();

    public Ball(int newX,int newY,int newSpeed,boolean xBack,boolean yBack){
        xPos= newX;
        yPos= newY;
        speed= newSpeed;
        xCount= 0;
        yCount=0;
        xBackwards=xBack;
        yBackwards=yBack;
    }

    //getters for all variables
    public int getxPos(){return xPos;}
    public int getyPos(){return yPos;}
    public int getSpeed(){return speed;}
    public int getxCount(){return xCount;}
    public int getyCount(){return yCount;}
    public boolean isxBackwards(){return xBackwards;}
    public boolean isyBackwards(){return yBackwards;}

    public void setxPos(int x){xPos=x;}
    public void setyPos(int y){yPos=y;}
    public void addxCount(){xCount++;}
    public void addyCount(){yCount++;}
    public void subxCount(){xCount--;}
    public void subyCount(){yCount--;}
    public void changexBackwards(){xBackwards = !xBackwards;}
    public void changeyBackwards(){yBackwards = !yBackwards;}

    public void randCount(int x, int y){
        xCount=x;
        yCount=y;

        xBackwards=rand.nextBoolean();
        yBackwards=rand.nextBoolean();
    }
}
