package com.company.Figures.Point;

import java.util.List;

public interface PointInterface {
    public void setPointCoordinates(double x, double y);
    public void setPointName(String pointName);
    public double getPointX();
    public double getPointY();
    public double[] getCoordinates();
    public String getPointName();
}
