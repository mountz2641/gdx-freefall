package com.phu.freefall.game;

import com.badlogic.gdx.math.Vector2;

public class Camera {

    private int viewportWidth;
    private int viewportHeight;
    private Vector2 position;
    private float speed;

    public Camera (int pWidth, int pHeight) {
        speed = 0;
        this.viewportWidth = pWidth;
        this.viewportHeight = pHeight;
        position = new Vector2(0, 0);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return this.speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPositionX(float x) {
        position.x = x;
    }

    public void setPositionY(float y) {
        position.y = y;
    }

    public int getViewportWidth() {
        return viewportWidth;
    }

    public void setViewportWidth(int viewportWidth) {
        this.viewportWidth = viewportWidth;
    }

    public int getViewportHeight() {
        return viewportHeight;
    }

    public void setViewportHeight(int viewportHeight) {
        this.viewportHeight = viewportHeight;
    }

    public void update(float delta) {
        position.y += speed * delta;
    }
}