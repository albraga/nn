package backpropagation;

import java.io.Serializable;

public class NN implements Serializable {

    private final Neuron[] hidden;
    private final Neuron[] output;

    NN(Neuron[] hidden, Neuron[] output) {
        this.hidden = hidden;
        this.output = output;
    }

    public double[] getY(boolean real, double[] x) {
        Neuron[] hiddenN = new Neuron[hidden.length];
        double[] hy = new double[hidden.length];
        for (int i = 0; i < hidden.length; i++) {
            hiddenN[i] = new Neuron(x, hidden[i].getW(), hidden[i].getTh());
            hy[i] = hiddenN[i].getY();
        }
        Neuron[] outputN = new Neuron[output.length];
        double[] oy = new double[output.length];
        for (int i = 0; i < output.length; i++) {
            outputN[i] = new Neuron(hy, output[i].getW(), output[i].getTh());
            oy[i] = outputN[i].getY();
        }
        return real ? oy : convert(oy);
    }

    private double[] convert(double[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = (tmp[i] > 0.8) ? 1 : 0;
        }
        return tmp;
    }

}
