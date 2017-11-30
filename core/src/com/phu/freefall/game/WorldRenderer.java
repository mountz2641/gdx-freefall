package com.phu.freefall.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
    private World world;
    private FreeFall freeFall;
    private SpriteBatch batch;
    private Texture ballImage;
    private Texture floorImage;
    private Texture backgroundImage;

    public WorldRenderer(FreeFall pFreeFall, World pWorld) {
        this.freeFall = pFreeFall;
        this.world = pWorld;
        this.ballImage = new Texture("ball.png");
        this.batch = freeFall.batch;
        this.backgroundImage = new Texture("stoneWall.jpg");
        this.floorImage = new Texture("floor.png");
    }

    public void render(float delta) {
        Vector2 ballPos = world.getBall().getPosition();
        Vector2  floorPos = world.getFloor().getPosition();
        batch.begin();
        batch.draw(backgroundImage,0,0);
        batch.draw(ballImage, ballPos.x - (ballImage.getWidth()/2)
                            , ballPos.y - (ballImage.getHeight()/2));
        batch.draw(floorImage, floorPos.x - (floorImage.getWidth()/2)
                , floorPos.y - (floorImage.getHeight()/2));
        batch.end();
        //System.out.println("Delta: " + delta);
    }

}
