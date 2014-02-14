package knearestneighbor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dwelling implements Comparable<Dwelling> {
    
    private Type type;
    private int area;
    private int rooms;
    private double distance;
    private List<Dwelling> neighbors = new ArrayList<>();
    
    public Dwelling(Type type, int area, int rooms) {
        this.type = type;
        this.area = area;
        this.rooms = rooms;
    }
    
    public Dwelling(int area, int rooms) {
        this.area = area;
        this.rooms = rooms;
    }
    
    void sortByDistance() {
        Collections.sort(neighbors);
    }
    
    void measureDistances(int areaMin, int areaMax, int roomsMin, int roomsMax) {
        int roomsRange = roomsMax - roomsMin;
        int areaRange = areaMax - areaMin;
        for (Dwelling neighbor : neighbors) {
            double deltaRooms = neighbor.getRooms() - this.getRooms();
            deltaRooms = (deltaRooms / roomsRange);
            double deltaArea = neighbor.getArea() - this.getArea();
            deltaArea = (deltaArea / areaRange);
            double dstnc = Math.sqrt((Math.pow(deltaRooms, 2) + Math.pow(deltaArea, 2)));
            neighbor.setDistance(dstnc);
        }
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

    public List<Dwelling> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Dwelling> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public int compareTo(Dwelling compareDwelling) {
        double compareDistance = ((Dwelling) compareDwelling).getDistance();
        if (this.distance > compareDistance) return 1;
        if (this.distance < compareDistance) return -1;
        return 0;
    }

    
    
}
