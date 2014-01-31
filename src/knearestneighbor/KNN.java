package knearestneighbor;

public class KNN {

    public KNN() {
        Node[] eNodes = createENodes(EDATA);
        for (Node n : eNodes) {
            System.out.println(n.getType() + " Area: " + n.getArea() + " Rooms: " + n.getRooms());
        }
    }

    private Node[] createENodes(String edata) {
        String[] ed = edata.split(" ");
        Node[] nodes = new Node[(ed.length / 3)];
        int t = 2, a = 1, r = 0;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(Type.get(ed[t]), Integer.parseInt(ed[a]), Integer.parseInt(ed[r]));
        t += 3;
        a += 3;
        r += 3;
        }
        return nodes;
    }

    private final String EDATA = "1 350 apartment "
            + "2 300 apartment "
            + "3 300 apartment "
            + "4 250 apartment "
            + "4 500 apartment "
            + "4 400 apartment "
            + "5 450 apartment "
            + "7 850 house "
            + "7 900 house "
            + "7 1200 house "
            + "8 1500 house "
            + "9 1300 house "
            + "8 1240 house "
            + "10 1700 house "
            + "9 1000 house "
            + "1 800 flat "
            + "3 900 flat "
            + "2 700 flat "
            + "1 900 flat "
            + "2 1150 flat "
            + "1 1000 flat "
            + "2 1200 flat "
            + "1 1300 flat";
}
