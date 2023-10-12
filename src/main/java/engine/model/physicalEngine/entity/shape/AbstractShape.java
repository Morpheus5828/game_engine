package engine.model.physicalEngine.entity.shape;

import java.util.List;

import engine.model.physicalEngine.entity.temp.Position;

public abstract class AbstractShape implements Shape {
    protected Position center;
    protected double radius;

    @Override
    public void setCenter(Position point) {
        this.center = point;
    }

    @Override
    public Position getCenter(int index) {
        return this.center;
    }

    @Override
    public abstract List<Position> getApex();

    public double getRadius() {
        return this.radius;
    }
}
