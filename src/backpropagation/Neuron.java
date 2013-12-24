
package backpropagation;

import org.apache.commons.math3.analysis.function.Sigmoid;

public class Neuron {
    
    private double[] x;
    private double[] w;
    private double th;

    public Neuron(double[] x, double[] w, double th) {
        this.x = x;
        this.w = w;
        this.th = th;
    }
    
    public double getY() {
        return activate(getNet());
    }
    
    private double activate(double net) {
        return new Sigmoid().value(net);
    }
    
    private double getNet() {
        double n = 0.0;
        for (int i = 0; i < x.length; i++) {
            n += x[i] * w[i];
        }
        return n - th;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getW() {
        return w;
    }

    public void setW(double[] w) {
        this.w = w;
    }

    public double getTh() {
        return th;
    }

    public void setTh(double th) {
        this.th = th;
    }
    
    
}
