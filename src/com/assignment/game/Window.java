package com.assignment.game;
/**
 * The window class for the graphics of 
 * the program to be render and update
 * 
 * @author Nur Akmal "arcmole007"
 * @version 0.1.0
 * @since   2019-04-19
 */
import java.awt.Dimension;
import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas {
    /**
     * Constructor for the window
     * @param title
     * @param width
     * @param height
     * @param game
     */
    public Window(String title, int width, int height, Game game) {
        JFrame frame = new JFrame(title); // create a new window or frame
        frame.setSize(new Dimension(width,height)); // set the size of the frame
        frame.setLocationRelativeTo(null); // set the location of the frame
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // can close the frame
        frame.setVisible(true); // make the frame visible
        frame.add(game); // add the game to be render inside the frame

        game.start(); // start the game
    }

}