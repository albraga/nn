
package backpropagation;


public class UpdateW {
    
    protected static double[] getW(Neuron n, double yd) {
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            w[i] += (0.1 * ((yd - n.getY()) * n.getX()[i]));
        }
        return w;
    }
    
    protected static double[] getOutputW(Neuron n, double yd) {
        double eg = n.getY() * (1 - n.getY()) * (yd - n.getY());
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            w[i] += (0.1 * (n.getX()[i] * eg));
        }
        return w;
    }
    
    protected static double[] getHiddenW(Neuron n, double yd) {
        double eg = n.getY() * (1 - n.getY()) * (yd - n.getY());
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            w[i] += (0.1 * (n.getX()[i] * eg));
        }
        return w;
    }
    
}
