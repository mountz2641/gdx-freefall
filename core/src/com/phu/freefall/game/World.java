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

    private Camera worldCam;
    private static final int CAM_VIEWPORT_WIDTH = FreeFall.WIDTH;
    private static final int CAM_VIEW_HEIGHT = FreeFall.HEIGHT;
    private static final float CAM_INIT_SPEED = 2;

    public World(FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        initiateWorld();
    }

    public void initiateWorld() {
        this.ball = new Ball(300,300, this);
        this.map = new Map(this);
        this.worldCam = new Camera(FreeFall.WIDTH, FreeFall.HEIGHT);
        worldCam.setSpeed(120);
        worldCam.setPosition(new Vector2(FreeFall.WIDTH / 2.0f, FreeFall.HEIGHT / 2.0f));
    }

    public Ball getBall() { return ball; }

    public FreeFall getFreeFall() {
        return freeFall;
    }

    public Map getMap() {
        return map;
    }

    public Camera getWorldCam() {
        return worldCam;
    }

    public void update(float delta) {
        ball.update(delta);
        map.update(delta);
        worldCam.update(delta);
    }

}
