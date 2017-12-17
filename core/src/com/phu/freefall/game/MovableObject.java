package com.phu.freefall.game;

import com.badlogic.gdx.math.Vector2;

public class MovableObject extends GameObject {
    protected Vector2 velocity;
    protected Vector2 acceleration;

    public final int DIRECTION_RIGHT = 0;
    public final int DIRECTION_LEFT = 1;


    public void setVelocityX(int pSpeed) {
        velocity.x = pSpeed;
    }

    public void setVelocityY(int pSpeed) {
        velocity.y = pSpeed;
    }

    public void setAccelerationX(int pAccel) {
        acceleration.x = pAccel;
    }

    public void setAccelerationY(int pAccel) {
        acceleration.y = pAccel;
    }

    public void applyGravity() {
        setAccelerationY(-1);
        velocity.y += acceleration.y;
    }
}
