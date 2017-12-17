package com.phu.freefall.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FreeFall extends Game {
	SpriteBatch batch;
	GameScreen gameScreen;
	WelcomeScreen welcomeScreen;

	public static final int HEIGHT = 1000;
	public static final int WIDTH = 576;
    enum screenMode {
        Welcome, Game
    }

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		welcomeScreen = new WelcomeScreen(this);
        setScreen(welcomeScreen);
	}

	public void changeScreenMode(screenMode targetScreen) {
        switch (targetScreen) {
            case Game:
                gameScreen = new GameScreen(this);
                setScreen(gameScreen);
                break;
            case Welcome:
                welcomeScreen = new WelcomeScreen(this);
                setScreen(welcomeScreen);
                break;
        }
    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
