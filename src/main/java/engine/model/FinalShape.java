package engine.model;

import engine.model.graphicalEngine.drawing.RectangleDrawing;
import engine.model.physicalEngine.PhysicalEngine;
import engine.model.physicalEngine.movement.Direction;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a final shape. A final shape is a shape who link a physical shape
 * and a graphical shape.
 * 
 * @see RectangleDrawing
 * @see Rectangle
 * @see PhysicalEngine
 */
public class FinalShape {
    /**
     * The graphical shape.
     */
    private RectangleDrawing rectangleDrawing;

    /**
     * The physical shape.
     */
    private Rectangle rectangle;

    /**
     * An instance of PhysicalEngine.
     */
    private PhysicalEngine physicalEngine;

    /**
     * Constructor of FinalShape. Create a final shape with a specific x, y, image, width, height,
     * moving, velocity and physicalEngine.
     * 
     * @param x
     * @param y
     * @param image
     * @param width
     * @param height
     * @param moving
     * @param velocity
     * @param physicalEngine
     */
    public FinalShape(double x, double y, Image image, double width, double height, boolean moving, Velocity velocity,
            PhysicalEngine physicalEngine) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity);
        this.rectangleDrawing = new RectangleDrawing(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                rectangle.getHeight(), image);
        this.physicalEngine = physicalEngine;
    }

    /**
     * Constructor of FinalShape. Create a final shape with a specific x, y, color, width, height,
     * moving, velocity and physicalEngine.
     * 
     * @param x
     * @param y
     * @param color
     * @param width
     * @param height
     * @param moving
     * @param velocity
     * @param physicalEngine
     */
    public FinalShape(double x, double y, Color color, double width, double height, boolean moving, Velocity velocity,
            PhysicalEngine physicalEngine) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity);
        this.rectangleDrawing = new RectangleDrawing(this.rectangle.getX(), this.rectangle.getY(),
                this.rectangle.getWidth(), this.rectangle.getHeight(), color);

        this.physicalEngine = physicalEngine;
    }

    /**
     * Get the graphical shape.
     * 
     * @return RectangleDrawing
     */
    public RectangleDrawing getRectangleDrawing() {
        return rectangleDrawing;
    }

    /**
     * Get the physical shape.
     * 
     * @return Rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * Move the entity in a specific direction.
     * 
     * @param Direction
     * @return boolean
     */
    public boolean moveEntity(Direction Direction) {
        boolean result = physicalEngine.moveEntity(this.rectangle, Direction);
        this.rectangleDrawing.setX(this.rectangle.getX());
        this.rectangleDrawing.setY(this.rectangle.getY());
        return result;
    }

    public boolean shapeTouching(FinalShape f){
        return physicalEngine.testTouching(this.getRectangle(), f.getRectangle());
    }

    public void reinit(double x, double y){
        this.getRectangle().setPosition(x, y);
    }
}
