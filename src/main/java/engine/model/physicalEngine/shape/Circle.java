package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.shape.temp.Position;

public class Circle implements Shape {
    private Position center;
    private double radius;
    private boolean isMoving;

    public Circle(double x, double y, double radius) {
        setCenter(new Position(x, y));
        if (radius < 0) {
            throw new IllegalArgumentException("Le rayon ne peut pas etre negatif");
        }
        this.radius = radius;
        this.isMoving=false;
    }

    @Override
    public void setCenter(Position point) {
        this.center = point;
    }

    @Override
    public Position getCenter() {
        return this.center;
    }

    @Override
    public void setIsMoving(boolean isMoving){this.isMoving=isMoving;}

    @Override
    public boolean isMoving(){return this.isMoving;}

    public double getRadius(){return this.radius;}
}
