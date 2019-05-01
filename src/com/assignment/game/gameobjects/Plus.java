package com.assignment.game.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.assignment.game.utils.BufferedImageLoader;
import com.assignment.game.utils.MouseHandler;
import com.assignment.game.utils.Vector2f;

/**
 * class plus is a piece plus inherited the piece parent class, plus can move
 * vertically or horizontally up to 2 steps in any direction in straight line
 * 
 * @author Nur Akmal "arcmole007"
 * @version 1.0
 * @since 2019-04-23
 */
public class Plus extends Piece {

    private boolean isNextRectangleRight1;
    private boolean isNextRectangleRight2;
    private boolean isNextRectangleLeft1;
    private boolean isNextRectangleLeft2;
    private boolean isNextRectangleDown1;
    private boolean isNextRectangleDown2;
    private boolean isNextRectangleUp1;
    private boolean isNextRectangleUp2;

    /**
     * Constructor for the plus piece
     * 
     * @param team
     * @param position
     * @param filename
     */
    public Plus(int team, Vector2f position, String filename, Player playerPieceManager, ID id) {
        super(team, position, filename, playerPieceManager, id); // inherited the properties from piece parent
        BufferedImageLoader imageloader = new BufferedImageLoader(); // this is class to load image
        image = imageloader.loadImage(filename); // load the image from the filename
        this.name = "Plus";
        // create the rectangle from the position and size
        this.rectangle = new Rectangle((int) position.x * SIZE, (int) position.y * SIZE, SIZE, SIZE);
        this.listNextRectangles = new ArrayList<Rectangle>();
        isNextRectangleLeft1 = false;
        isNextRectangleLeft2 = false;
        isNextRectangleRight1 = false;
        isNextRectangleRight2 = false;
        isNextRectangleDown1 = false;
        isNextRectangleDown2 = false;
        isNextRectangleRight1 = false;
        isNextRectangleUp2 = false;
    }

    /**
     * update all the process of the piece
     */
    public void update() {
        // Update rectangle loaction
        updateRectangle();
        // if select
        if (state == STATE.selected) {
            checkRightTile();
            // checkLeftTile();
            checkLeftDebug();
        }
        if (state == STATE.idle && canSelect == false) {
            // select(mouseHandler, e);
            clear();
        }

        for(int i = 0 ; i < playerPieceManager.pieces.size(); i++){
            System.out.println(playerPieceManager.pieces.get(i).rectangle.getBounds());
        }

    }

    /**
     * update the input for the piece
     * 
     * @param mouseHandler
     * @param e
     */
    public void input(MouseHandler mouseHandler, MouseEvent e) {

    }

    /**
     * draw the image
     * 
     * @param g
     */
    public void draw(Graphics g) {
        // draw the image based on the rectangle
        g.drawImage(image, rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);

        g.setColor(Color.RED);
        if (!listNextRectangles.isEmpty()) {
            for (Rectangle r : listNextRectangles) {
                g.drawRect(r.x, r.y, r.width, r.height);
            }
        }

    }

    /**
     * update the rectangle location
     */
    public void updateRectangle() {
        rectangle.setBounds((int) position.x * SIZE, (int) position.y * SIZE, SIZE, SIZE);
    }

    /**
     * check if next tile conatain another own peice hence, you can move there
     * 
     * @param nextX
     * @param nextY
     */
    public boolean checkNextTile(int nextX, int nextY) {
        boolean checker = false;
        for (int i = 0; i < playerPieceManager.pieces.size(); i++) {
            Piece tempPiece = playerPieceManager.pieces.get(i);
            if (tempPiece.position.x * SIZE == nextX * SIZE && tempPiece.position.y * SIZE == nextY * SIZE) {
                checker = false;
            } else {
                // listNextRectangles.add(nextRectangle = new Rectangle(nextX * SIZE, nextY *
                // SIZE, SIZE, SIZE));
                checker = true;
            }
        }

        return checker;
    }

    public ID getID() {
        return id;
    }

    public void onClick(MouseHandler mouseHandler, MouseEvent e) {
        // this is the select mechanic
        if (rectangle.contains(mouseHandler.getX(), mouseHandler.getY())) {
            if (e.getButton() == 1) {
                // select mechanic
                if (state == STATE.idle) {
                    state = STATE.selected;
                    System.out.println("clicked");
                }
                // deselect
                else if (state == STATE.selected) {
                    state = STATE.idle;
                }
            }
        }
        // this is move and mechanic
        for (int i = 0; i < listNextRectangles.size(); i++) {
            if (listNextRectangles.get(i).contains(mouseHandler.getX(), mouseHandler.getY())) {
                if (e.getButton() == 1) {
                    if (state == STATE.selected) {
                        // System.out.println(listNextRectangles.get(i).x + "," +
                        // listNextRectangles.get(i).y);
                        this.position.x = listNextRectangles.get(i).x / SIZE; // update the position
                        this.position.y = listNextRectangles.get(i).y / SIZE;
                        state = STATE.idle;
                    }
                }
            }
        }

    }

    public void clear() {
        if (!listNextRectangles.isEmpty()) {
            listNextRectangles.clear();
        }
        isNextRectangleLeft1 = false;
        isNextRectangleLeft2 = false;
        isNextRectangleRight1 = false;
        isNextRectangleRight2 = false;
        isNextRectangleDown1 = false;
        isNextRectangleDown2 = false;
        isNextRectangleRight1 = false;
        isNextRectangleUp2 = false;
    }

    public void checkRightTile() {
        // check right pieces
        int numberOfRectCreated = 0;
        for (int i = 1; i <= 2; i++) {
            // if true for each

            if (checkNextTile((int) this.position.x + i, (int) this.position.y)) {
                numberOfRectCreated += 1;

            }
            // if already a piece in next tile break the loop no need to create rectangle at
            // all
            if (numberOfRectCreated == 0) {
                break;
            }

        }

        if (numberOfRectCreated == 2 && !isNextRectangleRight1 && !isNextRectangleRight2) {

            // somehow I cannot use position but only the rectangle position....weird!

            listNextRectangles.add(nextRectangle = new Rectangle((int) rectangle.getX() + 1 * SIZE,
                    (int) rectangle.getY() * SIZE, SIZE, SIZE));
            isNextRectangleRight1 = true;
            listNextRectangles.add(nextRectangle = new Rectangle((int) rectangle.getX() + 2 * SIZE,
                    (int) rectangle.getY() * SIZE, SIZE, SIZE));
            isNextRectangleRight1 = true;

        } else if (numberOfRectCreated == 1 && !isNextRectangleRight1) {
            listNextRectangles.add(nextRectangle = new Rectangle((int) rectangle.getX() + 1 * SIZE,
                    (int) rectangle.getY() * SIZE, SIZE, SIZE));
            isNextRectangleRight1 = true;
        }

    }

    public void checkLeftTile() {
        // check left pieces
        int numberOfRectCreated = 0;
        for (int i = 1; i <= 2; i++) {
            // if true for each

            if (checkNextTile((int) rectangle.getX() - i, (int) this.rectangle.getY())) {
                numberOfRectCreated += 1;

            }
            // if already a piece in next tile break the loop no need to create rectangle at
            // all
            if (numberOfRectCreated == 0) {
                break;
            }
            System.out.println("ey " + numberOfRectCreated);

        }

        if (numberOfRectCreated == 2 && !isNextRectangleLeft1 && !isNextRectangleLeft2) {

            // somehow I cannot use position but only the rectangle position....weird!

            listNextRectangles.add(nextRectangle = new Rectangle((int) rectangle.getX() - 1 * SIZE,
                    (int) rectangle.getY() * SIZE, SIZE, SIZE));
            isNextRectangleLeft1 = true;
            listNextRectangles.add(nextRectangle = new Rectangle((int) rectangle.getX() - 2 * SIZE,
                    (int) rectangle.getY() * SIZE, SIZE, SIZE));
            isNextRectangleLeft1 = true;

        } else if (numberOfRectCreated == 1 && !isNextRectangleLeft1) {
            listNextRectangles.add(nextRectangle = new Rectangle((int) rectangle.getX() - 1 * SIZE,
                    (int) rectangle.getY() * SIZE, SIZE, SIZE));
            isNextRectangleLeft1 = true;
        }

    }

    public void checkLeftDebug() {
        // check left pieces
        int numberOfRectCreated = 0;
        for (int i = 1; i <= 2; i++) {
            // if true for each
            System.out.println(checkNextTile((int) rectangle.getX() + i, (int) this.rectangle.getY()));
        }

    }

}