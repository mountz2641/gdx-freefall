package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.util.ArrayList;

public class Ball extends MovableObject {
    private World world;
    private int speed;
    private float timecount;
    private Camera worldCam;

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

    public void update (float delta) {
        timecount += delta;
        if(timecount >= 0.01) {
            //System.out.println("FASTer:" + velocity.y);
            for(;timecount >= 0.01;timecount-=0.01) {
                applyGravity();
            }
        }
        timecount = 0;
        move(delta);
        if(position.y < worldCam.getPosition().y - worldCam.getViewportHeight()/2) {
            position.y = worldCam.getPosition().y + worldCam.getViewportHeight()/2;
        }
        if(position.x < 0) {
            position.x = worldCam.getViewportWidth();
        }
        if(position.x > worldCam.getViewportWidth()) {
            position.x = 0;
        }
    }

    public void move(float delta) {
        position.x += velocity.x * delta;
        setVelocityX(0);
        position.y += velocity.y * delta;
    }
}
