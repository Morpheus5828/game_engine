package engine.model.physicalEngine;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.movement.*;

public class PhysicalEngine {
    private Map map;

    /**
     * Constructor of the PhysicalEngine.
     * The PhysicalEngine is the engine that will manage the physics of the game.
     * It will manage the entity, the collisions, the movements, the map, etc...
     * By giving the length and the width of the map, the constructor will create a map.
     *
     * @param lengthMap
     * @param widthMap
     * @see Map
     */
    public PhysicalEngine(double lengthMap, double widthMap) {
        this.map = new Map(lengthMap, widthMap);
    }


    /**
     * This method will create a @Rectangle and add it to the map.
     *
     * @see Rectangle
     * @see Map
     */
    public void addEntity() {
        Rectangle entity = new Rectangle(new Position(0, 0), 50, 50, true, new Velocity(0, 0));
        map.addShape(entity);
    }

    /**
     * This method will return the map of the Engine.
     * @return the map.
     */
    public Map getMap() {
        return this.map;
    }
}
