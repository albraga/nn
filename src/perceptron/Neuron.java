
package perceptron;

import java.io.Serializable;

class Neuron implements Serializable {
    
    private int[] x;
    private double[] w;
    private double th;

    Neuron(int[] x, double[] w, double th) {
        this.x = x;
        this.w = w;
        this.th = th;
    }
    
    public int getY() {
        return activate(getNet());
    }
    
    private int activate(double net) {      
        return net > th ? 1 : 0;
    }
    
    double getNet() {
        double n = 0.0;
        for (int i = 0; i < x.length; i++) {
            n += x[i] * w[i];
        }
        return n;
    }

    int[] getX() {
        return x;
    }

    public void setX(int[] x) {
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
