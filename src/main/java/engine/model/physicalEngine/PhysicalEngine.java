package engine.model.physicalEngine;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.movement.*;
import javafx.scene.paint.Color;

public class PhysicalEngine {
    private Map map;

    public PhysicalEngine(double heightMap, double widthMap) {
        this.map = new Map(heightMap, widthMap);
    }

    public void addEntity(Position position, Color color, boolean isMoving, Velocity velocity) {
        Rectangle entity = new Rectangle(position, 50, 50, color, true, velocity);
        if (!this.map.addShape(entity))
            throw new IllegalArgumentException("One of the entities is not in the map.");
    }

    public Map getMap() {
        return this.map;
    }

    public boolean moveEntity(Rectangle shape, Direction direction) {
        boolean moved = true;
        Movement movement = new Movement(direction);
        if (!movement.updatePositonX(direction, shape, this.map))
            moved = false;
        if (!movement.updatePositonY(direction, shape, this.map))
            moved = false;
        return moved;
    }
}
