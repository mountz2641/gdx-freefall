package com.phu.freefall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;

public class Ball extends MovableObject {
    private boolean isInAir = true;
    private World world;
    private int speed;
    private float timecount;

    public Ball(int x, int y, World pWorld) {
        position = new Vector2(x, y);
        width = 64;
        height = 64;
        speed = 7;
        this.world = pWorld;
    }

    public int getSpeed() { return speed; }

    public void update (float delta) {
        if(isInAir) {
            System.out.println("AIRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            timecount += delta;
            System.out.println("TIME: " + timecount);
            if(timecount > 0.1) {
                System.out.println("FASTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
                accelY = -1;
                velocY += accelY;
                timecount -= 0.1;
            }
        }
        else {
            System.out.println("TOUCHHHHHHHHHHHHHHHHHHHHHH");
            timecount = 0;
            velocY = 0;
            accelY = 0;
        }
        position.x += velocX * 60 * delta;
        velocX = 0;
        position.y += velocY * 60 * delta;
    }

    public void setInAir(boolean inAir) {
        isInAir = inAir;
    }
}
