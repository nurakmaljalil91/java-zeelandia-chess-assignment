package com.assignment.game.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.assignment.game.gameobjects.ID;
import com.assignment.game.gameobjects.Piece;
import com.assignment.game.gameobjects.Player;
import com.assignment.game.gameobjects.Plus;
import com.assignment.game.utils.MouseHandler;
import com.assignment.game.utils.Vector2f;

/**
 * the Play state is the state where the game is update and render. The class
 * extends the Game state properties
 * 
 * @author Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since 2019-04-23
 */
public class PlayState extends GameState {

    private Player playerBlue;
    private Player playerRed;

    /**
     * constructor of PlayState class
     * 
     * @param gameStateManager
     */
    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);

        // Creating a blue team
        playerBlue = new Player("Blue", 1);
        playerRed = new Player("Red", 2);

        playerBlue.addPiece(new Plus(1, new Vector2f(0, 0), "/bluePlus.png", playerBlue, ID.bluePlus1));
        playerBlue.addPiece(new Plus(1, new Vector2f(2, 0), "/bluePlus.png", playerBlue, ID.bluePlus2));
    }

    /**
     * update all the state object updates
     */
    @Override
    public void update() {
        // System.out.println("This play state update");
        playerBlue.update();
        playerRed.update();
    }

    /**
     * update all the input from the player in the state
     */
    @Override
    public void input(MouseHandler mouseHandler, MouseEvent e) {
        // System.out.println(mouseHandler.getX());
        mouseHandler.setPlayerPieces(playerBlue);
        playerBlue.input(mouseHandler, e);
        playerRed.input(mouseHandler, e);

    }

    /**
     * draw all the objects in the states
     * 
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        playerBlue.draw(g);
        playerRed.draw(g);

    }
}