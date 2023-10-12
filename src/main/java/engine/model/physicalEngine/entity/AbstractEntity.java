package engine.model.physicalEngine.entity;

import engine.model.physicalEngine.entity.shape.Shape;
import engine.model.physicalEngine.entity.temp.Position;
import javafx.scene.paint.Color;

public abstract class AbstractEntity implements Entity {
    protected Position position;
    protected double speed;
    protected double mass;
    protected Shape shape;
    protected boolean collisionOn;
    protected Color color;

    public AbstractEntity(Position position, double speed, double mass, boolean collisionOn, Shape shape) {
        this.position = position;
        this.speed = speed;
        this.mass = mass;
        this.collisionOn = collisionOn;
        this.shape = shape;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public boolean isCollisionOn() {
        return collisionOn;
    }

    @Override
    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }
}
