package engine.model.physicalEngine.environment;

import java.util.ArrayList;

public class Map {
    //private List<Entity> entityList = new ArrayList<>()  on attend de merge avec la branch Entity
    private double length;
    private double height;

    public Map(double length, double height) {
        this.length = length;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
