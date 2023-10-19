package engine.model.physicalEngine.shape;

import engine.model.physicalEngine.movement.*;

public interface Shape {
    void setCenter(Position point);

    Position getCenter();

    void setIsMoving(boolean isMoving);

    boolean isMoving();
}
