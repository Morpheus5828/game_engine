package engine.model.physicalEngine.entity;

import engine.model.physicalEngine.entity.shape.Shape;
import engine.model.physicalEngine.entity.temp.Position;

public interface Entity {
    Position getPosition();

    void setPosition(Position position);

    double getSpeed();

    void setSpeed(double speed);

    double getMass();

    void setMass(double mass);

    Shape getShape();

    void setShape(Shape shape);

    boolean isCollisionOn();

    void setCollisionOn(boolean collisionOn);
}
