package com.company.Figures;

import com.company.Figures.Triangle.Triangle;

public class Figures {
    public static void main(String[] args) {

        Triangle triangle = new Triangle();

        triangle.setTriangle();
        triangle.getTriangle();
        System.out.println("obwód = " + triangle.circuit());
        triangle.changePoint();
        triangle.getTriangle();
    }

}
