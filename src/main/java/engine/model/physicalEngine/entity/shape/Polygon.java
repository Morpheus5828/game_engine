package engine.model.physicalEngine.entity.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.entity.temp.Position;

public class Polygon extends AbstractShape {
    private int sides;
    private double corner;

    public Polygon(double x, double y, double radius, int sides) {
        super();
        setCenter(new Position(x, y));
        this.radius = radius;
        this.sides = sides;
        this.corner = 2 * Math.PI / sides;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        for (int i = 0; i < sides; i++) {
            double x = center.getX() + radius * Math.cos(i * corner);
            double y = center.getY() + radius * Math.sin(i * corner);
            apex.add(new Position(x, y));
        }
        return apex;
    }
}
