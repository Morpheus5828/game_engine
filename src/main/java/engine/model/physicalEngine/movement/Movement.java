package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Shape;

public class Movement {
    private Position position;
    private Velocity velocity;
    private Direction direction;

    public Movement(double x, double y, double velocityX, double velocityY) {
        this.position = new Position(x, y);
        this.velocity = new Velocity(velocityX, velocityY);
    }


    public void updatePositonX(Direction direction, Map map) {
        if (!isColliding(map, direction)) {
            if (direction == Direction.RIGHT) {
                position.setX(position.getX() + velocity.getVelocityX());
            } else if (direction == Direction.LEFT) {
                position.setX(position.getX() - velocity.getVelocityX());
            }
        }
    }

    public void updatePositonY(Direction direction, Map map) {
        if (!isColliding(map, direction)) {
            if (direction == Direction.UP) {
                position.setY(position.getY() + velocity.getVelocityY());
            } else if (direction == Direction.DOWN) {
                position.setY(position.getY() - velocity.getVelocityY());
            }
        }
    }

    public boolean isColliding(Map map, Direction direction) {
        if (direction == Direction.UP) {
            double testPosY = position.getY() + velocity.getVelocityY();
            if (testPosY > map.getWidth()) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getPosition().getY() == testPosY
                        || (shape.getPosition().getY() > position.getY() && shape.getPosition().getY() < testPosY)) {
                    return false;
                }
            }
        } else if (direction == Direction.DOWN) {
            double testPosY = position.getY() - velocity.getVelocityY();
            if (testPosY < 0) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getPosition().getY() == testPosY
                        || (shape.getPosition().getY() < position.getY() && shape.getPosition().getY() > testPosY)) {
                    return false;
                }
            }
        } else if (direction == Direction.RIGHT) {
            double testPosX = position.getX() + velocity.getVelocityX();
            if (testPosX > map.getLength()) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getPosition().getX() == testPosX
                        || (shape.getPosition().getX() > position.getX() && shape.getPosition().getX() < testPosX)) {
                    return false;
                }
            }
        } else if (direction == Direction.LEFT) {
            double testPosX = position.getX() - velocity.getVelocityX();
            if (testPosX < 0) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getPosition().getX() == testPosX
                        || (shape.getPosition().getX() < position.getX() && shape.getPosition().getX() > testPosX)) {
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

    public Position getPosition(){
        return this.position;
    }
}
