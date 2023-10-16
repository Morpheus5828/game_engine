package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.shape.temp.Position;

public class Rectangle implements Shape {
    private int sides;
    private double corner;
    protected Position center;
    private double length;
    private double height;


    public Rectangle(double x, double y, double length, double height) {
        setCenter(new Position(x, y));
        this.sides = 4;
        this.corner = 2 * Math.PI / sides;
        this.height = height;
        this.length = length;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        for (int i = 0; i < sides; i++) {
            
        }
        return apex;
    }


    @Override
    public void setCenter(Position point) {
        this.center = point;
    }

    @Override
    public Position getCenter() {
        return this.center;
    }
}
