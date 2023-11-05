package engine.model.physicalEngine.environment;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.*;

public class Map {
    private double width;
    private double height;
    private List<Rectangle> shapesMoving;
    private List<Rectangle> shapesStatic;

    public Map(double width, double height) {
        this.width = width;
        this.height = height;
        this.shapesMoving = new ArrayList<>();
        this.shapesStatic = new ArrayList<>();
    }

    public boolean isInPlan(Position position) {
        return position.getX() >= 0 && position.getX() <= this.width
                && position.getY() >= 0 && position.getY() <= this.height;
    }

    public boolean shapeIsInPlan(Rectangle shape) {
        List<Position> apex = shape.getApex();
        for (Position position : apex) {
            if (!isInPlan(position))
                return false;
        }
        return true;
    }

    public void removeShape(Rectangle shape) {
        if (shape.isMoving())
            this.shapesMoving.remove(shape);
        else
            this.shapesStatic.remove(shape);
    }

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

    public List<Rectangle> getShapesMoving() {
        return shapesMoving;
    }

    public List<Rectangle> getShapesStatic() {
        return shapesStatic;
    }

    public List<Rectangle> getShapes() {
        List<Rectangle> shapes = new ArrayList<>();
        shapes.addAll(this.shapesMoving);
        shapes.addAll(this.shapesStatic);
        return shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
}
