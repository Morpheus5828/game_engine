package engine.model;

import engine.model.graphicalEngine.drawing.RectangleDrawing;
import engine.model.physicalEngine.PhysicalEngine;
import engine.model.physicalEngine.movement.Direction;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class FinalShape {
    private RectangleDrawing rectangleDrawing;
    private Rectangle rectangle;
    private PhysicalEngine physicalEngine;

    public FinalShape(double x, double y, Image image, double width, double height, boolean moving, Velocity velocity,
            PhysicalEngine physicalEngine) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity);
        this.rectangleDrawing = new RectangleDrawing(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                rectangle.getHeight(), image);
        this.physicalEngine = physicalEngine;
    }

    public FinalShape(double x, double y, Image image, double width, double height, boolean moving, Velocity velocity,
                      PhysicalEngine physicalEngine, boolean isColliding) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity, isColliding);
        this.rectangleDrawing = new RectangleDrawing(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                rectangle.getHeight(), image);
        this.physicalEngine = physicalEngine;
    }

    public FinalShape(double x, double y, Color color, double width, double height, boolean moving, Velocity velocity,
            PhysicalEngine physicalEngine) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity);
        this.rectangleDrawing = new RectangleDrawing(this.rectangle.getX(), this.rectangle.getY(), this.rectangle.getWidth(),
                this.rectangle.getHeight(), color);

        this.physicalEngine = physicalEngine;
    }

    public RectangleDrawing getRectangleDrawing() {
        return rectangleDrawing;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean moveEntity(Direction Direction) {
        boolean result = physicalEngine.moveEntity(this.rectangle, Direction);
        this.rectangleDrawing.setX(this.rectangle.getX());
        this.rectangleDrawing.setY(this.rectangle.getY());
        return result;
    }
}
