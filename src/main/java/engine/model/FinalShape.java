package engine.model;

import engine.model.graphicalEngine.drawing.RectangleDrawing;
import engine.model.physicalEngine.PhysicalEngine;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class FinalShape {
    private RectangleDrawing rectangleDrawing;
    private Rectangle rectangle;

    public FinalShape(double x, double y, Image image, double width, double height, boolean moving, Velocity velocity, PhysicalEngine physicalEngine) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity);
        this.rectangleDrawing = new RectangleDrawing(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(), image);
    }

    public FinalShape(double x, double y, Color color, double width, double height, boolean moving, Velocity velocity,PhysicalEngine physicalEngine) {
        this.rectangle = physicalEngine.addEntity(new Position(x, y), width, height, moving, velocity);
        this.rectangleDrawing = new RectangleDrawing(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(), color);
    }


    public RectangleDrawing getRectangleDrawing() {
        return rectangleDrawing;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
