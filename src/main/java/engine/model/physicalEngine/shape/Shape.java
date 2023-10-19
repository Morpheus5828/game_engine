package engine.model.physicalEngine.shape;

import engine.model.physicalEngine.movement.*;

public interface Shape {
    Position getHead();

    void setHead();

    Position getCenter();

    void setCenter(Position point);

    boolean isMoving();

    void setMoving(boolean isMoving);

    boolean isColliding();

    void setColliding(boolean isColliding);

    Velocity getVelocity();

    void setVelocity(Velocity velocity);

    Direction getDirection();

    void setDirection(Direction direction);
}
