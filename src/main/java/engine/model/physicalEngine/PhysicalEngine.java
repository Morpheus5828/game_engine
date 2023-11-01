package engine.model.physicalEngine;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.movement.*;

public class PhysicalEngine {
    private Map map;

    public PhysicalEngine(double lengthMap, double widthMap) {
        this.map = new Map(lengthMap, widthMap);
    }

    public void addEntity() {
        Rectangle entity = new Rectangle(new Position(0, 0), 50, 50, true, new Velocity(0, 0));
        map.addShape(entity);
    }

    public Map getMap() {
        return this.map;
    }
}
