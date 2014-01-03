package backpropagation;

public class Main {

    public static void main(String[] args) {
        double[] x = {1.0, 1.0, 1.0};
        double[] yd = {1};
        int hsize = 2;
        Backpropagation b = new Backpropagation(x, yd, hsize);
        b.learn();
        
    }

    private void test() {
        double yd = 0;

        Neuron n = new Neuron(new double[]{1.0, 1.0}, InitWT.getW(2), InitWT.getTh());

        Neuron n2 = new Neuron(new double[]{1.0, 1.0}, InitWT.getW(2), InitWT.getTh());

        Neuron n3 = new Neuron(new double[]{n.getY(), n2.getY()}, InitWT.getW(2), InitWT.getTh());
        System.out.println(n3.getY());

        Neuron n3u = new Neuron(n3.getX(), UpdateW.getOutputW(n3, yd), n3.getTh());
        System.out.println(n3u.getY());

        Neuron nu = new Neuron(n.getX(), UpdateW.getHiddenW(n), n.getTh());
        Neuron n2u = new Neuron(n2.getX(), UpdateW.getHiddenW(n2), n2.getTh());

        Neuron n3uu = new Neuron(new double[]{nu.getY(), n2u.getY()}, UpdateW.getOutputW(n3u, yd), n3u.getTh());
        System.out.println(n3uu.getY());
    }

}
