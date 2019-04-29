package com.assignment.game.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    protected boolean isAlive; // determine if the piece is alive
    protected int team; // determine the team for the piece
    protected boolean selected;
    protected BufferedImage image;
    protected Image realImage;
    protected String name;
    protected Rectangle rectangle;
    protected boolean clicked = false;
    protected final int SIZE = 96;
    protected Player playerPieceManager;
    protected ID id;

    protected enum STATE {
        idle, selected
    };

    protected STATE state;

    /**
     * Constructor for piece class
     * 
     * @param position
     * @param name
     */
    public Piece(int team, Vector2f position, String filename, Player playerPieceManager, ID id) {
        this.team = team;
        this.position = position;
        this.filename = filename;
        this.isAlive = true;
        this.selected = false;
        this.state = STATE.idle;
        this.playerPieceManager = playerPieceManager;
        this.id = id;
    }

    /**
     * update the piece
     */
    abstract void update();

    /**
     * handle the input for the piece
     * 
     * @param mouseHandler
     * @param e
     */
    abstract void input(MouseHandler mouseHandler, MouseEvent e);

    /**
     * draw the piece on the board
     */
    abstract void draw(Graphics g);

    /**
     * function to move the piece in the map
     */
    abstract void move(MouseHandler mouseHandler, MouseEvent e);

    /**
     * function to eat the piece in the map
     */
    abstract void eat();

    public abstract ID getID();

    public abstract void onClick(MouseHandler mouseHandler, MouseEvent e);
}