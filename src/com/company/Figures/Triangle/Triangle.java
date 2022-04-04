package com.company.Figures.Triangle;

import com.company.Figures.FiguresInterface;
import com.company.Figures.Point.Point;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.lang.Math;

public class Triangle implements FiguresInterface {
    List<Point> points;
    Scanner sc;
    private double circuit, area;
    private double[] sides;

    public Triangle() {
        points = new ArrayList<Point>();
        sc = new Scanner(System.in);
        sides = new double[]{0.0, 0.0, 0.0};
        Point A = new Point();
        points.add(A);
        Point B = new Point();
        points.add(B);
        Point C = new Point();
        points.add(C);
    }

    public void setTriangle() {
        String text;
        double x,y;
        boolean triangleExists = false;

        while(!triangleExists) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Podaj nazwę " + i + ". punktu:");
                text = sc.nextLine();
                points.get(i).setPointName(text);

                System.out.println("Podaj współrzędne punktu:");
                x = sc.nextDouble();
                y = sc.nextDouble();
                points.get(i).setPointCoordinates(x, y);
                sc.nextLine();
            }
            createSides();
            if(!checkTriangle()) {
                System.err.println("Takie trójkąt nie może istnieć!");
            } else {
                triangleExists = true;
            }
        }
    }

    protected void createSides() {
        int j,i;
        for(i = 0; i < 3; i++) {
            j=i+1;
            if(i==2)
                j=0;
            sides[i] = distanceBetweenPoints(points.get(i).getCoordinates(),points.get(j).getCoordinates());
        }
    }

    protected boolean checkTriangle() {
        return (sides[0] + sides[1] > sides[2]) && (sides[1] + sides[2] > sides[0]) && (sides[0] + sides[2] > sides[1]);
    }

    @Override
    public void changePoint() {
        String pointName, newName;
        Point point;
        double x,y;
        boolean triangleExists = false;

        System.out.println("podaj nazwę punku, który chcesz zmienić:");
        pointName = sc.nextLine();
        try {
            while(!triangleExists) {
                point = findPoint(pointName);

                System.out.println("Podaj nową nazwę punktu:");
                newName = sc.nextLine();
                point.setPointName(newName);

                System.out.println("Podaj nowe współrzędne:");
                x = sc.nextDouble();
                y = sc.nextDouble();
                point.setPointCoordinates(x, y);

                createSides();
                if (!checkTriangle()) {
                    System.err.println("Takie trójkąt nie może istnieć!");
                } else {
                    triangleExists = true;
                }
            }
        } catch(NullPointerException e) {
            System.out.println("Taki punkt nie istnieje!");
        }
    }

    protected Point findPoint(String pointName) {
        for(Point point : points) {
            if(point.getPointName().equals(pointName))
                return point;
        }
        return null;
    }

    public void getTriangle() {
        String line;
        for(int i = 0; i < 3; i++) {
            line = parseToString(points.get(i));
            System.out.println(line);
        }
    }

    protected String parseToString(Point point) {
        return point.getPointName() + "=(" + point.getPointX() + ", " + point.getPointY() + ")";
    }

    @Override
    public double circuit() {
        return sides[0]+sides[1]+sides[2];
    }

    @Override
    public double area(String pointName) {
        return 0;
    }

    @Override
    public double distanceBetweenPoints(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point2[0]-point1[0],2)+Math.pow(point2[1]-point1[1],2));
    }
}