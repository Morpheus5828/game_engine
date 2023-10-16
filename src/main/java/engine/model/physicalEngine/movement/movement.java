package engine.model.physicalEngine.movement;

public abstract class movement {

    protected Position position;
    protected Velocity velocity;
    protected Direction direction;

    public void Movement(float x, float y, float velocityX, float velocityY) {
        position = new Position(x, y);
        velocity = new Velocity(velocityX, velocityY);
    }
    public abstract void updatePositon();
    public abstract boolean isColliding();
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
