package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;

public class Ball extends GameObject {
    public Ball(int x, int y) {
        position = new Vector2(x, y);
    }
}
