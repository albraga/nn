package backpropagation;

import java.util.Random;

public class InitWT {
    
    private static final Random r = new Random();

    protected static double[] getW(int size) {
        double[] wt = new double[size];
        for (int i = 0; i < size; i++) {
            wt[i] = i % 2 == 0 ? r.nextGaussian() : r.nextDouble();
        }
        return wt;
    }

    protected static double getTh() {
        return r.nextGaussian();
    }
}
