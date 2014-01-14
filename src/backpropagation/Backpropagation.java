//Artificial Intelligence A Guide to Intelligent Systems
package backpropagation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Backpropagation {

    private NN nn;
    private static double sse;
    private static int ct = 0;

    public Backpropagation(double[][] x, double[][] yd) {
        initY(x[0], yd[0]);
        for (int i = 0; i < x.length; i++) {
            learn(x[i], yd[i]);
        }
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

    private void initY(double[] xI, double[] ydI) {
        Neuron[] hiddenI = new Neuron[2 * ydI.length];
        Neuron[] outputI = new Neuron[ydI.length];
        double[] hy = new double[hiddenI.length];
        for (int i = 0; i < hiddenI.length; i++) {
            hiddenI[i] = new Neuron(xI, InitWTh.getW(xI.length), InitWTh.getTh());
            hy[i] = hiddenI[i].getY();
        }
        for (int i = 0; i < outputI.length; i++) {
            outputI[i] = new Neuron(hy, InitWTh.getW(hy.length), InitWTh.getTh());
            outputI[i].setW(UpdateWTh.getOutputW(outputI[i], ydI[i]));
            outputI[i].setTh(UpdateWTh.outputTh);
        }
        nn = new NN(hiddenI, outputI);
    }

    private void learn(double[] xL, double[] ydL) {
        Neuron[] hiddenL = nn.getHidden();
        for (int i = 0; i <hiddenL.length; i++) {
            hiddenL[i].setX(xL);
        }
        Neuron[] outputL = nn.getOutput();
        double[] hy = new double[hiddenL.length];
        for (int i = 0; i < hiddenL.length; i++) {
            hiddenL[i].setW(UpdateWTh.getHiddenW(hiddenL[i]));
            hiddenL[i].setTh(UpdateWTh.hiddenTh);
            hy[i] = hiddenL[i].getY();
        }
        double[] oy = new double[ydL.length];
        for (int i = 0; i < ydL.length; i++) {
            outputL[i] = new Neuron(hy, UpdateWTh.getOutputW(outputL[i], ydL[i]), UpdateWTh.outputTh);
            oy[i] = outputL[i].getY();
        }
        nn.setHidden(hiddenL);
        nn.setOutput(outputL);
        sse = sumSquaredErrors(ydL, oy);
        System.out.println(ct++);
        try {
            while (sse > 0.001) {
                learn(xL, ydL);
            }
        } catch (StackOverflowError e) {

        }
    }

    private double sumSquaredErrors(double[] ydL, double[] yy) {
        double s = 0;
        for (int i = 0; i < yy.length; i++) {
            s += Math.pow((ydL[i] - yy[i]), 2);
        }
        return s;
    }
}
