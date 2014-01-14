
package perceptron;

import java.io.Serializable;

class Neuron implements Serializable {
    
    private double[] x;
    private double[] w;
    private double th;

    Neuron(double[] x, double[] w, double th) {
        this.x = x;
        this.w = w;
        this.th = th;
    }
    
    double getY() {
        return activate(getNet());
    }
    
    private double activate(double net) {
        return (1 / (1 + Math.exp(-net + th)));
    }
    
    double getNet() {
        double n = 0.0;
        for (int i = 0; i < x.length; i++) {
            n += x[i] * w[i];
        }
        return n;
    }

    double[] getX() {
        return x;
    }

    void setX(double[] x) {
        this.x = x;
    }

    double[] getW() {
        return w;
    }

    void setW(double[] w) {
        this.w = w;
    }

    double getTh() {
        return th;
    }

    void setTh(double th) {
        this.th = th;
    }
    
    
}
