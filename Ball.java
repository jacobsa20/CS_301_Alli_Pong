package com.example.jacobsa20.pong;

/**
 * Created by jacobsa20 on 3/22/2018.
 */

public class Ball {
    private int xPos;
    private int yPos;
    private int speed;
    private int xCount;
    private int yCount;

    private boolean xBackwards;
    private boolean yBackwards;

    public Ball(int newX, int newY, int newSpeed, boolean xBack, boolean yBack){
        xPos= newX;
        yPos= newY;
        speed= newSpeed;
        xCount= 0;
        yCount=0;
        xBackwards=xBack;
        yBackwards=yBack;
    }
    Ball[] allBalls = new Ball[10];

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
    public void setSpeed(int s){speed=s;}
    public void addxCount(){xCount++;}
    public void addyCount(){yCount++;}
    public void subxCount(){xCount--;}
    public void subyCount(){yCount--;}
    public void changexBackwards(){xBackwards = !xBackwards;}
    public void changeyBackwards(){yBackwards = !yBackwards;}

    public void randCount(int x, int y){
        xCount=x;
        yCount=y;
    }
}
