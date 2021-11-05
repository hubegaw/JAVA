abstract class TwoDShape {
    private double width;
    private double height;
    private String name;

    TwoDShape() { // konstruktor domyślny
        width = height = 0.0;
        name = "none";
    }

    TwoDShape(double w, double h, String n) { // konstruktor z parametrami
        width = w;
        height = h;
        name = n;
    }

    TwoDShape(double x, String n) {
        width = height = x;
        name = n;
    }

    TwoDShape(TwoDShape Object) {
        width = Object.width;
        height = Object.height;
        name = Object.name;
    }

    double getWidth() { return width;}
    double getHeight() { return height;}
    void setWidth(double w) { width = w;}
    void setHeight(double h) { height = h;}
    String getName() { return name;}

    void showDim() {
        System.out.println("Szerokość i wysokość: " + width + " i " + height);
    }

    abstract double area(); // area musi zostać zdefiniowane w klasach pochodnych tej klasy
}

class Circle extends TwoDShape {


    Circle() {
        super();
    }
    Circle(double r) {
        super(r, "circle");
    }

    Circle(Circle Object) {
        super(Object);
    }

    double area() {
        return 3.1416 * (getWidth()/2) * (getWidth()/2);
    }

    void showRadius() {
        System.out.println("Koło ma promień o długości " + radius + " cm.");
    }
}

public class AbsShape {
    public static void main(String[] args) {

    }
}
