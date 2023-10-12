package engine.model.physicalEngine.entity.shape;

import engine.model.physicalEngine.entity.temp.Position;

public class Circle extends AbstractShape {

    public Circle(double x, double y, double radius) {
        setCenter(new Position(x, y));
        this.radius = radius;
    }
}
