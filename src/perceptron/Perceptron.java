package perceptron;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Perceptron {

    private Neuron nP;

    public Perceptron(int[][] xx, int[] yyd) {
        int[][] xxn = updateXX(xx);
        train(xxn, yyd);
    }

    private void train(int[][] xxn, int[] yyd) {
        Neuron nT = null;
        Neuron nL = null;
        for (int i = 0; i < xxn.length; i++) {
            if (i == 0) {
                nT = learn(initN(xxn[i]), xxn[i], yyd[i]);
            }
            nL = learn(nT, xxn[i], yyd[i]);
        }
        test(nL, xxn, yyd);
    }

    private void test(Neuron nTest, int[][] xxn, int[] yyd) {
        for (int i = 0; i < xxn.length; i++) {
            nTest.setX(xxn[i]);
            if (yyd[i] != nTest.getY()) {
                train(xxn, yyd);
            }
        }
        nP = nTest;
    }

    private int[][] updateXX(int[][] xx) {
        int[][] xxn = new int[xx.length][xx[0].length + 1];
        for (int i = 0; i < xx.length; i++) {
            xxn[i] = Arrays.copyOf(xx[i], xx[i].length + 1);
            xxn[i][xx[i].length] = 1;
        }
        return xxn;
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
