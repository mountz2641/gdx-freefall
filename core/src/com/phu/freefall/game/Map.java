package com.phu.freefall.game;

import java.util.ArrayList;

public class Map {
    private World world;
    private Floor refFloor;
    private ArrayList<Floor> platform = new ArrayList<Floor>();
    private String[] pattern = new String[] {
            "--<#####",
            "#>--<###",
            "###>--<#",
            "#####>--",
            "--<##>--",
            "##>--<##",
            "--^--^--",
            "#>----<#",
            ">--<>--<",
            "--------"};
    public Map (World pWorld) {
        this.world = pWorld;
        this.refFloor = new Floor(0,0,world);
        for (int i = 0; i < 8; i++) {
            if(pattern[5].charAt(i) == '#') {
                this.platform.add(new Floor(refFloor.getWidth()/2 + i * refFloor.getWidth(), 0,world));
            }
            else if(pattern[5].charAt(i) == '<') {
                this.platform.add(new Floor(refFloor.getWidth()/2 + i * refFloor.getWidth(), 0,world));
            }
            else if(pattern[5].charAt(i) == '>') {
                this.platform.add(new Floor(refFloor.getWidth()/2 + i * refFloor.getWidth(), 0,world));
            }
            else if(pattern[5].charAt(i) == '^') {
                this.platform.add(new Floor(refFloor.getWidth()/2 + i * refFloor.getWidth(), 0,world));
            }
        }
    }

    public ArrayList<Floor> getPlatform() {
        return platform;
    }

    public void collionCheck() {
        Ball ball = world.getBall();
        Direction result;
        for (Floor floor : platform) {
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
        }

    }

    public void update(float delta) {
        collionCheck();
    }




}
