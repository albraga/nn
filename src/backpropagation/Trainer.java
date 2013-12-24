
package backpropagation;

public class Trainer {
    
    private final double[] x;
    private final int yd;
    private double y;
    private double e;
    private final double[] w;
    private final double th;
    private final double a;

    public Trainer(double[] x, int yd, double th, double a, double[] w) {
        this.x = x;
        this.yd = yd;
        this.w = w;
        this.th = th;
        this.a = a;
    }
    
    public double getY() {
        y = activate(getNet());
        e = yd - y;
        if (e == 0) {
            return y;
        } else {
            return new Trainer(x, yd, th, a, updateW()).getY();
        }
    }
    
    private double errorGradient() {
        return y * (1 - y) * e;
    }
    
    private double activate(double net) {
        return (1 / 1 + Math.exp(-net));
    }
    
    private double getNet() {
        double n = 0.0;
        for (int i = 0; i < x.length; i++) {
            n += x[i] * w[i];
        }
        return n - th;
    }

    private double[] updateW() {
        for (int i = 0; i < w.length; i++) {
            w[i] += a * y * errorGradient();
        }
        return w;
    }
    
}
