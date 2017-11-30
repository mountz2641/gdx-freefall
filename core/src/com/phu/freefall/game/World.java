package com.phu.freefall.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static sun.audio.AudioPlayer.player;

public class World {
    private Ball ball;
    private FreeFall freeFall;
    private Floor floor;

    public World(FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        this.ball = new Ball(100,100, this);
        this.floor = new Floor(freeFall.WIDTH / 2, 0,this);
    }

    public Ball getBall() { return ball; }

    public Floor getFloor() { return floor; }

    public boolean checkBallandFloor(Floor pFloor) {
        if(ball.getPosition().x - ball.width/2 > floor.getPosition().x + pFloor.width/2) { return false; }
        else if(ball.getPosition().x + ball.width/2 < floor.getPosition().x - pFloor.width/2) { return false; }
        if(ball.getPosition().y - ball.height/2 < pFloor.getPosition().y + pFloor.height/2) {
            ball.setPosition(new Vector2(ball.getPosition().x,
                            pFloor.getPosition().y + pFloor.height/2 + ball.height/2));

            return true;
        } else { return  false; }
    }

    public void update(float delta) {
        ball.update(delta);
        if(ball.getPosition().y < 0)
            ball.setPosition(new Vector2(ball.getPosition().x,FreeFall.HEIGHT));
        if(checkBallandFloor(floor)) {
            ball.setInAir(false);
        } else { ball.setInAir(true);}
    }


}
