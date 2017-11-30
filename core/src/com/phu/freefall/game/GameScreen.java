package com.phu.freefall.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
    private final Ball ball;
    private FreeFall freeFall;
    World world;
    WorldRenderer worldRenderer;

    public GameScreen (FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        this.world = new World(freeFall);
        this.ball = world.getBall();
        this.worldRenderer = new WorldRenderer(freeFall, world);
    }

    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            ball.setSpeedX(ball.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            ball.setSpeedX(ball.DIRECTION_RIGHT);
        }
        ball.update(delta);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(100/255f, 200/255f, 100/255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }
}
