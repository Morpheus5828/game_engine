package engine.model.physicalEngine;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.movement.*;

/**
 * This class is used to manage the physics of the game. It will manage the entity, the movements
 * and the map.
 * 
 * @see Map
 */
public class PhysicalEngine {
    /**
     * The map of the game.
     */
    private Map map;

    /**
     * Constructor of the PhysicalEngine. The PhysicalEngine is the engine that will manage the physics
     * of the game. By giving the length and the width of the map, the constructor will create a map.
     *
     * @param heightMap
     * @param widthMap
     */
    public PhysicalEngine(double heightMap, double widthMap) {
        this.map = new Map(heightMap, widthMap);
    }

    /**
     * This method will create a Rectangle and add it to the map.
     *
     * @param position
     * @param width
     * @param height
     * @param isMoving
     * @param velocity
     */
    public Rectangle addEntity(Position position, double width, double height, boolean isMoving, Velocity velocity) {
        Rectangle entity = new Rectangle(position, width, height, isMoving, velocity);
        // this.map.addShape(entity);
        if (!this.map.addShape(entity))
            throw new IllegalArgumentException("One of the entities is not in the map.");
        return entity;
    }

    /**
     * This method will create a Rectangle and add it to the map.
     *
     * @param position
     * @param width
     * @param height
     * @param isMoving
     * @param velocity
     * @param isColliding
     */
    public Rectangle addEntity(Position position, double width, double height, boolean isMoving, Velocity velocity,
            boolean isColliding) {
        Rectangle entity = new Rectangle(position, width, height, isMoving, velocity, isColliding);
        // this.map.addShape(entity);
        if (!this.map.addShape(entity))
            throw new IllegalArgumentException("One of the entities is not in the map.");
        return entity;
    }

    /**
     * Return the map of the game.
     * 
     * @return map
     */
    public Map getMap() {
        return this.map;
    }

    /**
     * This method will move the entity in the direction given in parameter.
     *
     * @param shape
     * @param direction
     */
    public boolean moveEntity(Rectangle shape, Direction direction) {
        boolean moved = true;
        Movement movement = new Movement();
        if (direction == Direction.RIGHT || direction == Direction.LEFT) {
            return movement.updatePositonX(direction, shape, this.map);
        } else if (direction == Direction.UP || direction == Direction.DOWN) {
            return movement.updatePositonY(direction, shape, this.map);
        }
        return moved;
    }
}
