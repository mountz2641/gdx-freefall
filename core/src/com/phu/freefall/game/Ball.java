package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.util.ArrayList;

public class Ball extends MovableObject {
    private World world;
    private int speed;
    private float timecount;

    public Ball(int x, int y,World pWorld) {
        position = new Vector2(x, y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
        width = 64;
        height = 64;
        speed = 420;
        this.world = pWorld;
    }

    public int getSpeed() { return speed; }

    public void update (float delta) {
        timecount += delta;
        if(timecount > 0.01) {
            applyGravity();
            //System.out.println("FASTer:" + velocity.y);
            timecount -= 0.01;
        }
        timecount = 0;
        move(delta);
        if(position.y < 0) {
            position.y = world.getFreeFall().HEIGHT;
        }
    }

    public void move(float delta) {
        position.x += velocity.x * delta;
        setVelocityX(0);
        position.y += velocity.y * delta;
    }
}
