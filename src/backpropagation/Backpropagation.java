package backpropagation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Backpropagation {

    private final double[] x;
    private final double[] yd;
    private final int hsize;
    private final Neuron[] hidden;
    private final Neuron[] output;
    private final double[] y;
    private NN nn;

    public Backpropagation(double[] x, double[] yd, int hsize) {
        this.x = x;
        this.yd = yd;
        this.hsize = hsize;
        hidden = new Neuron[hsize];
        output = new Neuron[yd.length];
        y = new double[yd.length];
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
            hidden[i] = new Neuron(x, InitWT.getW(x.length), InitWT.getTh());
            hy[i] = hidden[i].getY();
        }
        for (int i = 0; i < yd.length; i++) {
            output[i] = new Neuron(hy, InitWT.getW(hy.length), InitWT.getTh());
        }
    }

    private void learn() {
        for (int i = 0; i < yd.length; i++) {
            output[i].setW(UpdateW.getOutputW(output[i], yd[i]));
        }
        double[] hy = new double[hsize];
        for (int i = 0; i < hidden.length; i++) {
            hidden[i].setW(UpdateW.getHiddenW(hidden[i]));
            hy[i] = hidden[i].getY();
        }
        double[] oy = new double[yd.length];
        for (int i = 0; i < yd.length; i++) {
            output[i] = new Neuron(hy, UpdateW.getOutputW(output[i], yd[i]), output[i].getTh());
            oy[i] = output[i].getY();
        }

        for (int i = 0; i < yd.length; i++) {
            y[i] = (oy[i] > 0.8) ? 1 : 0;
        }
        nn = new NN(hidden, output);
        try {
        while (!Arrays.equals(yd, y)) {
            learn();
        }
        } catch(StackOverflowError e) {
            initY();
            learn();
        }
    }

}
