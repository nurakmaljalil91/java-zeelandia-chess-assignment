package com.assignment.game.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.assignment.game.utils.*;

/**
 * The Piece class is the parent class for the pieces of the games
 * 
 * @author Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since 2019-04-22
 */
public abstract class Piece {

    protected Vector2f position; // the position of the piece in the board
    protected String filename; // path for the image
    private boolean isAlive; // determine if the piece is alive
    private int team; // determine the team for the piece
    private boolean selected;
    protected BufferedImage image;
    protected Image realImage;

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
        this.selected = false;
    }

    
    /**
     * update the piece 
     */
    abstract void update();

    /**
     * draw the piece on the board
     */
    abstract void draw(Graphics g);
    
    /**
     * function to move the piece in the map
     */
    abstract void move();

    /**
     * function to eat the piece in the map
     */
    abstract void eat();
}