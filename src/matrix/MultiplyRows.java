package matrix;

public class MultiplyRows implements Runnable {
    private final IMatrix res;
    private IMatrix a;
    private IMatrix b;
    private final int row;

    public MultiplyRows(IMatrix res, IMatrix a, IMatrix b, int row) {
        this.res = res;
        this.a = a;
        this.b = b;
        this.row = row;
    }

    @Override
    public void run() {
        for(int i = 0; i < b.rowCount(); i++) {
            res.getData()[row][i] = 0;
            for(int j =0; j < a.getData()[row].length; j++) {
                res.getData()[row][i] += a.getData()[row][j] * b.getData()[j][i];
            }
        }
    }
}
