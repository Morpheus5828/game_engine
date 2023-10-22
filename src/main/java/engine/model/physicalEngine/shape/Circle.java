package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class Circle implements Shape {
    private Position center;
    private Position head;
    private final double radius;
    private boolean moving;
    private boolean colliding;
    private Velocity velocity;

    public Circle(Position center, double radius, Velocity velocity) {
        if (radius < 0)
            throw new IllegalArgumentException("Radius value mustn't be negative");
        this.center = center;
        this.radius = radius;
        this.moving = false;
        this.colliding = true;
        this.velocity = velocity;
        this.head = new Position(this.center.getX() + this.radius / 2, this.center.getY());
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.center.getX() - this.radius, this.center.getY()));
        apex.add(new Position(this.center.getX() + this.radius, this.center.getY()));
        apex.add(new Position(this.center.getX(), this.center.getY() - this.radius));
        apex.add(new Position(this.center.getX(), this.center.getY() + this.radius));
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
