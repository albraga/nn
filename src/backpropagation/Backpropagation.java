package backpropagation;

import java.util.Random;

public class Backpropagation {
    
    private final double[] x;
    private final double[] yd;
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
    
    private double[] updateW(double[] neuronX, double[] neuronW, double neuronOutput) {
        double[] newW = neuronW.clone();
        double eg = getErrorGradient(neuronOutput, neuronW);
        for (int i = 0; i < neuronW.length; i++) {
            newW[i] += a * neuronX[i] * eg;
        }
        return newW;
    }
    
    private double getErrorGradient(double neuronOutput, double[] neuronW) {
        double eg = 0.0;
        for (int i = 0; i < neuronW.length; i++) {
            eg += neuronOutput * (1 - neuronOutput) * neuronW[i];
        }
        return eg;
    }
    
    public double[] getE() {
        return calcE(getInitialY());
    }   
    
    private double[] calcE(double[] ytemp) {
        double[] error = new double[ytemp.length];
        for (int i = 0; i < yd.length; i++) {
            error[i] = yd[i] - ytemp[i];
        }
        return error;
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
