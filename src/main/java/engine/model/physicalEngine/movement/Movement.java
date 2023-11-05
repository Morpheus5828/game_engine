package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import java.util.List;

public class Movement {
    /**
     * Shape has to create a movement which be call for moving.
     **/

    private Direction direction;

    public Movement(Direction direction) {
        this.direction = direction;
    }

    public boolean updatePositonX(Direction direction, Rectangle shape, Map map) {
        if (!isColliding(shape, map, direction)) {
            if (direction == Direction.RIGHT) {
                shape.setPosition(shape.getPosition().getX() + shape.getVelocity().getVelocityX(),
                        shape.getPosition().getY());
            } else if (direction == Direction.LEFT) {
                shape.setPosition(shape.getPosition().getX() - shape.getVelocity().getVelocityX(),
                        shape.getPosition().getY());
            }
            return true;
        }
        return false;
    }

    public boolean updatePositonY(Direction direction, Rectangle shape, Map map) {
        if (!isColliding(shape, map, direction)) {
            if (direction == Direction.UP) {
                shape.setPosition(shape.getPosition().getX(),
                        shape.getPosition().getY() - shape.getVelocity().getVelocityY());
            } else if (direction == Direction.DOWN) {
                shape.setPosition(shape.getPosition().getX(),
                        shape.getPosition().getY() + shape.getVelocity().getVelocityY());
            }
            return true;
        }
        return false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isColliding(Rectangle shape, Map map, Direction direction) {
        List<Position> apex = shape.getApex();
        for (Rectangle shape2 : map.getShapes()) {
            if (shape2 != shape) {
                List<Position> apex2 = shape2.getApex();
                for (int i = 0; i < apex.size(); i++) {
                    switch (direction) {
                    case UP -> {
                        if (apex.get(i).getY() - shape.getVelocity().getVelocityY() < 0)
                            return true;
                        if (i == 0 || i == 2) {
                            if (apex.get(i).getY() - shape.getVelocity().getVelocityY() >= apex2.get(0).getY()
                                    && apex.get(i).getY() - shape.getVelocity().getVelocityY() <= apex2.get(1).getY()
                                    && apex.get(i).getX() >= apex2.get(1).getX()
                                    && apex.get(i).getX() <= apex2.get(3).getX())
                                return true;
                        }
                    }
                    case DOWN -> {
                        if (apex.get(i).getY() + shape.getVelocity().getVelocityY() > map.getHeight())
                            return true;
                        if (i == 1 || i == 3) {
                            if (apex.get(i).getY() + shape.getVelocity().getVelocityY() >= apex2.get(0).getY()
                                    && apex.get(i).getY() + shape.getVelocity().getVelocityY() <= apex2.get(1).getY()
                                    && apex.get(i).getX() >= apex2.get(0).getX()
                                    && apex.get(i).getX() <= apex2.get(2).getX())
                                return true;
                        }
                    }
                    case RIGHT -> {
                        if (apex.get(i).getX() + shape.getVelocity().getVelocityX() > map.getWidth())
                            return true;
                        if (i >= 2) {
                            if (apex.get(i).getX() + shape.getVelocity().getVelocityX() >= apex2.get(0).getX()
                                    && apex.get(i).getX() + shape.getVelocity().getVelocityX() <= apex2.get(2).getX()
                                    && apex.get(i).getY() >= apex2.get(0).getY()
                                    && apex.get(i).getY() <= apex2.get(1).getY())
                                return true;
                        }
                    }
                    case LEFT -> {
                        if (apex.get(i).getX() - shape.getVelocity().getVelocityX() < 0)
                            return true;
                        if (i < 2) {
                            if (apex.get(i).getX() - shape.getVelocity().getVelocityX() <= apex2.get(2).getX()
                                    && apex.get(i).getX() - shape.getVelocity().getVelocityX() >= apex2.get(0).getX()
                                    && apex.get(i).getY() >= apex2.get(0).getY()
                                    && apex.get(i).getY() <= apex2.get(1).getY())
                                return true;
                        }
                    }
                    default -> {
                        break;
                    }
                    }
                }
            }
        }
        return false;
    }
}
