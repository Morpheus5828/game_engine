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
     * @param heightMap
     * @param widthMap
     * @see Map
     */
    public PhysicalEngine(double heightMap, double widthMap) {
        this.map = new Map(heightMap, widthMap);
    }

    public void addEntity(Position position, double width, double height, boolean isMoving, Velocity velocity) {
        Rectangle entity = new Rectangle(position, width, height, isMoving, velocity);
        if (!this.map.addShape(entity))
            throw new IllegalArgumentException("One of the entities is not in the map.");
    }

    public Map getMap() {
        return this.map;
    }

    /**
     * This method will create a @Rectangle and add it to the map.
     *
     * @see Rectangle
     * @see Map
     */
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
