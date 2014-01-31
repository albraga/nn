package knearestneighbor;

public class Node {
    
    public enum Type {APARTMENT, HOUSE, FLAT};
    private Type type;
    private double area;
    private int rooms;
    
    public Node(Type type, double area, int rooms) {
        this.type = type;
        this.area = area;
        this.rooms = rooms;
    }
    
    public Node(double area, int rooms) {
        this.area = area;
        this.rooms = rooms;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    
    
}
