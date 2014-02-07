package knearestneighbor;

public class Dwelling {
    
    private Type type;
    private int area;
    private int rooms;
    private double distance;
    
    public Dwelling(Type type, int area, int rooms) {
        this.type = type;
        this.area = area;
        this.rooms = rooms;
    }
    
    public Dwelling(int area, int rooms) {
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
    
}
