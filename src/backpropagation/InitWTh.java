package backpropagation;

import java.util.Random;

class InitWTh {
    
    private static final Random r = new Random();

    static double[] getW(int size) {
        double[] wt = new double[size];
        for (int i = 0; i < size; i++) {
            wt[i] = i % 2 == 0 ? -r.nextDouble()/4 : r.nextDouble()/4;
        }
        return wt;
    }

    static double getTh() {
        return r.nextDouble()/4;
    }
}
