package engine.model.physicalEngine.environment;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.*;

public class Map {
    private List<Rectangle> shapeList;
    private double length;
    private double width;

    public Map(double length, double width) {
        this.length = length;
        this.width = width;
        this.shapeList = new ArrayList<>();
    }

    public boolean isInPlan(Position position) {
        return position.getX() >= -this.length / 2 && position.getX() <= this.length / 2
                && position.getY() >= -this.width / 2 && position.getY() <= this.width / 2;
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
        this.shapeList.remove(shape);
    }

    public void addShape(Rectangle shape) {
        if (shapeIsInPlan(shape))
            this.shapeList.add(shape);
    }

    public List<Rectangle> getShapeList() {
        return this.shapeList;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }


}
