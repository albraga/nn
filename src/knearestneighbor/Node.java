package knearestneighbor;

public class Node {
    
    private Type type;
    private int area;
    private int rooms;
    
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
    
    
}
