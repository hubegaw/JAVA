package com.company.Figures.Quadrangle;

import com.company.Figures.FiguresInterface;
import com.company.Figures.Point.Point;
import com.company.exceptions.PointAlreadyExistsException;
import com.company.exceptions.FigureCantExists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quadrangle implements FiguresInterface {
    List<Point> points;
    List<Double> sides;
    Scanner sc;
    private double perimeter, area, diagonal1, diagonal2;
    private String[] text = {"lewego dolnego", "prawego dolnego", "prawego górnego", "lewego górnego"};

    public Quadrangle() {
        points = new ArrayList<Point>();
        sc = new Scanner(System.in);
        sides = new ArrayList<Double>();
    }

    public void setQuadrangle() {
        int i = 0;
        try {
            while (i < 4) {
                try {
                    Point point = new Point();

                    setQuadPointName(point, "Podaj nazwę punktu " + text[i]);
                    setQuadPointCoordinates(point, "Podaj współrzędne punktu " + text[i]);
                    points.add(point);

                    if (checkPoint(point)) {
                        points.remove(point);
                        throw new PointAlreadyExistsException("Taki punkt już istnieje!");
                    }
                    i++;
                } catch (PointAlreadyExistsException e) {
                    System.err.println(e.getMessage());
                }
                sc.nextLine();
            }
            createSides();
            if(!checkQuadrangle()) {
                throw new FigureCantExists("Taki czworokąt nie może istnieć!");
            }
            diagonals();
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

                    setQuadPointName(point, "Podaj nową nazwę punktu");
                    setQuadPointCoordinates(point, "Podaj nowe współrzędne punktu");

                    if (checkPoint(point)) {
                        throw new PointAlreadyExistsException("Taki punkt już istnieje!");
                    }
                } catch (NullPointerException e1) {
                    System.err.println("Taki punkt nie istnieje!");
                } catch (PointAlreadyExistsException e2) {
                    System.err.println(e2.getMessage());
                }
                createSides();
                if (!checkQuadrangle()) {
                    throw new FigureCantExists("Taki czworokąt nie może istnieć!");
                }
                diagonals();
                perimeter();
                area();
                pointChanged = true;
            } catch (FigureCantExists e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void setQuadPointName(Point point, String line) {
        System.out.println(line);
        String name = sc.nextLine();
        point.setPointName(name);
    }

    private void setQuadPointCoordinates(Point point, String line) {
        double x,y;
        System.out.println(line);
        x = sc.nextDouble();
        y = sc.nextDouble();
        point.setPointCoordinates(x,y);
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
        for(Double s : sides) {
            perimeter += s;
        }
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void area() {
        double halfCircuit = (sides.get(0)+sides.get(1)+diagonal1)/2;
        area = Math.sqrt(halfCircuit*(halfCircuit-sides.get(0))*(halfCircuit-sides.get(1))*(halfCircuit-sides.get(2))) +
                Math.sqrt(halfCircuit*(halfCircuit-sides.get(0))*(halfCircuit-sides.get(2))*(halfCircuit-sides.get(3)));
    }

    public double getArea() {
        return area;
    }

    public void diagonals() {
        diagonal1 = distanceBetweenPoints(points.get(0).getCoordinates(),points.get(2).getCoordinates());
        diagonal2 = distanceBetweenPoints(points.get(1).getCoordinates(),points.get(3).getCoordinates());
    }

    public Double[] getDiagonals(){
        return new Double[]{diagonal1,diagonal2};
    }

    @Override
    public double distanceBetweenPoints(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point2[0]-point1[0],2)+Math.pow(point2[1]-point1[1],2));
    }

    private void createSides() {
        int j,i;
        for(i = 0; i < 4; i++) {
            j=i+1;
            if(i==3)
                j=0;
            sides.add(distanceBetweenPoints(points.get(i).getCoordinates(),points.get(j).getCoordinates()));
        }
    }

    private boolean checkQuadrangle() {
        return !points.get(0).equals(points.get(1)) && !points.get(0).equals(points.get(2)) && !points.get(0).equals(points.get(3))
                && !points.get(1).equals(points.get(2)) && !points.get(1).equals(points.get(3)) && !points.get(2).equals(points.get(3));
    }

    private Point findPoint(String pointName) {
        for(Point point : points) {
            if(point.getPointName().equals(pointName))
                return point;
        }
        return null;
    }

    public void getQuadrangle() {
        String line;
        for(int i = 0; i < 4; i++) {
            line = points.get(i).parseToString();
            System.out.println(line);
        }
    }

}
