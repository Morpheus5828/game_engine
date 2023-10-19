package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class Rectangle implements Shape {
    private Position position;
    private float length;
    private float width;
    private boolean moving;
    private boolean colliding;
    private Velocity Velocity;
    private Direction direction;
    private Position head;

    public Rectangle(Position position, float length, float width, boolean moving, Velocity velocity) {
        this.position = position;
        this.width = width;
        this.length = length;
        this.moving = moving;
        this.colliding = true;
        this.Velocity = velocity;
        this.direction = null;
        setHead();
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.position.getX() - length / 2, this.position.getY() - this.width / 2));
        apex.add(new Position(this.position.getX() - length / 2, this.position.getY() + this.width / 2));
        apex.add(new Position(this.position.getX() + length / 2, this.position.getY() - this.width / 2));
        apex.add(new Position(this.position.getX() - length / 2, this.position.getY() + this.width / 2));
        return apex;
    }

    @Override
    public Position getHead() {
        return this.head;
    }

    @Override
    public void setHead() {
        this.head = new Position(this.position.getX() + this.length / 2, this.position.getY() + this.width / 2);
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
    public boolean isMoving() {
        return this.moving;
    }

    @Override
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public boolean isColliding() {
        return this.colliding;
    }

    @Override
    public void setColliding(boolean colliding) {
        this.colliding = colliding;
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
