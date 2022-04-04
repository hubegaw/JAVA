package integrals;

public class MetodaTrapezow extends IntegralAlgorithm {

    public MetodaTrapezow() {
        this.sum = 0;
    }

    @Override
    public void calculateIntegral() {
        double dx = (b-a)/n;

        for(int xi=0; xi < n; xi++) {
            sum += function.getValue(a + xi*dx);
        }
        sum = (sum + (function.getValue(a) - function.getValue(b))/2) * dx;
    }
}
