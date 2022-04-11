package com.company.Figures.Triangle;

import com.company.Figures.FiguresInterface;
import com.company.Figures.Point.Point;
import com.company.exceptions.FigureCantExists;
import com.company.exceptions.PointAlreadyExistsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Triangle implements FiguresInterface {
    List<Point> points;
    List<Double> sides;
    Scanner sc;
    private double perimeter, area, height;

    public Triangle() {
        points = new ArrayList<Point>();
        sc = new Scanner(System.in);
        sides = new ArrayList<Double>();
    }

    public void setTriangle() {
        int i = 0;
        try {
            while(i < 3) {
                try {
                    Point point = new Point();

                    setTrianglePointName(point, "Podaj nazwę punktu");
                    setTrianglePointCoordinates(point, "Podaj współrzędne punktu");
                    points.add(point);

                    if (checkPoint(point)) {
                        points.remove(point);
                        throw new PointAlreadyExistsException("Taki punkt już istnieje!");
                    }
                    i++;
                } catch(PointAlreadyExistsException e) {
                    System.err.println(e.getMessage());
                }
                sc.nextLine();
            }
            createSides();
            if(!checkTriangle()) {
                throw new FigureCantExists("Taki trójkąt nie może istnieć!");
            }
            perimeter();
            area();
        } catch(FigureCantExists e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void changePoint() {
        String pointName;
        Point point;
        boolean pointChanged = false;
        while(!pointChanged) {
            try {
                try {
                    System.out.println("podaj nazwę punktu, który chcesz zmienić:");
                    pointName = sc.nextLine();
                    point = findPoint(pointName);

                    setTrianglePointName(point, "Podaj nową nazwę punktu");
                    setTrianglePointCoordinates(point, "Podaj nowe współrzędne punktu");

                    if (checkPoint(point)) {
                        throw new PointAlreadyExistsException("Taki punkt już istnieje!");
                    }
                } catch (NullPointerException e1) {
                    System.err.println("Taki punkt nie istnieje!");
                } catch (PointAlreadyExistsException e2) {

                    System.err.println(e2.getMessage());
                }
                createSides();
                if (!checkTriangle()) {
                    throw new FigureCantExists("Taki trójkąt nie może istnieć!");
                }
                perimeter();
                area();
                pointChanged = true;
            } catch (FigureCantExists e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void createSides() {
        int j,i;
        for(i = 0; i < 3; i++) {
            j=i+1;
            if(i==2)
                j=0;
            sides.add(distanceBetweenPoints(points.get(i).getCoordinates(),points.get(j).getCoordinates()));
        }
    }

    private void setTrianglePointName(Point point, String line) {
        System.out.println(line);
        String name = sc.nextLine();
        point.setPointName(name);
    }

    private void setTrianglePointCoordinates(Point point, String line) {
        double x,y;
        System.out.println(line);
        x = sc.nextDouble();
        y = sc.nextDouble();
        point.setPointCoordinates(x,y);
    }

    protected boolean checkTriangle() {
        return (sides.get(0) + sides.get(1) > sides.get(2)) && (sides.get(1) + sides.get(2) > sides.get(0)) && (sides.get(0) + sides.get(2) > sides.get(1));
    }

    private Point findPoint(String pointName) {
        for(Point point : points) {
            if(point.getPointName().equals(pointName))
                return point;
        }
        return null;
    }

    private boolean checkPoint(Point point) {
        int k = 0;
        for(Point p : points) {
            if(p.getPointName().equals(point.getPointName()) || Arrays.equals(p.getCoordinates(), point.getCoordinates())){
                k++;
            }
        }
        return k > 1;
    }

    @Override
    public void perimeter() {
        for(Double s : sides){
            perimeter += s;
        }
    }

    public double getPerimeter(){
        return perimeter;
    }

    @Override
    public void area() {
        double halfOfPerim = perimeter/2;
        area = Math.sqrt(halfOfPerim*(halfOfPerim-sides.get(0))*(halfOfPerim-sides.get(1))*(halfOfPerim-sides.get(2)));
    }

    public double getArea(){
        return area;
    }

    public void height() {
        Point point;
        String pointName;
        double side;
        int k;
        try {
            System.out.println("Podaj nazwę punktu, z którego mam obliczyć wysokość");
            pointName = sc.nextLine();
            int i = 0;
            point = findPoint(pointName);
            while(i<3){
                if(points.get(i).EqualsTo(point)){
                    if((i-1) < 0) {
                        k = 2;
                        side = distanceBetweenPoints(points.get(k).getCoordinates(),points.get(i+1).getCoordinates());
                    }
                    else if((i+1) > 2) {
                         k = 0;
                        side = distanceBetweenPoints(points.get(k).getCoordinates(),points.get(i-1).getCoordinates());
                    } else {
                        side = distanceBetweenPoints(points.get(i-1).getCoordinates(),points.get(i+1).getCoordinates());
                    }
                    height = 2*area/side;
                }
                i++;
            }
        }catch(NullPointerException e) {
            System.err.println("Taki punkt nie istnieje!");
        }
    }

    public double distanceBetweenPoints(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point2[0]-point1[0],2)+Math.pow(point2[1]-point1[1],2));
    }

    public void getTriangle() {
        String line;
        for(int i = 0; i < 3; i++) {
            line = points.get(i).parseToString();
            System.out.println(line);
        }
    }
}