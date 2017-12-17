package com.phu.freefall.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
    private FreeFall freeFall;
    World world;
    Camera worldCam;
    WorldRenderer worldRenderer;
    SpriteBatch batch;
    OrthographicCamera orthoCam;
    Ball ball;


    public GameScreen (FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        this.world = new World(freeFall);
        this.worldRenderer = new WorldRenderer(freeFall,world);
        this.world.setWorldRenderer(worldRenderer);
        this.batch = freeFall.batch;
        this.ball = world.getBall();

        worldCam = world.getWorldCam();
        orthoCam = new OrthographicCamera(worldCam.getViewportWidth(),worldCam.getViewportHeight());
        orthoCam.position.set(worldCam.getPosition().x, worldCam.getPosition().y,0);
        orthoCam.update();
    }

    private void updateCamera(float delta) {
        orthoCam.position.y = worldCam.getPosition().y;
        orthoCam.update();
        batch.setProjectionMatrix(orthoCam.combined);
    }

    private void playerControl() {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            ball.setVelocityX(-ball.getSpeed());
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            ball.setVelocityX(ball.getSpeed());
        }
    }

    private void commandControl(boolean isBallAlive) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            freeFall.changeScreenMode(FreeFall.screenMode.Game);
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            orthoCam = new OrthographicCamera(worldCam.getViewportWidth(),worldCam.getViewportHeight());
            orthoCam.position.set(FreeFall.WIDTH / 2.0f, FreeFall.HEIGHT / 2.0f,0);
            orthoCam.update();
            batch.setProjectionMatrix(orthoCam.combined);
            freeFall.changeScreenMode(FreeFall.screenMode.Welcome);
        }
    }

    private void update(float delta) {
        if(ball.isAlive()) {
            playerControl();
            world.update(delta);
            updateCamera(delta);
        }
        commandControl(ball.isAlive());
    }

    @Override
    public void render(float delta) {
        System.out.println("DELTA: " + delta);
        update(delta);
        Gdx.gl.glClearColor(40/255f, 40/255f, 40/255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }
}
