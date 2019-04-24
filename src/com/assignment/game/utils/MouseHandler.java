package com.assignment.game.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.assignment.game.Game;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;
    private static boolean clicked = false;
    public MouseHandler(Game game) {
        game.addMouseListener(this);
        game.addMouseMotionListener(this);
    }

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

    public int getButton() {
        return mouseB;
    }
    
    public boolean clickedOnce(MouseEvent e){
        mouseClicked(e);
        return clicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            mouseB = e.getButton();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}