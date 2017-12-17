package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.util.ArrayList;

public class Ball extends MovableObject {
    private World world;
    private int speed;
    private float timecount;
    private Camera worldCam;
    private boolean isAlive = true;

    public Ball(int x, int y,World pWorld) {
        position = new Vector2(x, y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
        width = 64;
        height = 64;
        speed = 490;
        this.world = pWorld;
        this.worldCam = world.getWorldCam();
    }

    public int getSpeed() { return speed; }

    private void checkSelfPosition() {
        if(position.y < worldCam.getPosition().y - worldCam.getViewportHeight()/2 + 32) {
            dead(Direction.DOWN);
        }
        if(position.y > worldCam.getPosition().y  + worldCam.getViewportHeight()/2 - 32) {
            dead(Direction.UP);
        }
        if(position.x < 0) {
            position.x = worldCam.getViewportWidth();
        }
        if(position.x > worldCam.getViewportWidth()) {
            position.x = 0;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void dead(Direction pDirection) {
        isAlive = false;
        switch (pDirection) {
            case UP:
                world.getWorldRenderer().setBallImage(new Texture("speared_ball_revert.png"));
                break;
            case DOWN:
                world.getWorldRenderer().setBallImage(new Texture("speared_ball.png"));
                break;
        }
    }

    public void move(float delta) {
        position.x += velocity.x * delta;
        setVelocityX(0);
        position.y += velocity.y * delta;
    }

    public void update (float delta) {
        timecount += delta;
        if(timecount >= 0.001) {
            for(;timecount >= 0.001;timecount-=0.001) {
                applyGravity();
            }
        }
        timecount = 0;
        move(delta);
        checkSelfPosition();
    }

}
