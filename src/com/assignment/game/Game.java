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

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 448;
    public static final int HEIGHT = 424;
    public static final int TILESIZE = 64;
    private Thread thread;
    public boolean isRunning = false;

    // private MouseHandler mouseHandler;

    public Game() {
        Window window = new Window("Assignment 2019", WIDTH, HEIGHT, this);

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;

    }

    public synchronized void stop() {
        try {
            thread.join();
            isRunning = false;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double framePerSeconds = 60.0;
        double nanoSeconds = 1000000000 / framePerSeconds;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoSeconds;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            if (isRunning) {
                draw();

            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void initialize() {
        // mouseHandler = new MouseHandler();
    }

    public void update() {

    }
    public void drawGrids(Graphics g){
        g.setColor(Color.black);
        for(int x = 0 ; x < WIDTH; x+=TILESIZE){
            g.drawLine(x, 0, x, HEIGHT);
        }
        for(int y = 0; y < HEIGHT; y+= TILESIZE){
            g.drawLine(0, y, WIDTH, y);
        }
    }
    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(66, 134, 244));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        drawGrids(g);
        /*
         * drawGrid(g); if(player != null){ player.draw(g); } else{
         * System.err.println("Player is null???"); }
         * 
         * debug.draw(g);
         */
        // gsm.render(g);
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
