package com.phu.freefall.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
    private World world;
    private FreeFall freeFall;
    private SpriteBatch batch;
    private Texture ballImg;

    public WorldRenderer(FreeFall pFreeFall, World pWorld) {
        this.freeFall = pFreeFall;
        this.world = pWorld;
        this.ballImg = new Texture("ball.png");
        batch = freeFall.batch;
    }

    public void render(float delta) {
        Vector2 ballPos = world.getBall().getPosition();
        batch.begin();
        batch.draw(ballImg, ballPos.x, ballPos.y);
        batch.end();
    }

}
