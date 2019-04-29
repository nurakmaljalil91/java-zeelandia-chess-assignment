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
    /**
     * Constructor for the plus piece
     * 
     * @param team
     * @param position
     * @param filename
     */
    public Plus(int team, Vector2f position, String filename) {
        super(team, position, filename); // inherited the properties from piece parent
        BufferedImageLoader imageloader = new BufferedImageLoader(); // this is class to load image
        image = imageloader.loadImage(filename); // load the image from the filename
        this.name = "Plus";
        // create the rectangle from the position and size
        this.rectangle = new Rectangle((int) position.x * SIZE, (int) position.y * SIZE, SIZE, SIZE);
    }

    /**
     * update all the process of the piece
     */
    public void update() {
        // Update rectangle loaction
        updateRectangle();
        // if select
       

    }

    /**
     * update the input for the piece
     * @param mouseHandler
     * @param e
     */
    public void input(MouseHandler mouseHandler, MouseEvent e) {

        if (state == STATE.idle && selected == false) {
            select(mouseHandler, e);
        }
        clicked = false;
        if (state == STATE.selected) {
            //deselect(mouseHandler, e);
            move(mouseHandler, e);
        }

        clicked = false;

    }

    /**
     * draw the image
     * 
     * @param g
     */
    public void draw(Graphics g) {
        // draw the image based on the rectangle
        g.drawImage(image, rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        if (state == STATE.selected) {
            g.setColor(Color.RED);
            g.drawRect((int) position.x + 1 * 96, (int) position.y * 96, 96, 96);
            g.drawRect((int) position.x + 2 * 96, (int) position.y * 96, 96, 96);
            g.drawRect((int) position.x * 96, (int) position.y + 1 * 96, 96, 96);
            g.drawRect((int) position.x * 96, (int) position.y + 2 * 96, 96, 96);
        }
    }

    public void select(MouseHandler mouseHandler, MouseEvent e) {
        if (rectangle.contains(mouseHandler.getX(), mouseHandler.getY())) {
            if (mouseHandler.getButton() == 1 && !clicked) {
                state = STATE.selected;
                clicked = true;
                selected = true;
            }
        }
        mouseHandler.resetButton();
    }

    public void deselect(MouseHandler mouseHandler, MouseEvent e){
        if(rectangle.contains(mouseHandler.getX(), mouseHandler.getY())){
            if(mouseHandler.getButton() == 1 && !clicked){
                state = STATE.idle;
                clicked = true;
                selected = false;
            }
        }
        mouseHandler.resetButton();
    }
    /**
     * move the piece
     */
    public void move(MouseHandler mouseHandler, MouseEvent e) {
        if(mouseHandler.getButton() == 1 && !clicked){
            System.out.println("joking!");
        }
        mouseHandler.resetButton();
    }

    /**
     * piece can eat
     */
    public void eat() {

    }

    /**
     * update the rectangle location 
     */
    public void updateRectangle(){
        rectangle.setBounds((int)position.x, (int)position.y, SIZE, SIZE);
    }

}