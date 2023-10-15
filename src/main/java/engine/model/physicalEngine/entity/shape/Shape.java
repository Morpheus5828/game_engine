package engine.model.physicalEngine.entity.shape;

import java.util.List;

import engine.model.physicalEngine.entity.temp.Position;

public interface Shape {
    void setCenter(Position point);

    Position getCenter();

    abstract List<Position> getApex();
}
