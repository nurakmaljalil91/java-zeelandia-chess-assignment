package com.assignment.game.states;

import java.awt.Graphics;

import com.assignment.game.utils.MouseHandler;

/**
 * class of gamestatemanager acts as manger which will manage all the state of
 * the game. State is also somtime call scene in game development
 * 
 * @author Nur Akmal "arcmole007"
 * @version 1.0
 * @since 2019-04-23
 */
public class GameStateManager {
    private GameState states[]; // array of states

    public static final int MENU = 0; 
    public static final int PLAY = 1;
    public static final int GAMEOVER = 2;

    /**
     * Constructor for the gamestatemanager
     */
    public GameStateManager() {
        states = new GameState[3]; // create a new states
        states[PLAY] = new PlayState(this); // initialize the state with playstate hence, the play state will start the game
    }

    /**
     * check if the state is active
     * @param state
     * @return 
     */
    public boolean isStateActive(int state) {
        return states[state] != null;
    }

    /**
     * get the state of the game based on the state number
     * @param state
     * @return
     */
    public GameState getState(int state) {
        return states[state];
    }

    /**
     * delete the state based on state number
     * @param state
     */
    public void pop(int state) {
        states[state] = null;
    }

    /**
     * add new state to the manager
     * @param state
     */
    public void add(int state) {
        if (states[state] != null)
            return;

        if (state == PLAY) {
            states[PLAY] = new PlayState(this);
        } else if (state == MENU) {
            states[MENU] = new MenuState(this);
        } else if (state == GAMEOVER) {
            states[GAMEOVER] = new GameOverState(this);
        }

    }

    /**
     * not sure about this function 
     * FIXME: learn more about me
     * @param state
     */
    public void addAndpop(int state) {
        addAndpop(state, 0);
    }

    /**
     * overloading function
     * @param state
     * @param remove
     */
    public void addAndpop(int state, int remove) {
        pop(state);
        add(state);
    }

    /**
     * update all the states in the manager
     */
    public void update() {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].update();
            }
        }
    }

    /**
     * update all the inputs in the manager
     * @param mouse
     */
    public void input(MouseHandler mouse) {

        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].input(mouse);
            }
        }
    }

    /**
     * update all the image rendering or draw in the game
     * @param g
     */
    public void draw(Graphics g) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].draw(g);
            }
        }
    }
}