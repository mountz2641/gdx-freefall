package com.phu.freefall.game;

public class World {
    private Ball ball;
    private FreeFall freeFall;

    public World(FreeFall pFreeFall) {
        this.freeFall = pFreeFall;
        ball = new Ball(100,100, this);

    }
    public void update(float delta) { ball.update(delta); }

    Ball getBall() { return ball; }
}
