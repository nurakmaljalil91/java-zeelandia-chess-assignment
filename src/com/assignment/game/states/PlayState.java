package com.assignment.game.states;

import java.awt.Graphics;

import com.assignment.game.gameobjects.Plus;
import com.assignment.game.utils.MouseHandler;
import com.assignment.game.utils.Vector2f;
/**
 * the Play state is the state where the game is
 * update and render. The class extends the Game 
 * state properties
 * @author  Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since   2019-04-23
 */
public class PlayState extends GameState {
   
    private Plus bluePlusPiece1;
    private Plus bluePlusPiece2;
    private Plus redPlusPiece1;
    private Plus redPlusPiece2;

    /**
     * constructor of PlayState class 
     * @param gameStateManager
     */
    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bluePlusPiece1 = new Plus(1, new Vector2f(0,0), "/bluePlus.png");
        bluePlusPiece2 = new Plus(1, new Vector2f(6,0), "/bluePlus.png");
        redPlusPiece1 = new Plus(2, new Vector2f(0,5), "/redPlus.png");
        redPlusPiece2 = new Plus(2, new Vector2f(6,5), "/redPlus.png");
    }   

    /**
     * update all the state object updates
     */
    @Override
    public void update() {
        //System.out.println("This play state update");
    }

    /**
     * update all the input from the player in the state
     */
    @Override
    public void input(MouseHandler mouseHandler) {
        //System.out.println(mouseHandler.getX());
    }

    /**
     * draw all the objects in the states
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        //System.out.println("this is play state draw");
        bluePlusPiece1.draw(g);
        bluePlusPiece2.draw(g);
        redPlusPiece1.draw(g);
        redPlusPiece2.draw(g);
    }
}