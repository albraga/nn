package perceptron;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeN {

    public static Neuron get(String name) {
        Neuron n = null;
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            n = (Neuron) ois.readObject();
            ois.close();
            fis.close();
            return n;
        } catch (IOException | ClassNotFoundException ce) {
            return n;
        }
    }

}
