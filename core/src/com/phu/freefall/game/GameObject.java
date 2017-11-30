package com.phu.freefall.game;

import com.badlogic.gdx.math.Vector2;

public class GameObject {
    protected Vector2 position;
    protected int width;
    protected int height;

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 pPosition) {
        this.position = pPosition;
    }
}
