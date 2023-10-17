package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.shape.temp.Position;

public class Rectangle implements Shape {
    private Position center;
    private double length;
    private double width;
    private boolean isMoving;

    public Rectangle(float x, float y, double length, double width) {
        setCenter(new Position(x, y));
        this.width = width;
        this.length = length;
        this.isMoving=false;
    }

    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() - this.width / 2));
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() + this.width / 2));
        apex.add(new Position(this.center.getX() + length / 2, this.center.getY() - this.width / 2));
        apex.add(new Position(this.center.getX() - length / 2, this.center.getY() + this.width / 2));
        return apex;
    }

    public void setWidth(double width){
        this.width = width;
    }
    public double getWidth() {
        return this.width;
    }
    public void setLength(double length){
        this.length=length;
    }

    public double getLength() {
        return this.length;
    }

    @Override
    public void setCenter(Position point) {
        this.center = point;
    }

    @Override
    public Position getCenter() {
        return this.center;
    }

    @Override
    public boolean isMoving() {
        return isMoving;
    }

    @Override
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
}
