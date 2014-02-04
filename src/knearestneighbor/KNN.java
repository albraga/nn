package knearestneighbor;

public class KNN {

    public KNN() {
        Node[] eNodes = createTrainingNodes(trainingData);
        measureDistances(getMinAndMax(trainingData.split(" ")), eNodes);

    }
    
    private void determineUnknown(Node[] uNodes, Node[] nodes) {
        for (Node uNode : uNodes) {
            uNode.setNeighbors(nodes);
            //double distance = measureDistances
            //uNode.setDistance();
        }
    }

    private void measureDistances(int[][] minMax, Node[] nodes) {
        int areaMin = minMax[0][0];
        int areaMax = minMax[0][1];
        int roomsMin = minMax[1][0];
        int roomsMax = minMax[1][1];
        int roomsRange = roomsMax - roomsMin;
        int areaRange = areaMax - areaMin;
        for (Node node : nodes) {
            if (node.getNeighbors() != null) {
                for (Node neighbor : node.getNeighbors()) {
                    double deltaRooms = neighbor.getRooms() - node.getRooms();
                    deltaRooms = (deltaRooms / roomsRange);
                    double deltaArea = neighbor.getArea() - node.getArea();
                    deltaArea = (deltaArea/areaRange);
                    double distance = Math.sqrt((Math.pow(deltaRooms,2) + Math.pow(deltaArea,2)));
                    neighbor.setDistance(distance);
                }
            }
        }
    }

    private Node[] createTrainingNodes(String trainingData) {
        String[] ed = trainingData.split(" ");
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

    private int[][] getMinAndMax(String[] trainingDataArray) {
        int roomsMin = 1000000;
        int roomsMax = 0;
        int areaMin = 1000000;
        int areaMax = 0;
        int a = 1, r = 0;
        for (int i = 0; i < trainingDataArray.length; i++) {
            if (Integer.parseInt(trainingDataArray[a]) < areaMin) {
                areaMin = Integer.parseInt(trainingDataArray[a]);
            }
            if (Integer.parseInt(trainingDataArray[a]) > areaMax) {
                areaMax = Integer.parseInt(trainingDataArray[a]);
            }

            if (Integer.parseInt(trainingDataArray[r]) < roomsMin) {
                roomsMin = Integer.parseInt(trainingDataArray[r]);
            }
            if (Integer.parseInt(trainingDataArray[r]) > roomsMax) {
                roomsMax = Integer.parseInt(trainingDataArray[r]);
            }
            if (r <= trainingDataArray.length - 6) {
                r += 3;
            }
            if (a <= trainingDataArray.length - 5) {
                a += 3;
            }
        }
        return new int[][]{{areaMin, areaMax}, {roomsMin, roomsMax}};
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
