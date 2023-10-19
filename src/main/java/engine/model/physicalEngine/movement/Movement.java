package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Shape;

public class Movement {
    private Position position;
    private Velocity velocity;
    private Direction direction;
    private Map map;

    public Movement(float x, float y, float velocityX, float velocityY, Map map) {
        this.position = new Position(x, y);
        this.velocity = new Velocity(velocityX, velocityY);
        this.map = map;
    }

    public void updatePositonX(Direction direction) {
        if (!isColliding(this.map, direction)) {
            if (direction == Direction.RIGHT) {
                position.setX(position.getX() + velocity.getVelocityX());
            } else if (direction == Direction.LEFT) {
                position.setX(position.getX() - velocity.getVelocityX());
            }
        }
    }

    public void updatePositonY(Direction direction) {
        if (!isColliding(this.map, direction)) {
            if (direction == Direction.TOP) {
                position.setY(position.getY() + velocity.getVelocityY());
            } else if (direction == Direction.BOTTOM) {
                position.setY(position.getY() - velocity.getVelocityY());
            }
        }
    }

    public boolean isColliding(Map map, Direction direction) {
        if (direction == Direction.TOP) {
            float testPosY = position.getY() + velocity.getVelocityY();
            if (testPosY > map.getHeight()) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getCenter().getY() == testPosY
                        || (shape.getCenter().getY() > position.getY() && shape.getCenter().getY() < testPosY)) {
                    return false;
                }
            }
        } else if (direction == Direction.BOTTOM) {
            float testPosY = position.getY() - velocity.getVelocityY();
            if (testPosY < 0) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getCenter().getY() == testPosY
                        || (shape.getCenter().getY() < position.getY() && shape.getCenter().getY() > testPosY)) {
                    return false;
                }
            }
        } else if (direction == Direction.RIGHT) {
            float testPosX = position.getX() + velocity.getVelocityX();
            if (testPosX > map.getWidth()) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getCenter().getX() == testPosX
                        || (shape.getCenter().getX() > position.getX() && shape.getCenter().getX() < testPosX)) {
                    return false;
                }
            }
        } else if (direction == Direction.LEFT) {
            float testPosX = position.getX() - velocity.getVelocityX();
            if (testPosX < 0) {
                return false;
            }
            for (Shape shape : map.getShapeList()) {
                if (shape.getCenter().getX() == testPosX
                        || (shape.getCenter().getX() < position.getX() && shape.getCenter().getX() > testPosX)) {
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
