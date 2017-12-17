package com.phu.freefall.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import static com.badlogic.gdx.Gdx.files;
import static java.lang.Math.abs;
import static sun.audio.AudioPlayer.player;

public class World {
    private Ball ball;
    private FreeFall freeFall;
    private Map map;
    private WorldRenderer worldRenderer;
    private Camera worldCam;

    public int score;
    public BitmapFont gamefont;

    public World(FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        //gamefont = new BitmapFont(files.internal("gamefont.fnt"), files.internal("gamefont.png"),);
        gamefont = new BitmapFont(Gdx.files.internal("gamefont.fnt"), files.internal("gamefont.png"), false);
        gamefont.setColor(new Color(79/255f,159/255f,100/255f,1));
        initiateWorld();
    }

    public void initiateWorld() {
        this.worldCam = new Camera(FreeFall.WIDTH, FreeFall.HEIGHT);
        worldCam.setSpeed(-300);
        worldCam.setPosition(new Vector2(FreeFall.WIDTH / 2.0f, FreeFall.HEIGHT / 2.0f));
        this.ball = new Ball(300,300, this);
        this.map = new Map(this);
        this.score = 0;
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

    public void setWorldRenderer(WorldRenderer worldRenderer) {
        this.worldRenderer = worldRenderer;
    }

    public WorldRenderer getWorldRenderer() {
        return worldRenderer;
    }

    public void scoreUpdater(float delta) {
        score += (int)(delta * 60);
    }

    public BitmapFont getGamefont() {
        return gamefont;
    }

    public void update(float delta) {
        ball.update(delta);
        map.update(delta);
        worldCam.update(delta);
        scoreUpdater(delta);
    }


}
