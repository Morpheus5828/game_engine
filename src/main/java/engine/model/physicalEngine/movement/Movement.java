package engine.model.physicalEngine.movement;

public class Movement {

    protected Position position;
    protected Velocity velocity;
    protected Direction direction;

    public Movement(float x, float y, float velocityX, float velocityY) {
        position = new Position(x, y);
        velocity = new Velocity(velocityX, velocityY);
    }
    public void updatePositonX(){}

    public void updatePositonY(){}

    public  boolean isColliding(){
        return false;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
