package engine.model.physicalEngine.environment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.*;

public class Map {
    private Set<Shape> shapeList;
    private float length;
    private float width;

    public Map(float length, float width) {
        this.length = length;
        this.width = width;
        this.shapeList = new HashSet<>();
    }

    public boolean isInPlan(Position position) {
        return position.getX() >= -this.length / 2 && position.getX() <= this.length / 2
                && position.getY() >= -this.width / 2 && position.getY() <= this.width / 2;
    }

    public boolean shapeIsInPlan(Shape shape) {
        List<Position> apex = shape.getApex();
        for (Position position : apex) {
            if (!isInPlan(position))
                return false;
        }
        return true;
    }

    public void removeShape(Shape shape) {
        this.shapeList.remove(shape);
    }

    public void addShape(Shape shape) {
        if (shapeIsInPlan(shape))
            this.shapeList.add(shape);
    }

    public Set<Shape> getShapeList() {
        return this.shapeList;
    }

    public float getLength() {
        return this.length;
    }

    public float getWidth() {
        return this.width;
    }
}
