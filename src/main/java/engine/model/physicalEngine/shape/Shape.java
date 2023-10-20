package engine.model.physicalEngine.shape;

import java.util.List;

import engine.model.physicalEngine.movement.*;

public interface Shape {
    List<Position> getApex();

    Position getHead();

    void setHead(Position position);

    Position getPosition();

    void setPosition(Position point);

    double getX();

    double getY();

    boolean isMoving();

    void setMoving(boolean isMoving);

    boolean isColliding();

    void setColliding(boolean isColliding);

    Velocity getVelocity();

    void setVelocity(Velocity velocity);

    Direction getDirection();

    void setDirection(Direction direction);
}
