
package backpropagation;


public class UpdateW {
    
    private static double sumEgDotW;
    
    protected static double[] getOutputW(Neuron n, double yd) {
        double eg = n.getY() * (1 - n.getY()) * (yd - n.getY());
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            w[i] += (0.1 * (n.getX()[i] * eg));
            sumEgDotW += n.getW()[i] * eg;
        }
        return w;
    }
    
    protected static double[] getHiddenW(Neuron n) {
        double eg = n.getY() * (1 - n.getY()) * sumEgDotW;
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            w[i] += (0.1 * (n.getX()[i] * eg));
        }
        return w;
    }
    
}
