package com.phu.freefall.game;

import com.badlogic.gdx.math.Vector2;

public class Floor extends GameObject{
    private World world;

    public Floor (int x, int y,World pWorld) {
        this.position = new Vector2(x, y);
        this.world = pWorld;
        width = 64;
        height = 64;

    }
}
