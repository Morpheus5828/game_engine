package engine.model.physicalEngine.movement;

//import engine.model.physicalEngine.environment.Map;
//import engine.model.physicalEngine.shape.Shape;

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

    public boolean isColliding(Map map,Direction direction){

        if(direction == Direction.HAUT){
            float testPosY = position.getY() + velocity.getVelocityY();
            if(testPosY > map.getHeight()){
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if(shape.getY() == testPosY || (shape.getY() > position.getY() && shape.getY() < testPosY)){
                    return false;
                }
            }
        }
        else if(direction == Direction.BAS){
            float testPosY = position.getY() - velocity.getVelocityY();
            if(testPosY < 0){
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if(shape.getY() == testPosY || (shape.getY() < position.getY() && shape.getY() > testPosY)){
                    return false;
                }
            }
        }
        else if(direction == Direction.DROITE){
            float testPosX = position.getX() + velocity.getVelocityX();
            if(testPosX > map.getWidth()){
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if(shape.getX() == testPosX || (shape.getX() > position.getX() && shape.getX() < testPosX)){
                    return false;
                }
            }
        }
        else if(direction == Direction.GAUCHE){
            float testPosX = position.getX() - velocity.getVelocityX();
            if(testPosX < 0){
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if(shape.getX() == testPosX || (shape.getX() < position.getX() && shape.getX() > testPosX)){
                    return false;
                }
            }
        }
        return true;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
