
package backpropagation;

import java.io.Serializable;
import org.apache.commons.math3.analysis.function.Sigmoid;

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
        return new Sigmoid().value(net);
    }
    
    double getNet() {
        double n = 0.0;
        for (int i = 0; i < x.length; i++) {
            n += x[i] * w[i];
        }
        return n - th;
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
