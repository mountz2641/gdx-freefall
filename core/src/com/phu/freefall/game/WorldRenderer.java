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
    private MapRenderer mapRenderer;
    private Texture ballImage;
    private Texture floorImage;
    private Texture spearRowImage;
    private Texture spearRowRevertImage;
    private Camera worldCam;

    //private Texture backgroundImage;

    public WorldRenderer(FreeFall pFreeFall, World pWorld) {
        this.freeFall = pFreeFall;
        this.world = pWorld;
        this.ballImage = new Texture("ball.png");
        this.batch = freeFall.batch;
        //this.backgroundImage = new Texture("stoneWall.jpg");
        this.floorImage = new Texture("floor.png");
        this.mapRenderer = new MapRenderer(batch, world.getMap());
        this.worldCam = world.getWorldCam();
        this.spearRowImage = new Texture("spear_row.png");
        this.spearRowRevertImage = new Texture("spear_row_revert.png");
    }

    public void setBallImage(Texture ballImage) {
        this.ballImage = ballImage;
    }

    public void render(float delta) {
        Vector2 ballPos = world.getBall().getPosition();
        mapRenderer.render(delta);
        batch.begin();
        //batch.draw(backgroundImage,0,0);
        batch.draw(spearRowImage,worldCam.getPosition().x - (worldCam.getViewportWidth() >> 1),
                worldCam.getPosition().y - (worldCam.getViewportHeight() >> 1));
        batch.draw(spearRowRevertImage,worldCam.getPosition().x - (worldCam.getViewportWidth() >> 1),
                worldCam.getPosition().y + (worldCam.getViewportHeight() >> 1) - spearRowImage.getHeight());
        batch.draw(ballImage, ballPos.x - (ballImage.getWidth() >> 1)
                            , ballPos.y - (ballImage.getHeight() >> 1));
        world.gamefont.draw(batch,"Scores: " + world.score,
                worldCam.getPosition().x - (worldCam.getViewportWidth() >> 1) + 32,
                worldCam.getPosition().y + (worldCam.getViewportHeight() >> 1) - 64);
        batch.end();
        //System.out.println("Delta: " + delta);
    }

}
