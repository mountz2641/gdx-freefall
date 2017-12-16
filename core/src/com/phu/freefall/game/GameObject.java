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
    public void setPositionX(float x) {
        this.position.x = x;
    }

    public void setPositionY(float y) {
        this.position.y = y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
