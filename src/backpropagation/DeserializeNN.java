package backpropagation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeNN {

    public static NN get(String name) {
        NN nn = null;
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            nn = (NN) ois.readObject();
            ois.close();
            fis.close();
            return nn;
        } catch (IOException | ClassNotFoundException ce) {
            return nn;
        }
    }

}
