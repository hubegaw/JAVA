package matrix;

import java.util.ArrayList;
import java.util.List;

public class CreateThreads {
    public static void multiply(IMatrix a, IMatrix b, IMatrix res) {
        List<Thread> threads = new ArrayList<>();
        int availableThreads = Runtime.getRuntime().availableProcessors();
        int rows = a.rowCount();

        for(int i = 0; i < rows;i++) {
            MultiplyRows task = new MultiplyRows(res, a, b, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);

            if(threads.size() == availableThreads) {
                noThreadsAvailable(threads);
            }
        }
    }

    private static void noThreadsAvailable(List<Thread> threads) {
        for(Thread th : threads) {
            try {
                th.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
