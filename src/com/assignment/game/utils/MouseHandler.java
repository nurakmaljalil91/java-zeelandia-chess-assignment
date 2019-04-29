package com.assignment.game.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.assignment.game.Game;
import com.assignment.game.gameobjects.ID;
import com.assignment.game.gameobjects.Piece;
import com.assignment.game.gameobjects.Player;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;
    private static boolean clicked = false;
    private boolean leftPressed, rightPressed;
    private Player playerPieceManager;

    public MouseHandler(Game game) {
        game.addMouseListener(this);
        game.addMouseMotionListener(this);
    }

    public void setPlayerPieces(Player playerPieceManager){
        this.playerPieceManager = playerPieceManager;
    }
    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
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

    public void resetButton() {
        mouseB = -1;
    }

    public boolean clickedOnce(MouseEvent e) {
        mouseClicked(e);
        return clicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            mouseB = e.getButton();
            clicked = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if (e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
        if(playerPieceManager != null){
            for(int i = 0; i < playerPieceManager.pieces.size(); i++) {
                Piece tempPiece = playerPieceManager.pieces.get(i);
                if(tempPiece.getID() == ID.bluePlus1){
                    tempPiece.onClick(this, e);
                }
                if(tempPiece.getID() == ID.bluePlus2){
                    tempPiece.onClick(this, e);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if (e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;
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