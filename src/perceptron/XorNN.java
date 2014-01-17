package perceptron;

public class XorNN {
    
    public XorNN(int[] x) {
        int[][] xx = {{0,0},{0,1},{1,0},{1,1}};
        int[] yydAND = {0,0,0,1};
        int[] yydOR = {0,1,1,1};
      
        Neuron andN = new Perceptron(xx, yydAND).getN();
        Neuron orN = new Perceptron(xx, yydOR).getN();
        Neuron orN2 = new Neuron(orN.getX(), orN.getW(), orN.getTh());
        
        andN.setX(x);
        int andV = andN.getY() == 1 ? 0 : 1;
        orN.setX(x);
        int orV = orN.getY();
        
        orN2.setX(new int[]{andV, orV});
        System.out.println(orN2.getY());
    }
}
