package com.phu.freefall.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static sun.audio.AudioPlayer.player;

public class World {
    private Ball ball;
    private FreeFall freeFall;
    private Map map;
    private ArrayList<Floor> platform = new ArrayList<Floor>();
    private String[] pattern = new String[] {
            "--<#####",
            "#>--<###",
            "###>--<#",
            "#####>--",
            "--<##>--",
            "##>--<##",
            "--^--^--",
            "#>----<#",
            ">--<>--<",
            "--------"};

    public World(FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        this.map = new Map(this);
        initiateWorld();
    }

    public void initiateWorld() {
        this.ball = new Ball(300,300, this);
    }

    public Ball getBall() { return ball; }

    public FreeFall getFreeFall() {
        return freeFall;
    }

    public Map getMap() {
        return map;
    }

    public void update(float delta) {
        ball.update(delta);
        map.update(delta);
    }

}
