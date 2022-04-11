package com.company.Figures.Point;

import java.util.Scanner;

public class Point implements PointInterface{
    private String pointName;
    private double x,y;

    public Point() {
        this.pointName = "";
    }
    public boolean EqualsTo(Point p) {
        return p.pointName.equals(this.pointName) && (p.x == this.x) && (p.y == this.y);
    }

    public void setPointCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public double getPointX() {
        return this.x;
    }

    public double getPointY() { return this.y; }

    public double[] getCoordinates(){ return new double[] {this.x,this.y};}

    public String getPointName() {
        return pointName;
    }

    public String parseToString() {
        return this.getPointName() + "=(" + this.getPointX() + ", " + this.getPointY() + ")";
    }
}