package engine.model.physicalEngine.shape;

import java.util.List;

import engine.model.physicalEngine.movement.*;

public interface Shape {
    List<Position> getApex();

    Position getCenter();

    Position getHead();

    void setCenter(Position position);

    void setHead(Position position);

    boolean isMoving();

    void setMoving(boolean isMoving);

    boolean isColliding();

    void setColliding(boolean isColliding);

    Velocity getVelocity();

    void setVelocity(Velocity velocity);

    //Direction getDirection();

    //void setDirection(Direction direction);
}
