package knearestneighbor;

public class KNN {

    public KNN() {
        Node[] eNodes = createENodes(EDATA);

    }

    private Node[] createENodes(String edata) {
        String[] ed = getMinAndMax(edata.split(" "));
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

    private String[] getMinAndMax(String[] ed) {
        int roomsMin = 1000000;
        int roomsMax = 0;
        int areaMin = 1000000;
        int areaMax = 0;
        int a = 1, r = 0;
        for (int i = 0; i < ed.length; i++) {
            if (Integer.parseInt(ed[a]) < areaMin) {
                areaMin = Integer.parseInt(ed[a]);
            }
            if (Integer.parseInt(ed[a]) > areaMax) {
                areaMax = Integer.parseInt(ed[a]);
            }

            if (Integer.parseInt(ed[r]) < roomsMin) {
                roomsMin = Integer.parseInt(ed[r]);
            }
            if (Integer.parseInt(ed[r]) > roomsMax) {
                roomsMax = Integer.parseInt(ed[r]);
            }
            if (r <= ed.length - 6) {
                r += 3;
            }
            if (a <= ed.length - 5) {
                a += 3;
            }
        }
        System.out.println(" a " + areaMin + " " + areaMax + " r " + roomsMin + " " + roomsMax);
        return ed;
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
