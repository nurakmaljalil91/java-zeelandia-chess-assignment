package com.assignment.game.states;

import java.awt.Graphics;

public abstract class GameState {
    protected GameStateManager gameStateManager;

    public GameState(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public abstract void start();
    public abstract void update(double delatTime);
    public abstract void input(MouseHandler mouseHandler);
    public abstract void draw(Graphics g);

}