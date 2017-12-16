package com.phu.freefall.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapRenderer {
    private Map map;
    private Texture floorImage;
    private SpriteBatch batch;

    public MapRenderer (SpriteBatch batch, Map pMap) {
        this.map = pMap;
        this.floorImage = new Texture("floor.png");
        this.batch = batch;
    }

    public void render(float delta) {
        batch.begin();
        for (Floor floor: map.getPlatform()) {
            batch.draw(floorImage, floor.getPosition().x - (floorImage.getWidth() / 2),
                    floor.getPosition().y - (floorImage.getWidth()) / 2);
        }
        batch.end();

    }


}
