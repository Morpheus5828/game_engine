package engine.model.physicalEngine.environment;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.*;

/**
 * Represents a map in the game engine. The map is a plan with a specified width and height. It
 * contains a list of moving and static rectangles. The map has borders, and the rectangles cannot
 * go outside the map.
 * 
 * @see Rectangle
 */
public class Map {
    private double width;
    private double height;
    private List<Rectangle> shapesMoving;
    private List<Rectangle> shapesStatic;

    /**
     * Constructor of the Map class Create a map (a plan) with a length and a width.
     *
     * @param height
     * @param width
     */

    public Map(double width, double height) {
        this.width = width;
        this.height = height;
        this.shapesMoving = new ArrayList<>();
        this.shapesStatic = new ArrayList<>();
    }

    /**
     * Check if a Position is in the map.
     *
     * @param position
     * @return true if the position is in the map, false otherwise
     */

    public boolean isInPlan(Position position) {
        return position.getX() >= 0 && position.getX() <= this.width && position.getY() >= 0
                && position.getY() <= this.height;
    }

    /**
     * Check if a Rectangle is in the map.
     *
     * @param shape
     * @return true if the rectangle is in the map, false otherwise
     */

    public boolean shapeIsInPlan(Rectangle shape) {
        List<Position> apex = shape.getApex();
        for (Position position : apex) {
            if (!isInPlan(position))
                return false;
        }
        return true;
    }

    /**
     * Remove a Rectangle from the map list.
     * 
     * @param shape
     */

    public void removeShape(Rectangle shape) {
        if (shape.isMoving())
            this.shapesMoving.remove(shape);
        else
            this.shapesStatic.remove(shape);
    }

    /**
     * Add a Rectangle to the map list.
     * 
     * @param shape
     */

    public boolean addShape(Rectangle shape) {
        if (shapeIsInPlan(shape)) {
            if (shape.isMoving())
                this.shapesMoving.add(shape);
            else
                this.shapesStatic.add(shape);
            return true;
        }
        return false;
    }

    /**
     * Return the moving list of Rectangle in the map list.
     * 
     * @return the moving list of Rectangle in the map list
     */
    public List<Rectangle> getShapesMoving() {
        return shapesMoving;
    }

    /**
     * Return the static list of Rectangle in the map list.
     * 
     * @return the static list of Rectangle in the map list
     */
    public List<Rectangle> getShapesStatic() {
        return shapesStatic;
    }

    /**
     * Return the list of All Rectangle in the map.
     * 
     * @return the list of All Rectangle in the map
     */
    public List<Rectangle> getShapes() {
        List<Rectangle> shapes = new ArrayList<>();
        shapes.addAll(this.shapesMoving);
        shapes.addAll(this.shapesStatic);
        return shapes;
    }

    /**
     * Return the width of the map.
     * 
     * @return the width of the map
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the height of the map.
     * 
     * @return the height of the map
     */
    public double getHeight() {
        return this.height;
    }
}
