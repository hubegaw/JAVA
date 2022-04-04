package pl.retsuz;

import integrals.IntegralAlgorithm;
import integrals.MetodaTrapezow;
import integrals.MonteCarlo;
import view.AppInterfaceConsole;

public class Main {
    protected static IntegralAlgorithm algorithm;
    static AppInterfaceConsole view;

    public static void main(String[] args) {
        view = new AppInterfaceConsole();

        algorithm = new MonteCarlo();
        view.Init(algorithm);
        view.View();

        algorithm = new MetodaTrapezow();
        view.Init(algorithm);
        view.View();
    }
}
