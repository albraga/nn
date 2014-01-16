
package perceptron;

class UpdateW {
    
    private static final double alpha = 0.1;
    
    static double[] getW(Neuron n, double yd) {
        double e = (yd - n.getY());
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            w[i] += ((alpha * e) * n.getX()[i]);
        }
        return w;
    }

    
}
