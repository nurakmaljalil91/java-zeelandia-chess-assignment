package com.assignment.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * The game class for the game
 * 
 * @author Nur Akmal "arcmole007"
 * @version 1.0
 * @since 2019-04-19
 */

 /**
  * class game is inherited Canvas class properties 
  * implements the runnable where the game can start,run and stop
  */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 692; // width for the window screen 96 * 7 = 672 + 20
    public static final int HEIGHT = 624; // height for the window screen 96 * 6 = 576 + 48 
    public static final int TILESIZE = 96; // tileseze size for the tile in this case 64 * 64
    private Thread thread; // thread of the program
    public boolean isRunning = false; // check if the program is running

    // private MouseHandler mouseHandler;
    /**
     * Constructor for the game
     */
    public Game() {
        // Create window for the game
        Window window = new Window("Assignment 2019", WIDTH, HEIGHT, this);

    }

    /**
     * start the game start the thread
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;

    }

    /**
     * stop the game and clean the thread
     */
    public synchronized void stop() {
        try {
            thread.join();
            isRunning = false;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * run the game 
     * calculate the fps of the game
     * main loop of the game
     */
    public void run() {
        this.requestFocus(); // allow the game to be focus when start
        long lastTime = System.nanoTime(); // check the last time for the game
        double framePerSeconds = 60.0; // fps of the game
        double nanoSeconds = 1000000000 / framePerSeconds; // calculate the fps in ns
        double delta = 0; // delat time
        long timer = System.currentTimeMillis(); // start the timer
        int frames = 0; // init the frames
        // main loop of the game
        while (isRunning) {
            long now = System.nanoTime(); // time for now
            delta += (now - lastTime) / nanoSeconds; // delta time is time now divide by ns
            lastTime = now; // init back the last time record 
            while (delta >= 1) {
                update(); // update all game
                delta--;
            }
            if (isRunning) {
                draw(); // render object on the window

            }
            frames++; // increase the frames
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    /**
     * Initialize the game
     */
    public void initialize() {
        // mouseHandler = new MouseHandler();
    }

    /**
     * Update the game object inside the game
     */
    public void update() {

    }

    /**
     * Draw the grid for the pieces
     * @param g
     */
    public void drawGrids(Graphics g){
        g.setColor(Color.BLUE);
        for(int x = 0 ; x < WIDTH; x+=TILESIZE){
            g.drawLine(x, 0, x, HEIGHT);
        }
        for(int y = 0; y < HEIGHT; y+= TILESIZE){
            g.drawLine(0, y, WIDTH, y);
        }
    }

    /**
     * draw all the ojects on the window of the game
     */
    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(255, 255, 255)); // color for the background
        g.fillRect(0, 0, WIDTH, HEIGHT); // fill the background
        drawGrids(g); // draw the grid
        /*
         * drawGrid(g); if(player != null){ player.draw(g); } else{
         * System.err.println("Player is null???"); }
         * 
         * debug.draw(g);
         */
        // gsm.render(g);
        g.dispose(); // clear the window screen
        bs.show(); // show back the buffersrategy
    }

    /**
     * main function for running the game
     * @param args
     */
    public static void main(String[] args) {
        new Game();
    }
}
