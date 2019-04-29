package com.assignment.game.gameobjects;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import com.assignment.game.utils.MouseHandler;

/**
 * Player class act as player for the game
 * @author Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since 2019-04-25
 */
public class Player {
    private String name; // name of the player
    private int score; // number of score
    private int team; // team number

    public LinkedList<Piece> pieces = new LinkedList<Piece>(); // collection of pieces

    /**
     * Constructor for the player class
     * 
     * @param name
     * @param team
     */
    public Player(String name, int team) {
        this.name = name;
        this.team = team;
        this.score = 0;
    }

    /**
     * Set the name for the player
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the team for the player
     * @param team
     */
    public void setTeam(int team) {
        this.team = team;
    }

    /** set the score for the player
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * get the player name
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * get the team 
     * @return
     */
    public int getTeam() {
        return team;
    }
    
    /**
     * get the score of the player
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * update the collection of the pieces by a player
     */
    public void update() {
        for (int i = 0; i < pieces.size(); i++) {
            Piece tempPiece = pieces.get(i);

            tempPiece.update();
        }
    }

    public void input(MouseHandler mouseHandler, MouseEvent e) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece tempPiece = pieces.get(i);
            tempPiece.input(mouseHandler, e);
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece tempPiece = pieces.get(i);
            tempPiece.draw(g);
        }
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        this.pieces.remove(piece);
    }

}