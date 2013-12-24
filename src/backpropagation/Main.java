package backpropagation;
public class Main {

    public static void main(String[] args) {

//        double[] xn1n2 = {1.0, 1.0};
//        double yd = 0.0;
//        
//        double[] wn1 = {0.5, 0.4};
//        double[] wn2 = {0.9, 1.0};
//        
//        double thn1 = 0.8;
//        double thn2 = -0.1;
//        
//        Neuron n1 = new Neuron(xn1n2, wn1, thn1);
//        Neuron n2 = new Neuron(xn1n2, wn2, thn2);
//        
//        double yn1 = n1.getY();
//        double yn2 = n2.getY();
//        
//        double[] xn3 = {yn1, yn2};
//        double[] wn3 = {-1.2, 1.1};
//        double thn3 = 0.3;
//        Neuron n3 = new Neuron(xn3, wn3, thn3);
//       
//        double y = n3.getY();
//        double e = yd - y;
//        
//        double egn3 = y * (1 - y) * e;
//        
//        double a = 0.1;
//        
//        double[] wn3up = wn3.clone();
//        for (int i = 0; i < wn3.length; i++) {
//            wn3up[i] += a * xn3[i] * egn3;
//        }
//        thn3 = a * -1 * egn3;
//        
//        double egn1 = 0.0;
//        for (int i = 0; i < wn1.length; i++) {
//            egn1 += yn1 * (1 - yn1) * wn1[i];
//        }
//        
//        double[] wn1up = wn1.clone();
//        for (int i = 0; i < wn1.length; i++) {
//            wn1up[i] += a * xn1n2[i] * egn1;
//        }
//         
//        double egn2 = 0.0;
//        for (int i = 0; i < wn1.length; i++) {
//            egn2 += yn1 * (1 - yn1) * wn2[i];
//        }
//        
//        double[] wn2up = wn2.clone();
//        for (int i = 0; i < wn2.length; i++) {
//            wn2up[i] += a * xn1n2[i] * egn2;
//        }
        //double[] e = new Backpropagation(new double[]{0.0, 1.0},new double[]{1.0}, 2).getE();
        //System.out.println(e.length + ", " + e[0]);
    }


}
