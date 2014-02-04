package knearestneighbor;

public class Node {
    
    private Type type;
    private int area;
    private int rooms;
    private Node[] neighbors;
    private double distance;
    
    public Node(Type type, int area, int rooms) {
        this.type = type;
        this.area = area;
        this.rooms = rooms;
    }
    
    public Node(int area, int rooms) {
        this.area = area;
        this.rooms = rooms;
    }
    

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Node[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Node[] neighbors) {
        this.neighbors = neighbors;
    }
    
}
