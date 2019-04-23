package com.assignment.game.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.assignment.game.utils.BufferedImageLoader;
import com.assignment.game.utils.Vector2f;

/**
 * class plus is a piece plus inherited the piece parent
 * class, plus can move vertically or horizontally up to 
 * 2 steps in any direction in straight line
 * @author  Nur Akmal "arcmole007"
 * @version 1.0
 * @since 2019-04-23
 */
public class Plus extends Piece {
    /**
     * Constructor for the plus piece 
     * @param team
     * @param position
     * @param filename
     */
    public Plus(int team, Vector2f position, String filename) {
        super(team, position, filename); // inherited the properties from piece parent
        BufferedImageLoader imageloader = new BufferedImageLoader(); // this is class to load image
        image = imageloader.loadImage(filename); // load the image from the filename
        
    }
    
    /**
     * update all the process of the piece
     */
    public void update() {
        // if select
    }


    /**
     * draw the image
     * @param g
     */
    public void draw(Graphics g) {
        // draw the image 
		g.drawImage(image,(int)position.x * 96, (int)position.y * 96, 96, 96, null);

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