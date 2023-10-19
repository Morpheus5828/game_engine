package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class Rectangle implements Shape {
    private Position center;
    private float length;
    private float width;
    private boolean isMoving;
    private Velocity Velocity;

    public Rectangle(float x, float y, float length, float width) {
        setCenter(new Position(x, y));
        this.width = width;
        this.length = length;
        this.isMoving = false;
    }

    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() - this.width / 2));
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() + this.width / 2));
        apex.add(new Position(this.center.getX() + length / 2, this.center.getY() - this.width / 2));
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() + this.width / 2));
        return apex;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWidth() {
        return this.width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getLength() {
        return this.length;
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
    public boolean isMoving() {
        return isMoving;
    }

    @Override
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
}
