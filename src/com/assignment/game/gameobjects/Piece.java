package com.assignment.game.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.assignment.game.utils.*;

/**
 * The Piece class is the parent class for the pieces of the games
 * 
 * @author Nur Akmal Jalil "arcmole007"
 * @version 1.0
 * @since 2019-04-22
 */
public abstract class Piece {

    protected Vector2i position; // the position of the piece in the board
    protected String filename; // path for the image
    protected boolean isAlive; // determine if the piece is alive
    protected int team; // determine the team for the piece
    protected boolean canSelect; // determine if the piece can be select or not -> for turn
    protected BufferedImage image; // image for the piece
    protected Image realImage; // real image for the piece
    protected String name; // name for the piece
    protected Rectangle rectangle; // rectangle for the piece
    protected boolean clicked = false; // check if the mouse already click
    protected final int SIZE = 96; // size 96 * 96 pixel
    protected Player playerPieceManager; // collection of pieces
    protected ID id; // id for every pieces -> distint for every pieces
    protected ArrayList<Rectangle> listNextRectangles; // 
    protected Rectangle nextRectangle;

    protected enum STATE {
        idle, selected
    };

    protected STATE state;

    /**
     * Constructor for piece class
     * 
     * @param team
     * @param position
     * @param filename
     * @param player
     */
    public Piece(int team, Vector2i position, String filename, Player playerPieceManager, ID id) {
        this.team = team;
        this.position = position;
        this.filename = filename;
        this.isAlive = true;
        this.canSelect = false;
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
     * get the id of the piece
     * 
     * @return
     */
    public abstract ID getID();

    /**
     * mouse click function
     * 
     * @param mouseHandler
     * @param e
     */
    public abstract void onClick(MouseHandler mouseHandler, MouseEvent e);
}