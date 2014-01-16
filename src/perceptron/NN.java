package perceptron;

import java.io.Serializable;

public class NN implements Serializable {

    Neuron[] output;

    NN(Neuron[] output) {
        this.output = output;
    }

    public double[] getY(boolean real, int[] x) {
        Neuron[] outputN = new Neuron[output.length];
        double[] oy = new double[output.length];
        for (int i = 0; i < output.length; i++) {
            outputN[i] = new Neuron(x, output[i].getW(), output[i].getTh());
            oy[i] = outputN[i].getY();
        }
        return real ? oy : convert(oy);
    }

    private double[] convert(double[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = (tmp[i] > 0.99) ? 1 : 0;
        }
        return tmp;
    }

    Neuron[] getOutput() {
        return output;
    }

    void setOutput(Neuron[] output) {
        this.output = output;
    }
    
    

}
