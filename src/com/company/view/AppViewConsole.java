package com.company.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.company.Figures.Triangle.Triangle;
import com.company.Figures.Quadrangle.Quadrangle;
import com.company.exceptions.FiguresListIsEmpty;

public class AppViewConsole implements AppViewInterface {
    private List<Triangle> triangles = new ArrayList<>();
    private List<Quadrangle> quadrangles = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void mainMenu() {
        int choice;
        boolean closeProgram = false;

        System.out.println("Witaj w programie!");
        while(!closeProgram) {
            System.out.println("Wpisz 1, aby otworzyć menu trójkąta.");
            System.out.println("Wpisz 2, aby otworzyć menu czworokąta.");
            System.out.println("Wpisz 3, aby zakończyć program.");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> triangleMenu();
                case 2 -> quadrangleMenu();
                case 3 -> closeProgram = true;
                default -> System.out.println("Błędny wybór!");
            }
        }
    }

    @Override
    public void triangleMenu() {
        int choice, trNumb;
        boolean leaveMenu = false;

        System.out.println("\tMenu: trójkąt\n");

        while(!leaveMenu) {
            System.out.println("Wpisz 1, aby wyświetlić trójkąty.");
            System.out.println("Wpisz 2, aby stworzyć trójkąt.");
            System.out.println("Wpisz 3, aby poznać szczegóły konkretnego trójkąta.");
            System.out.println("Wpisz 4, aby edytować konkretny trójkąt.");
            System.out.println("Wpisz 5, aby wyjść z menu.");
            choice = sc.nextInt();

            switch(choice) {
                case 1 -> {
                    try {
                        if (triangles.isEmpty()) {
                            throw new FiguresListIsEmpty("Nie ma jeszcze żadnych trójkątów!");
                        }
                        getTriangles();
                    } catch(FiguresListIsEmpty e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> {
                    Triangle triangle = new Triangle();
                    triangles.add(triangle);

                    triangle.setTriangle();
                }
                case 3 -> {
                    try {
                        if (triangles.isEmpty()) {
                            throw new FiguresListIsEmpty("Nie ma jeszcze żadnych trójkątów!");
                        }
                        System.out.println("Podaj numer trójkąta:");
                        trNumb = sc.nextInt() - 1;

                        System.out.println("Pole:" + triangles.get(trNumb).getArea());
                        System.out.println("Obwód:" + triangles.get(trNumb).getPerimeter());
                        triangles.get(trNumb).height();
                    } catch(FiguresListIsEmpty e) {
                        System.err.println(e.getMessage());
                    }

                }
                case 4 -> {
                    try {
                        if(triangles.isEmpty()) {
                            throw new FiguresListIsEmpty("Nie ma jeszcze żadnych trójkątów!");
                        }
                        System.out.println("Podaj numer czworokąta:");
                        trNumb = sc.nextInt() - 1;

                        triangles.get(trNumb).changePoint();
                    } catch(FiguresListIsEmpty e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 5 -> leaveMenu = true;
            }
        }
    }

    @Override
    public void quadrangleMenu() {
        int choice;
        boolean leaveMenu = false;

        System.out.println("\tMenu: czworokąt");

        while(!leaveMenu) {
            System.out.println("Wpisz 1, aby wyświetlić czworokąty.");
            System.out.println("Wpisz 2, aby stworzyć czworokąt.");
            System.out.println("Wpisz 3, aby poznać szczegóły konkretnego czworokąta.");
            System.out.println("Wpisz 4, aby edytować konkretny czworokąt.");
            System.out.println("Wpisz 5, aby wyjść z menu.");
            choice = sc.nextInt();

            switch(choice) {
                case 1 -> {
                    try {
                        if (quadrangles.isEmpty()) {
                            throw new FiguresListIsEmpty("Nie ma jeszcze żadnych czworokątów!");
                        }
                        getQuadrangles();
                    } catch(FiguresListIsEmpty e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> {
                    Quadrangle quadrangle = new Quadrangle();
                    quadrangles.add(quadrangle);

                    quadrangle.setQuadrangle();
                }
                case 3 -> {
                    try {
                        if (quadrangles.isEmpty()) {
                            throw new FiguresListIsEmpty("Nie ma jeszcze żadnych czworokątów!");
                        }
                        int quadNumb;
                        System.out.println("Podaj numer czworokąta:");
                        quadNumb = sc.nextInt() - 1;

                        System.out.println("Pole:" + quadrangles.get(quadNumb).getArea());
                        System.out.println("Obwód:" + quadrangles.get(quadNumb).getPerimeter());
                        System.out.println("Przekątne:\n" +
                                "AC: " + quadrangles.get(quadNumb).getDiagonals()[0] +
                                "\nBD: " + quadrangles.get(quadNumb).getDiagonals()[1]);
                    } catch(FiguresListIsEmpty e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        if (quadrangles.isEmpty()) {
                            throw new FiguresListIsEmpty("Nie ma jeszcze żadnych czworokątów!");
                        }
                        int quadNumb;
                        System.out.println("Podaj numer czworokąta:");
                        quadNumb = sc.nextInt() - 1;

                        quadrangles.get(quadNumb).changePoint();
                    } catch(FiguresListIsEmpty e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 5 -> leaveMenu = true;
            }
        }
    }

    private void getTriangles() {
        int i = 1;
        for(Triangle tr : triangles) {
            System.out.println("nr."+i);
            tr.getTriangle();
            i++;
        }
    }

    private void getQuadrangles() {
        int i = 1;
        for(Quadrangle quad : quadrangles) {
            System.out.println("\nnr."+i);
            quad.getQuadrangle();
            i++;
        }
    }
}