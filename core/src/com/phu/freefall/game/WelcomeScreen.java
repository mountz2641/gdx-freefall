package com.phu.freefall.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WelcomeScreen extends ScreenAdapter {
    FreeFall freefall;
    SpriteBatch batch;
    Texture backgroundImg;


    public WelcomeScreen(FreeFall pFreefall) {
        this.freefall = pFreefall;
        batch = freefall.batch;
        backgroundImg = new Texture("welcome_background.png");
    }

    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backgroundImg, 0, 0, FreeFall.WIDTH, FreeFall.HEIGHT);
        batch.end();
    }

    public void update(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            freefall.changeScreenMode(FreeFall.screenMode.Game);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {

        }
    }
}
