package pl.retsuz.view;

import pl.retsuz.collections.IDataCollection;
import pl.retsuz.currency.ICurrency;
import pl.retsuz.exchange.IExchange;

import java.util.Scanner;

public class StandardView implements ICurrencyView {
    private Scanner sc;
    private IDataCollection dataCollection;
    private IExchange exc;

    public StandardView() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void setExchange(IExchange exchange) {
        this.exc = exchange;
    }

    @Override
    public void setDataCollection(IDataCollection collection) {
        this.dataCollection = collection;
    }

    @Override
    public void ViewAll(IDataCollection coll) {
        System.out.println(dataCollection.ToString());
    }

    @Override
    public ICurrency StringToCurrency(String code) {
        for(ICurrency c : dataCollection.getCurrencyList()) {
            if(c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public ICurrency ChooseCurrency(String label) {
        String choice;
        ICurrency chosenCurr;

        System.out.println(label);
        choice = sc.nextLine();
        chosenCurr = StringToCurrency(choice);

        if(chosenCurr==null) {
            System.err.println("\nPodano zły kod waluty.");
            exchange();
        }

        return chosenCurr;
    }

    @Override
    public void exchange() {
        ICurrency srcCurr, tgtCurr;
        double amt = 0.0, exchangedAmt = 0.0;
        boolean exchangeProcess = true;

        while(exchangeProcess) {
            srcCurr = ChooseCurrency("\nPodaj kod waluty, którą wymieniasz:");
            tgtCurr = ChooseCurrency("\nPodaj kod waluty, na którą wymieniasz:");

            System.out.println("\nPodaj kwotę, jaką chcesz wymienić:");
            amt = Double.parseDouble(sc.nextLine());

            if (amt < 0.0) {
                System.out.println("\nPodana wartość nie może być ujemna!");
            } else {
                exchangedAmt = exc.exchange(srcCurr,tgtCurr,amt);
                System.out.println(amt + srcCurr.getCode() + " = " + exchangedAmt + " " + tgtCurr.getCode() + "\n");
                exchangeProcess = false;
            }
        }
    }

    @Override
    public void menu() {
        String choice;
        boolean programWork = true;

        while(programWork) {
            System.out.println("\tMenu");
            System.out.println("1. aby wyświetlić waluty\n");
            System.out.println("2. aby wymienić waluty\n");
            System.out.println("3. aby zamknąć program\n");

            choice = sc.nextLine();

            switch (choice) {
                case "1" -> ViewAll(dataCollection);
                case "2" -> exchange();
                case "3" -> programWork = false;
                default -> System.out.println("Błędny wybór!\n");
            }
        }
    }
}
