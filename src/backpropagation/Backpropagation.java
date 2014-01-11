package backpropagation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Backpropagation {

    private final double[] x;
    private final double[] yd;
    private final int hsize;
    private final Neuron[] hidden;
    private final Neuron[] output;
    private NN nn;
    private static double sse;
    private static int ct = 0;

    public Backpropagation(double[] x, double[] yd, int hsize) {
        this.x = x;
        this.yd = yd;
        this.hsize = hsize;
        hidden = new Neuron[hsize];
        output = new Neuron[yd.length];
        initY();
        learn();
    }

    public NN getNN() {
        return nn;
    }

    public void saveNN(String name) {
        try {
            FileOutputStream fos = new FileOutputStream(name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(nn);
            oos.close();
            fos.close();
        } catch (IOException ex) {
        }
    }

    private void initY() {
        double[] hy = new double[hsize];
        for (int i = 0; i < hsize; i++) {
            hidden[i] = new Neuron(x, InitWTh.getW(x.length), InitWTh.getTh());
            hy[i] = hidden[i].getY();
        }
        for (int i = 0; i < yd.length; i++) {
            output[i] = new Neuron(hy, InitWTh.getW(hy.length), InitWTh.getTh());
        }
        for (int i = 0; i < yd.length; i++) {
            output[i].setW(UpdateWTh.getOutputW(output[i], yd[i]));
            output[i].setTh(UpdateWTh.outputTh);
        }
    }

    private void learn() {
        
        double[] hy = new double[hsize];
        for (int i = 0; i < hidden.length; i++) {
            hidden[i].setW(UpdateWTh.getHiddenW(hidden[i]));
            hidden[i].setTh(UpdateWTh.hiddenTh);
            hy[i] = hidden[i].getY();
        }
        double[] oy = new double[yd.length];
        for (int i = 0; i < yd.length; i++) {
            output[i] = new Neuron(hy, UpdateWTh.getOutputW(output[i], yd[i]), UpdateWTh.outputTh);
            oy[i] = output[i].getY();
        }
        nn = new NN(hidden, output);
        sse = sumSquaredErrors(oy);
        System.out.println(ct++);
        try {
            while (sse > 0.001) {
                learn();
            }
        } catch (StackOverflowError e) {

        }
    }

    private double sumSquaredErrors(double[] yy) {
        double s = 0;
        for (int i = 0; i < yy.length; i++) {
            s += Math.pow((yd[i] - yy[i]), 2);
        }
        return s;
    }
}
