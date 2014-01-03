package backpropagation;

import java.util.Random;

public class Backpropagation {

    private final double[] x;
    private final double[] yd;
    private double error;
    private final int hsize;
    private Neuron[] hidden;
    private Neuron[] output;
    private final Random r;
    private final double a = 0.1;

    public Backpropagation(double[] x, double[] yd, int hsize) {
        this.x = x;
        this.yd = yd;
        this.hsize = hsize;
        r = new Random();
    }

    private double[] updateW(Neuron n) {
        double[] newW = new double[n.getW().length];
        double eg = getErrorGradient(n);
        for (int i = 0; i < n.getW().length; i++) {
            newW[i] = n.getW()[i] + a * n.getX()[i] * eg;
        }
        return newW;
    }
    
    private double getE(double[] y) {
        double e = 0.0;
        for (int i = 0; i < yd.length; i++) {
            e += yd[i] - y[i];
        } 
        return e;
    }


    private Neuron[] updateLayer(Neuron[] layer) {
        Neuron[] newLayer = new Neuron[layer.length];
        for (int i = 0; i < layer.length; i++) {
            Neuron n = layer[i];
            newLayer[i] = new Neuron(n.getX(), updateW(n), n.getTh());
        }
        return newLayer;
    }

    private double getErrorGradient(Neuron n) {
        return (n.getY() / n.getNet()) * error;
    }
    
    public double[] getY() {
        return learn(getInitialY());
    }

    private double[] learn(double[] y) {
        double res = 0.0;
        error = getE(y);
        for (int i = 0; i < yd.length; i++) {
            res += (y[i] * 100) /yd[i];
            System.out.println(res);
        }
        if ((res / yd.length) > 90) {
            return y;
        } else {
            Neuron[] newOutput = updateLayer(output);
            Neuron[] newHidden = updateLayer(hidden);
            double[] yNewHidden = new double[newHidden.length];
            for (int i = 0; i < newHidden.length; i++) {
                yNewHidden[i] = newHidden[i].getY();
            }
            double[] finalY = new double[newOutput.length];
            for (int i = 0; i < newOutput.length; i++) {
                finalY[i] = new Neuron(yNewHidden, newOutput[i].getW(), newOutput[i].getTh()).getY();
            }
            return learn(finalY);
        }
    }

    private double[] getInitialY() {
        hidden = new Neuron[hsize];
        for (int i = 0; i < hsize; i++) {
            hidden[i] = new Neuron(x, initW(x), initTh());
        }
        double[] xoutput = new double[hidden.length];
        for (int i = 0; i < hidden.length; i++) {
            xoutput[i] = hidden[i].getY();
        }
        output = new Neuron[yd.length];
        for (int i = 0; i < yd.length; i++) {
            output[i] = new Neuron(xoutput, initW(xoutput), initTh());
        }
        double[] initialY = new double[yd.length];
        for (int i = 0; i < yd.length; i++) {
            initialY[i] = output[i].getY();
        }
        return initialY;
    }

    private double[] initW(double[] xtemp) {
        double[] wt = new double[xtemp.length];
        for (int i = 0; i < xtemp.length; i++) {
            wt[i] = i % 2 == 0 ? r.nextGaussian() : r.nextDouble();
        }
        return wt;
    }

    private double initTh() {
        return r.nextGaussian();
    }
}
