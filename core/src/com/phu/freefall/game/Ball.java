package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

public class Ball extends MovableObject {
    private boolean isInAir = true;
    private World world;
    private int speed;
    private float timecount;

    public Ball(int x, int y, World pWorld) {
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
        if(isInAir) {
            //System.out.println("AIRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            timecount += delta;
            //System.out.println("TIME: " + timecount);
            if(timecount > 0.01) {
                //System.out.println("FASTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
                applyGravity();
                timecount -= 0.01;
            }
        }
        else {
            //System.out.println("TOUCHHHHHHHHHHHHHHHHHHHHHH");
            timecount = 0;
            setVelocityY(0);
            setAccelerationY(0);
        }
        position.x += velocity.x * delta;
        setVelocityX(0);
        position.y += velocity.y * delta;
    }

    public void setInAir(boolean inAir) {
        isInAir = inAir;
    }
}
