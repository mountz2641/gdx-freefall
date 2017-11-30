package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;

public class Ball extends MovableObject {
    private boolean isInAir = false;
    private World world;
    private int speed;

    public Ball(int x, int y, World pWorld) {
        position = new Vector2(x, y);
        speed = 7;
        this.world = pWorld;
    }

    public int getSpeed() { return speed; }

    public void update (float delta) {
        position.x += velocX * 60 * delta;
        velocX = 0;
    }
}
