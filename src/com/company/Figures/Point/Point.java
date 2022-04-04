package com.company.Figures.Point;

public class Point implements PointInterface{
    private String pointName;
    private double x,y;

    public Point() {
        this.pointName = "";
        this.x = 0.0;
        this.y = 0.0;
    }

    public void setPointCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPointName(String pointName) { this.pointName = pointName; }

    public double getPointX() {
        return this.x;
    }

    public double getPointY() { return this.y; }

    public double[] getCoordinates(){ return new double[] {this.x,this.y};}

    public String getPointName() {
        return pointName;
    }

}