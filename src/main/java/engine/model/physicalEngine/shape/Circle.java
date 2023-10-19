package engine.model.physicalEngine.shape;

import engine.model.physicalEngine.movement.*;

public class Circle implements Shape {
    private Position center;
    private float radius;
    private boolean moving;
    private boolean colliding;
    private Velocity Velocity;
    private Direction direction;
    private Position head;

    public Circle(float x, float y, float radius, boolean moving, Velocity velocity) {
        if (radius < 0)
            throw new IllegalArgumentException("Le rayon ne peut pas etre negatif");
        setCenter(new Position(x, y));
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
    public Position getHead() {
        return this.head;
    }

    public void setHead() {
        this.head = new Position(this.center.getX() + this.radius, this.center.getY());
    }

    @Override
    public Position getCenter() {
        return this.center;
    }

    @Override
    public void setCenter(Position point) {
        this.center = point;
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
