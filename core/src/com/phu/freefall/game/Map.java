package com.phu.freefall.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;
import static java.lang.Math.abs;

public class Map {
    private World world;
    private Floor refFloor;
    private ArrayList<Floor> platform = new ArrayList<Floor>();
    private String[] pattern = new String[] {
            "--######",
            "##--####",
            "####--##",
            "######--",
            "--####--",
            "###--###",
            "--#--#--",
            "##----##",
            "#--##--#",
            "--------"};
    private Camera worldCam;
    private float generateDelayTime;
    private float timeCounter = 0;
    private float lastRowPositionY = 0;
    private int choosedPattern = 0;

    public Map (World pWorld) {
        this.world = pWorld;
        this.worldCam = world.getWorldCam();
        this.generateDelayTime = FreeFall.HEIGHT / abs(worldCam.getSpeed());
        System.out.println("DELAY: " + generateDelayTime);
        this.refFloor = new Floor(0,0,world);
        platformGenerate(8);
    }

    public ArrayList<Floor> getPlatform() {
        return platform;
    }

    public void collionCheck() {
        Ball ball = world.getBall();
        Direction result;
        Iterator<Floor> iter = platform.iterator();
        while(iter.hasNext()) {
            Floor floor = iter.next();
            result = floor.checkCollision(ball);
            if(result != Direction.NONE) {
                switch (result) {
                    case UP:
                        ball.setPositionY(floor.getPosition().y + floor.getHeight()/2.0f + ball.getHeight()/2.0f);
                        ball.setAccelerationY(0);
                        ball.setVelocityY(0);
                        break;
                    case RIGHT:
                        ball.setPositionX(floor.getPosition().x + floor.getWidth()/2.0f + ball.getWidth()/2.0f);
                        break;
                    case LEFT:
                        ball.setPositionX(floor.getPosition().x - floor.getWidth()/2.0f - ball.getWidth()/2.0f);
                        break;
                }
                break;
            }
            if(floor.getPosition().y > worldCam.getPosition().y + worldCam.getViewportHeight()/2) {
                iter.remove();
            }
        }
    }

    private static int getRandomIntInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

    }

    public void platformGenerate(float delta) {
        timeCounter += delta;
        if(timeCounter >= generateDelayTime) {
            //create 15 per time
            for (int i = 0; i < 15; i++) {
                if(i % 3 == 0) {
                    //random pattern
                    choosedPattern = getRandomIntInRange(0,8);

                    for(int j = 0; j < 8; j++){
                        if(pattern[choosedPattern].charAt(j) == '#') {
                            this.platform.add(new Floor(refFloor.getWidth()/2 + j * refFloor.getWidth(),
                                                        lastRowPositionY - refFloor.getHeight(),world));
                        }
                    }

                } else {
                    //generate blankrow
                }
                lastRowPositionY -= refFloor.getHeight();
            }
            timeCounter -= generateDelayTime;
        }
    }

    public void update(float delta) {
        collionCheck();
        platformGenerate(delta);
    }




}
