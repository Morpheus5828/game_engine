package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class Circle implements Shape {
    private Position position;
    private float radius;
    private boolean moving;
    private boolean colliding;
    private Velocity Velocity;
    private Direction direction;
    private Position head;

    public Circle(Position position, float radius, boolean moving, Velocity velocity) {
        if (radius < 0)
            throw new IllegalArgumentException("Le rayon ne peut pas etre negatif");
        this.position = position;
        this.radius = radius;
        this.moving = moving;
        this.colliding = true;
        this.Velocity = velocity;
        this.direction = null;
        setHead();
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.position.getX() - this.radius, this.position.getY()));
        apex.add(new Position(this.position.getX() + this.radius, this.position.getY()));
        apex.add(new Position(this.position.getX(), this.position.getY() - this.radius));
        apex.add(new Position(this.position.getX(), this.position.getY() + this.radius));
        return apex;
    }

    @Override
    public Position getHead() {
        return this.head;
    }

    public void setHead() {
        this.head = new Position(this.position.getX() + this.radius, this.position.getY());
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position point) {
        this.position = point;
    }

    @Override
    public float getX() {
        return this.position.getX();
    }

    @Override
    public float getY() {
        return this.position.getY();
    }

    @Override
    public void setMoving(boolean isMoving) {
        this.moving = isMoving;
    }

    @Override
    public boolean isMoving() {
        return this.moving;
    }

    @Override
    public boolean isColliding() {
        return this.colliding;
    }

    @Override
    public void setColliding(boolean isColliding) {
        this.colliding = isColliding;
    }

    @Override
    public Velocity getVelocity() {
        return this.Velocity;
    }

    @Override
    public void setVelocity(Velocity velocity) {
        this.Velocity = velocity;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
