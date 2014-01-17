package perceptron;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Perceptron {

    private Neuron nP;
    private static int e;

    public Perceptron(int[][] xx, int[] yyd) {
        int[][] xxn = updateXX(xx);
        train(xxn, yyd);
    }

    private void train(int[][] xxn, int[] yyd) {
        Neuron nT = learn(initN(xxn[0]), xxn[0], yyd[0]);
        Neuron nF = null;
        for (int i = 1; i < xxn.length; i++) {
            nF = learn(nT, xxn[i], yyd[i]);
        }
        test(nF, xxn, yyd);
    }

    private void test(Neuron nTest, int[][] xxn, int[] yyd) {
        for (int i = 0; i < xxn.length; i++) {
            nTest.setXU(xxn[i]);
            e += Math.pow((yyd[i] - nTest.getY()), 2);
        }
        if (e > 0) {
            train(xxn, yyd);
        }
        nP = nTest;
    }

    private int[][] updateXX(int[][] xx) {
        int[][] xxU = new int[xx.length][xx[0].length + 1];
        for (int i = 0; i < xx.length; i++) {
            xxU[i] = Arrays.copyOf(xx[i], xx[i].length + 1);
            xxU[i][xx[i].length] = 1;
        }
        return xxU;
    }

    private Neuron learn(Neuron nL, int[] xL, int ydL) {
        int eL = getE(ydL, nL.getY());
        while (eL != 0) {
            nL = new Neuron(xL, UpdateW.getW(nL, ydL), nL.getTh());
            eL = getE(ydL, nL.getY());
        }
        return nL;
    }

    private int getE(int ydd, int yy) {
        return (ydd - yy);
    }

    public void saveNN(String name) {
        try {
            FileOutputStream fos = new FileOutputStream(name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(nP);
            oos.close();
            fos.close();
        } catch (IOException ex) {
        }
    }

    private Neuron initN(int[] x) {
        return new Neuron(x, InitWTh.getW(x.length), InitWTh.getTh());
    }
}
