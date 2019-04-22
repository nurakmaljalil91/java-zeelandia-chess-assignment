package com.assignment.game.gameobjects;

import com.assignment.game.utils.*;

/**
 * The Piece class is the parent class for the pieces of the games
 * 
 * @author Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since 2019-04-22
 */
public abstract class Piece {

    private Vector2f position; // the position of the piece in the board
    private String filename; // path for the image
    private bool isAlive;
    private int team;

    /**
     * Constructor for piece class
     * 
     * @param position
     * @param name
     */
    public Piece(int team, Vector2f position, String filename) {
        this.team = team;
        this.position = position;
        this.filename = filename;
        this.isAlive = true;
    }

    /**
     * function to move the piece in the map
     */
    abstract void move();

    /**
     * function to eat the piece in the map
     */
    abstract void eat();
}