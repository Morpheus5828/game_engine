package engine.model.physicalEngine.shape;

import java.util.List;

import engine.model.physicalEngine.shape.temp.Position;

public interface Shape {
    void setCenter(Position point);

    Position getCenter();

    void setIsMoving(boolean isMoving);

    boolean IsMoving();
}
