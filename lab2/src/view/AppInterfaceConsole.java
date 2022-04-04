package view;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import java.util.Scanner;

public class AppInterfaceConsole {
    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    private Scanner sc;
    double a, b;
    int n;
    private double[] Results = {0,0,0};

    protected double parseWithMessage(String message) {
        System.out.println(message);
        String line;
        double res;
        try {
            line = sc.nextLine();
            res = Double.parseDouble(line);
        }
        catch (Exception ex) {
            System.err.println("Wprowadzono niepoprawne dane!");
            res = parseWithMessage(message);
        }
        return res;
    }

    protected void parseNumbers() {
        a = parseWithMessage("Wprowadź początek przedziału a: ");
        algorithm.setA(a);
        b = parseWithMessage("Wprowadź koniec przedziału b: ");
        algorithm.setB(b);
        n = (int) parseWithMessage("Wprowadź liczbę przedziałów n: ");
        algorithm.setN(n);
    }

    protected void displaySolutions() {
        String label = "";
        String countMethods[] = {"MonteCarlo", "Metoda Trapezów"};

        for(int i = 0; i < countMethods.length; i++) {
            label = "\n" + countMethods[i] + ":";
            label += "\nNumeryczna\t" + Results[0];
            label += "\nDokładna\t" + Results[1];
            label += "\nBłąd\t" + Results[2];
            System.out.println(label);
        }
    }

    protected void getSolutions() {
        double res;
        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();

        algorithm.setFunction(givenExample);
        algorithm.calculateIntegral();
        Results[0] = algorithm.getIntegral();
        Results[1] = givenExample.getExactIntegralValue(b)-givenExample.getExactIntegralValue(a);
        Results[2] = Math.abs(Results[0]-Results[1]);

        displaySolutions();
    }

    public void View() {
        while(true) {
            parseNumbers();
            getSolutions();
        }
    }

    public void Init(IntegralAlgorithm algorithm) {
        this.algorithm = algorithm;
        this.sc = new Scanner(System.in);
    }
}