package engine.model.physicalEngine.shape;

import engine.model.physicalEngine.shape.temp.Position;

public interface Shape {
    void setCenter(Position point);

    Position getCenter();

    void setIsMoving(boolean isMoving);

    boolean isMoving();
}
