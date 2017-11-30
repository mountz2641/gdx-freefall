package com.phu.freefall.game;

public class MovableObject extends GameObject {
    protected int vx;
    protected int vy;

    public final int DIRECTION_RIGHT = 0;
    public final int DIRECTION_LEFT = 1;


    public void setSpeedX(int pDirection) {
        switch(pDirection) {
            case DIRECTION_RIGHT:
                vx = 7;
                break;
            case DIRECTION_LEFT:
                vx = -7;
                break;
        }
    }
}
