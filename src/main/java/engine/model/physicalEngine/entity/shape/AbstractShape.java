package engine.model.physicalEngine.entity.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.entity.temp.Position;

public abstract class AbstractShape implements Shape {
    protected Position center;
    protected List<Position> apex = new ArrayList<>();
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
    public void setApex(List<Position> apex) {
        this.apex = apex;
    }

    @Override
    public List<Position> getApex() {
        return this.apex;
    }

    public double getRadius() {
        return this.radius;
    }
}
