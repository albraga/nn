
package backpropagation;


class UpdateWTh {
    
    private static final double alpha = 0.5;
    private static final double momentum = 0.95;
    private static double sumEgDotW;
    static double outputTh;
    static double hiddenTh;
    
    static double[] getOutputW(Neuron n, double yd) {
        double eg = n.getY() * (1 - n.getY()) * (yd - n.getY());
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            //w[i] += (alpha * n.getX()[i] * eg) * momentum;
            w[i] *= (n.getX()[i] * eg) * momentum;//teste
            w[i] += alpha;//teste
            sumEgDotW += n.getW()[i] * eg;
        }
        outputTh = n.getTh() + (alpha * -eg);
        return w;
    }
    
    static double[] getHiddenW(Neuron n) {
        double eg = n.getY() * (1 - n.getY()) * sumEgDotW;
        double[] w = n.getW();
        for (int i = 0; i < n.getW().length; i++) {
            //w[i] += (alpha * n.getX()[i] * eg) * momentum;
            w[i] *= (n.getX()[i] * eg) * momentum;//teste
            w[i] += alpha;//teste
        }
        hiddenTh = n.getTh() + (alpha * -eg);
        return w;
    }
    
}
