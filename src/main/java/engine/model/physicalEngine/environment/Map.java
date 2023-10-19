package engine.model.physicalEngine.environment;

import engine.model.physicalEngine.shape.Circle;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.shape.Shape;
import java.util.HashSet;
import java.util.Set;

public class Map {
    private Set<Shape> shapeList;
    private double width;
    private double height;

    public Map(double length, double height) {
        this.width = length;
        this.height = height;
        this.shapeList = new HashSet<>();
    }

    public boolean isInPlan(float x, float y) {
        return x >= 0 && y >= 0 && x <= this.width && y <= this.height;
    }

    public boolean isShapeInPlan(Shape shape) {
        var x = shape.getCenter().getX();
        var y = shape.getCenter().getY();
        if (shape instanceof Circle) {
            var radius = ((Circle) shape).getRadius();
            if ((x + radius > this.width) || (y + radius > this.height) || (x - radius < 0) || (y - radius < 0))
                return false;

        } else if (shape instanceof Rectangle) {
            var shapeLength = ((Rectangle) shape).getLength();
            var shapeWidth = ((Rectangle) shape).getWidth();

            if ((x + shapeWidth > this.width) || (y + shapeLength > this.height) || (x - shapeWidth < 0)
                    || (y - shapeLength < 0))
                return false;
        }

        return true;
    }

    public void removeShape(Shape shape) {
        this.shapeList.remove(shape);
    }

    public void addShape(Shape shape) {
        if (isShapeInPlan(shape))
            this.shapeList.add(shape);
    }

    public Set<Shape> getShapeList() {
        return shapeList;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}
