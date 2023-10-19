package engine.model.physicalEngine.shape;

import engine.model.physicalEngine.movement.*;

public class Circle implements Shape {
    private Position center;
    private double radius;
    private boolean isMoving;

    public Circle(float x, float y, double radius) {
        setCenter(new Position(x, y));
        if (radius < 0)
            throw new IllegalArgumentException("Le rayon ne peut pas etre negatif");
        this.radius = radius;
        this.isMoving = false;
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
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    @Override
    public boolean isMoving() {
        return this.isMoving;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}
