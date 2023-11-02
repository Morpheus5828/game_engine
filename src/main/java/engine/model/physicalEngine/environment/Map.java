package engine.model.physicalEngine.environment;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.*;

public class Map {
    private List<Rectangle> shapeList;
    private double length;
    private double width;

    /**
     * Constructor of the Map class
     * Create a map (a plan) with a length and a width.
     * The center of the map is the @Position (0,0).
     * This map contain a list of @Rectangle.
     * The map has border and the rectangle can't go out of the map.
     *
     * @param length
     * @param width
     *
     * @see Position
     * @see Rectangle
     */

    public Map(double length, double width) {
        this.length = length;
        this.width = width;
        this.shapeList = new ArrayList<>();
    }

    /**
     * Check if a @Position is in the map.
     *
     * @param position
     * @return true if the position is in the map, false otherwise
     *
     * @see Position
     */

    public boolean isInPlan(Position position) {
        return position.getX() >= -this.length / 2 && position.getX() <= this.length / 2
                && position.getY() >= -this.width / 2 && position.getY() <= this.width / 2;
    }

    /**
     * Check if a @Rectangle is in the map.
     *
     * @param rectangle
     * @return true if the rectangle is in the map, false otherwise
     *
     * @see Rectangle
     */

    public boolean shapeIsInPlan(Rectangle rectangle) {
        List<Position> apex = rectangle.getApex();
        for (Position position : apex) {
            if (!isInPlan(position))
                return false;
        }
        return true;
    }

    /**
     * Remove a @Rectangle from the map list.
     * @param shape
     */
    public void removeShape(Rectangle shape) {
        this.shapeList.remove(shape);
    }

    /**
     * Add a @Rectangle to the map list.
     * @param shape
     */

    public void addShape(Rectangle shape) {
        if (shapeIsInPlan(shape))
            this.shapeList.add(shape);
    }

    /**
     * Return the list of @Rectangle in the map list.
     * @return the list of @Rectangle in the map list
     *
     * @see Rectangle
     */
    public List<Rectangle> getShapeList() {
        return this.shapeList;
    }

    /**
     * Return the length of the map.
     * @return the length of the map
     */

    public double getLength() {
        return this.length;
    }

    /**
     * Return the width of the map.
     * @return the width of the map
     */
    public double getWidth() {
        return this.width;
    }


}
