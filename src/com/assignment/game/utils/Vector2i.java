package com.assignment.game.utils;

public class Vector2i {

    public int x;
    public int y;

    public static int worldX;
    public static int worldY;

    public Vector2i() {
        x = 0;
        y = 0;
    }

    public Vector2i(Vector2i vec) {
        new Vector2f(vec.x, vec.y);
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addX(int f) { x += f; }
    public void addY(int f) { y += f; }

    public void setX(int f) { x = f; }
    public void setY(int f) { y = f; }

    public void setVector(Vector2i vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    public void setVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void setWorldVar(int x, int y) {
        worldX = x;
        worldY = y;
    }

    public static int getWorldVarX(int x) {
        return x - worldX;
    }

    public static int getWorldVarY(int y) {
        return y - worldY;
    }

    public Vector2f getWorldVar() {
        return new Vector2f(x - worldX, y - worldY);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

}