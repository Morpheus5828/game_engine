package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;
import javafx.scene.paint.Color;

public class Rectangle {
    private Position position;
    private double width;
    private double height;
    private boolean moving;
    private boolean colliding;
    private Velocity Velocity;
    private Direction direction;
    private Position head;
    private Color color;

    public Rectangle(Position position, double width, double height, Color color, boolean moving, Velocity velocity) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.color = color;
        this.moving = moving;
        this.colliding = true;
        this.Velocity = velocity;
        this.direction = Direction.NONE;
        this.head = new Position(position.getX() + height / 2, position.getY());
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.position.getX() - height / 2, this.position.getY() - this.width / 2));
        apex.add(new Position(this.position.getX() - height / 2, this.position.getY() + this.width / 2));
        apex.add(new Position(this.position.getX() + height / 2, this.position.getY() - this.width / 2));
        apex.add(new Position(this.position.getX() - height / 2, this.position.getY() + this.width / 2));
        return apex;
    }

    public Position getHead() {
        return this.head;
    }

    public void setHead(Position position) {
        this.head = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position point) {
        this.position = point;
    }

    public void setPosition(double x, double y) {
        this.position.setPosition(x, y);
    }

    public double getX() {
        return this.position.getX();
    }

    public double getY() {
        return this.position.getY();
    }

    public boolean isMoving() {
        return this.moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isColliding() {
        return this.colliding;
    }

    public void setColliding(boolean colliding) {
        this.colliding = colliding;
    }

    public Velocity getVelocity() {
        return this.Velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.Velocity = velocity;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
