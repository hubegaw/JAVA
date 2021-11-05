class Vehicle {
    int passengers;
    int fuelcap;
    double lkm;

    Vehicle(int p, int f, double l) { // konstruktor zamiast inicjalizacji tych argumentów w main()
        passengers = p;
        fuelcap = f;
        lkm = l;
    }

    int range() {
        return (int) (fuelcap / lkm * 100);
    }

    double fuelneeded(int km) {
        return (double) km / 100 * lkm;
    }
}

public class Example {
    public static void main(String[] args) {
        Vehicle minivan = new Vehicle(7, 65, 9.1);
        int range, dist = 252;
        double liters;

        range = minivan.range();
        liters = minivan.fuelneeded(dist);
        System.out.println("minivan has " + minivan.passengers + " passenger seats and range up to " + range + " kilometers.");
        System.out.println("minivan needs " + liters + " liters of fuel to travel " + dist + " kilometers");


        double tablica[] = new double[10];

        double i = 1, sum = 0;
        for(double x : tablica) {
            x = i;
            i += 0.25;
            sum += x;
            System.out.print(x + " ");
        }

        System.out.print("\nsum = " + sum/10);
    }
}
