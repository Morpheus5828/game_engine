package engine.model.physicalEngine;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.movement.*;

public class PhysicalEngine {
    private Map map;
    private Rectangle rectangle;

    public PhysicalEngine() {
        this.map = new Map(100, 100);
        this.rectangle = new Rectangle(new Position(0, 0), 10, 10, true, new Velocity(0.0, 0.0));
    }

    public void move(Direction direction) {
        Movement movement = new Movement(direction);
        movement.updatePositonX(direction, rectangle, map);
        movement.updatePositonY(direction, rectangle, map);
    }
}
