package com.assignment.game.states;

/**
 * class of gamestatemanager acts as manger which will manage all the state of
 * the game. State is also somtime call scene in game development
 * 
 * @author Nur Akmal "arcmole007"
 * @version 1.0
 * @since 2019-04-23
 */
public class GameStateManager {
    private GameState states[];

    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int GAMEOVER = 2;

    public GameStateManager() {
        states = new GameState[3];

    }

    public boolean isStateActive(int state) {
        return states[state] != null;
    }

    public GameState getState(int state) {
        return states[state];
    }

    public void pop(int state) {
        states[state] = null;
    }

    public void add(int state) {
        if (states[state] != null)
            return;

        if (state == PLAY) {
            states[PLAY] = new PlayState(this);
        } else if (state == MENU) {
            states[MENU] = new MenuState(this);
        } else if (state == PAUSE) {
            states[PAUSE] = new PauseState(this);
        } else if (state == GAMEOVER) {
            states[GAMEOVER] = new GameOverState(this);
        } else if (state == EDIT) {
            if (states[PLAY] != null) {
                states[EDIT] = new EditState(this, cam);
            }
        }
    }

    public void addAndpop(int state) {
        addAndpop(state, 0);
    }

    public void addAndpop(int state, int remove) {
        pop(state);
        add(state);
    }

    public void update(double time) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].update(time);
            }
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {

        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].input(mouse, key);
            }
        }
    }

    public void render(Screen s) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].render(s);
            }
        }
    }
}