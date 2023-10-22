package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Shape;
import javafx.geometry.Pos;

import java.util.List;

public class Movement {
    private Shape shape;
    private Velocity velocity;
    private double distance;
    private Position destination;
    private double jumpX;
    private double jumpY;

    public Movement(Shape shape, Position destination) {
        this.shape = shape;
        this.velocity = this.shape.getVelocity();
        this.destination = destination;
        this.jumpX = Math.abs(this.shape.getCenter().getX() - this.destination.getX()) / this.velocity.getStep();
        this.jumpY = Math.abs(this.shape.getCenter().getY() - this.destination.getY()) / this.velocity.getStep();

    }

    public void updatePositon(Map map) {
        var xSource = this.shape.getCenter().getX();
        var ySource = this.shape.getCenter().getY();
        if(this.destination.getY() == ySource && this.destination.getX() >= xSource) {
            if(!isColliding(map))
                this.shape.getCenter().setX(this.shape.getCenter().getX() + jumpX);
        } else if (this.destination.getY() == ySource && this.destination.getX() <= xSource) {
            if(!isColliding(map))
                this.shape.getCenter().setX(this.shape.getCenter().getX() + jumpX);
        } else if (this.destination.getX() == xSource && this.destination.getY() >= ySource) {
            if(!isColliding(map))
                this.shape.getCenter().setY(this.shape.getCenter().getY() + jumpY);
        } else if (this.destination.getX() == xSource && this.destination.getY() <= ySource) {
            if(!isColliding(map))
                this.shape.getCenter().setY(this.shape.getCenter().getY() + jumpY);
        }


        else if (this.destination.getX() > xSource && this.destination.getY() > ySource) { // diag right up
            if(!isColliding(map)) {
                this.shape.getCenter().setY(this.shape.getCenter().getY() + jumpY);
                this.shape.getCenter().setX(this.shape.getCenter().getX() + jumpX);
            }
        } else if (this.destination.getX() > xSource && this.destination.getY() < ySource) { // diag right down
            if(!isColliding(map)) {
                this.shape.getCenter().setY(this.shape.getCenter().getY() - jumpY);
                this.shape.getCenter().setX(this.shape.getCenter().getX() + jumpX);
            }
        } else if (this.destination.getX() < xSource && this.destination.getY() > ySource) { // diag left up
            if(!isColliding(map)) {
                this.shape.getCenter().setY(this.shape.getCenter().getY() + jumpY);
                this.shape.getCenter().setX(this.shape.getCenter().getX() - jumpX);
            }
        } else if (this.destination.getX() < xSource && this.destination.getY() < ySource) { // diag left up
            if(!isColliding(map)) {
                this.shape.getCenter().setY(this.shape.getCenter().getY() - jumpY);
                this.shape.getCenter().setX(this.shape.getCenter().getX() - jumpX);
            }
        }

        else {
            System.err.println("pb");
        }


    }

    public boolean isColliding(Map map) {
        List<Position> list = shape.getApex();
        for (Position position : list) {
            if(position.getX() < 0 || position.getY() < 0 || position.getX() > map.getHeight() || position.getY() > map.getWidth())
                return true;
        }
        return false;
    }

    public double getDistance() {
        return this.distance;
    }

    public Shape getShape() {
        return shape;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
        this.jumpX = Math.abs(this.shape.getCenter().getX() - destination.getX()) / this.velocity.getStep();
        this.jumpY = Math.abs(this.shape.getCenter().getY() - destination.getY()) / this.velocity.getStep();
    }

    public double getJumpX() {
        return jumpX;
    }

    public double getJumpY() {
        return jumpY;
    }
}
