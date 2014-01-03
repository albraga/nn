package backpropagation;

public class Backpropagation {

    private final double[] x;
    private final double[] yd;
    private final int hsize;
    private Neuron[] hidden;
    private Neuron[] output;

    public Backpropagation(double[] x, double[] yd, int hsize) {
        this.x = x;
        this.yd = yd;
        this.hsize = hsize;
        hidden = new Neuron[hsize];
        output = new Neuron[yd.length];
        initY();
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
    
    public void learn() {
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

        double res = 0.0;
        for (int i = 0; i < yd.length; i++) {
            res += (oy[i] * 100) / yd[i];
        }
        while ((res / yd.length) < 70) {
            learn();
        } 
        System.out.println(oy[0]);
        
    }


}
