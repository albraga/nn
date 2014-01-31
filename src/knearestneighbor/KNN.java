package knearestneighbor;

public class KNN {

    private Node[] createENodes(String edata) {
        Node[] nodes = new Node[(edata.length()/3)];
        String[] ed = edata.split(" ");
        for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(Type.get(ed[i]), Double.parseDouble(ed[i + 1]), Integer.parseInt(ed[i + 2]));
        }
        return nodes;
    }

    private final String EDATA = ""
            + "1 350 apartment"
            + "2 300 apartment"
            + "3 300 apartment"
            + "4 250 apartment"
            + "4 500 apartment"
            + "4 400 apartment"
            + "5 450apartment"
            + "7 850 house"
            + "7 900 house"
            + "7 1200 house"
            + "8 1500 house"
            + "9 1300 house"
            + "8 1240 house"
            + "10 1700 house"
            + "9 1000 house"
            + "1 800 flat"
            + "3 900 flat"
            + "2 700 flat"
            + "1 900 flat"
            + "2 1150 flat"
            + "1 1000 flat"
            + "2 1200 flat"
            + "1 1300 flat";
}