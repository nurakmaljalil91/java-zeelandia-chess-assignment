package com.assignment.game.states;

import java.awt.Graphics;

import com.assignment.game.utils.MouseHandler;

/**
 * class GameState act as parent for all the states in the game. This allow the
 * states no need to be rewrite..??
 * 
 * @author Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since 2019-04-23
 */
public abstract class GameState {
    protected GameStateManager gameStateManager;

    /**
     * Constructor for the game state
     * @param gameStateManager
     */
    public GameState(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    /**
     * update all the process of the gamestate
     */
    public abstract void update();

    /**
     * update all the inputs of the gamestate
     * @param mouseHandler
     */
    public abstract void input(MouseHandler mouseHandler);

    /**
     * update all the render or the draw the image of the gamestate
     * @param g
     */
    public abstract void draw(Graphics g);

}