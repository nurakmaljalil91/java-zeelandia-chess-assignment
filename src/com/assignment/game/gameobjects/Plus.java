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
        this.rectangle = new Rectangle((int) position.x * 96, (int) position.y * 96, 96, 96);
    }

    /**
     * update all the process of the piece
     */
    public void update() {
        // if select

    }

    public void input(MouseHandler mouseHandler, MouseEvent e) {

        if (state == STATE.idle && selected == false) {
            if (rectangle.contains(mouseHandler.getX(), mouseHandler.getY())) {
                // System.out.println("The mouse is at " + name+" "+team);
                if (mouseHandler.getButton() == 1 && !clicked) {
                    state = STATE.selected;
                    clicked = true;
                    selected = true;
                }

            }
        }
      
        
        clicked = false;

        
    }

    /**
     * draw the image
     * 
     * @param g
     */
    public void draw(Graphics g) {
        // draw the image
        g.drawImage(image, (int) position.x * 96, (int) position.y * 96, 96, 96, null);
        if (state == STATE.selected) {
            g.setColor(Color.RED);
            g.fillRect((int) position.x + 1 * 96, (int) position.y * 96, 96, 96);
            g.fillRect((int) position.x + 2 * 96, (int) position.y * 96, 96, 96);
            g.fillRect((int) position.x * 96, (int) position.y + 1 * 96, 96, 96);
            g.fillRect((int) position.x * 96, (int) position.y + 2 * 96, 96, 96);
        }
    }

    public void select() {
        
    }

    /**
     * move the piece
     */
    public void move() {

    }

    /**
     * piece can eat
     */
    public void eat() {

    }

}