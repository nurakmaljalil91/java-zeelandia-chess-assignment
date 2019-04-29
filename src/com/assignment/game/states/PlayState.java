package com.assignment.game.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.assignment.game.gameobjects.Piece;
import com.assignment.game.gameobjects.Player;
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
    
    private Player playerBlue;
    private Player playerRed;
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

        // Creating a blue team
        playerBlue = new Player("Blue", 1);
        playerRed = new Player("Red", 2);
        
        
        //bluePlusPiece1 = new Plus(1, new Vector2f(0,0), "/bluePlus.png");
        // bluePlusPiece2 = new Plus(1, new Vector2f(6,0), "/bluePlus.png");
        // redPlusPiece1 = new Plus(2, new Vector2f(0,5), "/redPlus.png");
        // redPlusPiece2 = new Plus(2, new Vector2f(6,5), "/redPlus.png");

        playerBlue.addPiece(new Plus(1, new Vector2f(0,0), "/bluePlus.png"));
    }   

    /**
     * update all the state object updates
     */
    @Override
    public void update() {
        //System.out.println("This play state update");
        playerBlue.update();
    }

    /**
     * update all the input from the player in the state
     */
    @Override
    public void input(MouseHandler mouseHandler, MouseEvent e) {
        //System.out.println(mouseHandler.getX());
        playerBlue.input(mouseHandler, e);
        //bluePlusPiece1.input(mouseHandler, e);
        // bluePlusPiece2.input(mouseHandler);
        // redPlusPiece1.input(mouseHandler);
        // redPlusPiece2.input(mouseHandler);
    }

    /**
     * draw all the objects in the states
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        playerBlue.draw(g);
        //System.out.println("this is play state draw");
        // bluePlusPiece1.draw(g);
        // bluePlusPiece2.draw(g);
        // redPlusPiece1.draw(g);
        // redPlusPiece2.draw(g);
    }
}