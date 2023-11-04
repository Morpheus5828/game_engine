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

    public void addEntity(Color color) {
        Rectangle entity = new Rectangle(new Position(0, 0), 50, 50, color, true, new Velocity(0, 0));
        map.addShape(entity);
    }

    public Map getMap() {
        return this.map;
    }
}
