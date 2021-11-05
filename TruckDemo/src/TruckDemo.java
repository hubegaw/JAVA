class Vehicle {
    private int passengers;
    private int fuelcap;
    private double lkm;

    Vehicle(int p, int f, double l) {
        this.passengers = p;
        this.fuelcap = f;
        this.lkm = l;
    }

    int range() {
        return (int)((double)this.fuelcap / this.lkm * 100.0D);
    }

    double fuelneeded(int km) {
        return (double)km / 100.0D * this.lkm;
    }
}

class Truck extends Vehicle {
    private int cargocap;

    Truck(int p, int f, double l, int c) {
        super(p, f, l);
        cargocap = c;
    }

    int getCargo() { return cargocap;}
    void putCargo(int c) { cargocap = c;}
}

class OffRoad extends Vehicle {
    private int groundClearance;

    OffRoad(int p, int f, int l, int g) {
        super(p, f, l);
        groundClearance = g;
    }

    int getGroundClearance() { return groundClearance;}
    void putGroundClearance(int g) { groundClearance = g;}
}

public class TruckDemo {
    public static void main(String[] args) {
        Truck semi = new Truck(2, 200, 25, 4);
        Truck pickup = new Truck(3, 80, 15, 1);
        double liters;
        int dist = 252;

        liters = semi.fuelneeded(dist);

        System.out.println("Półciężarówka przewozi "+ semi.getCargo()+ " tonę ładunku.");
        System.out.println("Aby pokonać dystans "+ dist + " kilometrów, półciężarówka potrzebuje " + liters + " litrów paliwa.\n");

        liters = pickup.fuelneeded(dist);

        System.out.println("Pickup przewozi "+ pickup.getCargo()+ " tonę ładunku.");
        System.out.println("Aby pokonać dystans "+ dist + " kilometrów, pickup potrzebuje " + liters + " litrów paliwa.");
    }
}
