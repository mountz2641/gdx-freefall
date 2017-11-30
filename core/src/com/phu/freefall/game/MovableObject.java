package com.phu.freefall.game;

public class MovableObject extends GameObject {
    protected int velocX = 0;
    protected int velocY = 0;
    protected int accelY = 0;

    public final int DIRECTION_RIGHT = 0;
    public final int DIRECTION_LEFT = 1;


    public void setVelocityX(int pDirection, int pSpeed) {
        switch(pDirection) {
            case DIRECTION_RIGHT:
                velocX = 7;
                break;
            case DIRECTION_LEFT:
                velocX = -7;
                break;
        }
    }
    public void setVelocityY() {
        velocY += accelY;
    }

    public void setAccelY (int pAccel) {
        this.accelY = pAccel;
    }
}
