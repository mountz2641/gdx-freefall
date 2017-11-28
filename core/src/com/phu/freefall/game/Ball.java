package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;

public class Ball extends MovableObject {
    public final int DIRECTION_RIGHT = 0;
    public final int DIRECTION_LEFT = 1;
    public Ball(int x, int y) {
        position = new Vector2(x, y);
    }

    public void move(int pDirection) {
        switch(pDirection) {
            case DIRECTION_RIGHT:
                vx = 7;
                break;
            case DIRECTION_LEFT:
                vx = -7;
                break;
        }
    }

    public void update (float delta) {
        position.x += vx;
        vx = 0;
    }
}
