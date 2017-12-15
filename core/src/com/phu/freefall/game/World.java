package com.phu.freefall.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import static sun.audio.AudioPlayer.player;

public class World {
    private Ball ball;
    private FreeFall freeFall;
    private Floor refFloor;
    private ArrayList<Floor> platform = new ArrayList<Floor>();
    private String[] pattern = new String[] {
            "--######",
            "##--####",
            "####--##",
            "######--",
            "--####--",
            "###--###",
            "--#--#--",
            "##----##",
            "#--##--#",
            "#--#--##"};

    public World(FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        this.refFloor = new Floor(0,0,this);
        this.ball = new Ball(100,100, this);
        for (int i = 0; i < 8; i++) {
            if(pattern[5].charAt(i) == '#') {
                this.platform.add(new Floor(i * refFloor.getWidth(), 0, this));
            }
        }
        for (int i = 0; i < 8; i++) {
            if(pattern[8].charAt(i) == '#') {
                this.platform.add(new Floor(i * refFloor.getWidth(), freeFall.HEIGHT/2, this));
            }
        }
    }

    public Ball getBall() { return ball; }

    public List<Floor> getPlatform() { return platform; }

    public boolean checkBallandFloor(Floor pFloor) {
        if(ball.getPosition().x - ball.width/2 > pFloor.getPosition().x + pFloor.width/2) {
            return false;
        }
        else if(ball.getPosition().x + ball.width/2 < pFloor.getPosition().x - pFloor.width/2) {
            return false;
        }
        if(ball.getPosition().y - ball.height/2 < pFloor.getPosition().y + pFloor.height/2 &&
                ball.getPosition().y + ball.height/2 > pFloor.getPosition().y - pFloor.height/2) {
            ball.setPosition(new Vector2(ball.getPosition().x,pFloor.getPosition().y + pFloor.height/2 + ball.height/2));
            return true;
        } else {
            return  false;
        }
    }

    public void update(float delta) {
        ball.update(delta);
        if(ball.getPosition().y < 0)
            ball.setPosition(new Vector2(ball.getPosition().x,FreeFall.HEIGHT));
        for (Floor floor : platform) {
            if(checkBallandFloor(floor)) {
                ball.setInAir(false);
                break;
            } else { ball.setInAir(true);}
        }
    }


}
