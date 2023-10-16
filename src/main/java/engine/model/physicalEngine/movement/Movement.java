package engine.model.physicalEngine.movement;

public class Movement {
    // test
    protected Position position;
    protected Velocity velocity;
    protected Direction direction;

    public Movement(float x, float y, float velocityX, float velocityY) {
        position = new Position(x, y);
        velocity = new Velocity(velocityX, velocityY);
    }
    public void updatePositonX(Direction direction){
        if(isColliding()){
            if(direction == Direction.DROITE){
                position.setX(position.getX() + velocity.getVelocityX());
            }
            else if(direction == Direction.GAUCHE){
                position.setX(position.getX() - velocity.getVelocityX());
            }
        }
    }

    public void updatePositonY(Direction direction){
        if(isColliding()){
            if(direction == Direction.HAUT){
                position.setY(position.getY() + velocity.getVelocityY());
            }
            else if(direction == Direction.BAS){
                position.setY(position.getY()  - velocity.getVelocityY());
            }
        }
    }

    public boolean isColliding(){
        return false;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
