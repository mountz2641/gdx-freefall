package com.phu.freefall.game;

import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.abs;

public class Floor extends GameObject{
    private World world;

    public Floor (float x, float y,World pWorld) {
        this.position = new Vector2(x, y);
        this.world = pWorld;
        width = 72;
        height = 72;
    }

    public Direction checkCollision (Ball ball) {
        if (ball.getPosition().y - ball.getHeight()/2 > this.position.y + this.height/2 ||
            ball.getPosition().y + ball.getHeight()/2 < this.position.y - this.height/2 ||
            ball.getPosition().x - ball.getWidth()/2 > this.position.x + this.width/2 ||
            ball.getPosition().x + ball.getWidth()/2 < this.position.x - this.width/2) {
            //Ball and Floor not Collide
            return Direction.NONE;
        }
        else if(isXInRange(ball.getPosition().y - ball.getHeight()/2,
                            this.position.y + this.height/3.5f,
                            this.position.y + this.height/2)) {
            //Ball is on top of Floor
            return Direction.UP;
        }
        else if(ball.getPosition().x - this.position.x > 0) {
            //Ball is on Right of Floor
            return Direction.RIGHT;
        }
        else if(ball.getPosition().x - this.position.x < 0) {
            //Ball is on Left of Floor
            return Direction.LEFT;
        }
        else {
            return Direction.NONE;
        }
    }

    public boolean isXInRange(float x, float y, float z) {
        return x >= y && x <= z;
    }
}
