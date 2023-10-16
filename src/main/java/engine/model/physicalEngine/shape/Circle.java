package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.shape.temp.Position;

public class Circle implements Shape {
    protected Position center;
    protected double radius;

    public Circle(double x, double y, double radius) {
        setCenter(new Position(x, y));
        if (radius < 0) {
            throw new IllegalArgumentException("Le rayon ne peut pas etre negatif");
        }
        this.radius = radius;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
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
