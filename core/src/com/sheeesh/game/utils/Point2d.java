package com.sheeesh.game.utils;

import java.rmi.Remote;

public class Point2d implements Remote {
    
    private double x;
    private double y;

    public Point2d(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public double getX() {

        return this.x;
    }

    public double getY() {

        return this.y;
    }
}