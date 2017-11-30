package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;

public class Ball extends MovableObject {
    public Ball(int x, int y) {
        position = new Vector2(x, y);
    }

    public void update (float delta) {
        position.x += vx;
        vx = 0;
    }
}
