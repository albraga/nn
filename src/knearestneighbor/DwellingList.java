package knearestneighbor;

import java.util.ArrayList;
import java.util.List;

public class DwellingList {
    
    private int k;
    private List<Dwelling> dwellings = new ArrayList<>();
    private int areaMin, areaMax, roomsMin, roomsMax;
    
    public DwellingList(int k) {
        this.k = k;
        //Dwelling[] eNodes = createTrainingNodes(trainingData);
        //measureDistances(getMinAndMax(trainingData.split(" ")), eNodes);
    }

    private void determineUnknown() {
        calculateRanges();
        for (Dwelling uNode : dwellings) {
            if(uNode.getType() == null) {
                for (Dwelling jNode : dwellings) {
                    if(jNode.getType() != null) {
                        uNode.getNeighbors().add(jNode);
                    }
                }
                uNode.measureDistances(areaMin, areaMax, roomsMin, roomsMax);
            }
        }
    }

    

    private Dwelling[] createNodes(String trainingData) {
        String[] ed = trainingData.split(" ");
        Dwelling[] nodes = new Dwelling[(ed.length / 3)];
        int t = 2, a = 1, r = 0;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Dwelling(Type.get(ed[t]), Integer.parseInt(ed[a]), Integer.parseInt(ed[r]));
            t += 3;
            a += 3;
            r += 3;
        }
        return nodes;
    }

    private void calculateRanges() {
        roomsMin = 1000000;
        roomsMax = 0;
        areaMin = 1000000;
        areaMax = 0;
        int a = 1, r = 0;
        for (int i = 0; i < dwellings.size(); i++) {
            if (dwellings.get(a).getArea() < areaMin) {
                areaMin = dwellings.get(a).getArea();
            }
            if (dwellings.get(a).getArea() > areaMax) {
                areaMax = dwellings.get(a).getArea();
            }

            if (dwellings.get(r).getRooms() < roomsMin) {
                roomsMin = dwellings.get(r).getRooms();
            }
            if (dwellings.get(r).getRooms() > roomsMax) {
                roomsMax = dwellings.get(r).getRooms();
            }
            if (r <= dwellings.size() - 6) {
                r += 3;
            }
            if (a <= dwellings.size() - 5) {
                a += 3;
            }
        }
    }

    private final String trainingData = "1 350 apartment "
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
