package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class Rectangle implements Shape {
    private Position center;
    private double length;
    private double width;
    private boolean moving;
    private boolean colliding;
    private Velocity velocity;
    private Position head;

    public Rectangle(Position center, double length, double width, Velocity velocity) {
        this.center = center;
        this.width = width;
        this.length = length;
        this.moving = false;
        this.colliding = true;
        this.velocity = velocity;
        this.head = new Position(this.center.getX() + length / 2, this.center.getY());
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() - this.width / 2));
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() + this.width / 2));
        apex.add(new Position(this.center.getX() + length / 2, this.center.getY() - this.width / 2));
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() + this.width / 2));
        return apex;
    }

    @Override
    public Position getHead() {
        return this.head;
    }

    @Override
    public Position getCenter() {
        return this.center;
    }

    @Override
    public Velocity getVelocity() {
        return this.velocity;
    }

    @Override
    public void setMoving(boolean isMoving) {
        this.moving = isMoving;
    }

    @Override
    public void setHead(Position position) {
        this.head = position;
    }

    @Override
    public void setCenter(Position point) {
        this.center = point;
    }

    @Override
    public void setColliding(boolean isColliding) {
        this.colliding = isColliding;
    }

    @Override
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    @Override
    public boolean isMoving() {
        return this.moving;
    }

    @Override
    public boolean isColliding() {
        return this.colliding;
    }
}
