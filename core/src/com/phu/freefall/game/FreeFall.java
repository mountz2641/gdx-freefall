package com.phu.freefall.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FreeFall extends Game {
	SpriteBatch batch;
	public static final int HEIGHT = 800;
	public static final int WIDTH = 576;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new GameScreen(this));
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
