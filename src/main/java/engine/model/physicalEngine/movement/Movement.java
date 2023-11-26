package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import java.util.List;

/**
 * This class is used to move a Rectangle in a Map
 *
 * @see Rectangle
 * @see Map
 */
public class Movement {
    /**
     * If obstacle != null, the shape in movement will stop before this obstacle
     **/
    private Rectangle obstacle;

    /**
     * Check if the Rectangle will collide with another Rectangle in the Map following a Direction
     *
     * @param shape : the Rectangle in movement
     * @param map : the Map
     * @param direction : the Direction following by the Rectangle
     *                  
     * @return true if the Rectangle will collide with another Rectangle in the Map
     */
    public boolean willCollide(Rectangle shape, Map map, Direction direction) {
        List<Position> apex = shape.getApex();
        for (Rectangle shape2 : map.getShapes()) {
            if (shape2 != shape) {
                if (shape2.isColliding()) {
                    List<Position> apex2 = shape2.getApex();
                    switch (direction) {
                        case UP -> {
                            if (apex.get(2).getY() - shape.getVelocity().getVelocityY() <= apex2.get(1).getY()
                                    && apex.get(2).getX() > apex2.get(1).getX()
                                    && apex.get(0).getX() < apex2.get(3).getX()
                                    && apex.get(2).getY() >= apex2.get(1).getY()) {
                                obstacle = shape2;
                                return true;
                            }
                        }
                        case DOWN -> {
                            if (apex.get(1).getY() + shape.getVelocity().getVelocityY() >= apex2.get(0).getY()
                                    && apex.get(3).getX() > apex2.get(0).getX()
                                    && apex.get(1).getX() < apex2.get(2).getX()
                                    && apex.get(1).getY() <= apex2.get(0).getY()) {
                                obstacle = shape2;
                                return true;
                            }
                        }
                        case RIGHT -> {
                            if (apex.get(2).getX() + shape.getVelocity().getVelocityX() >= apex2.get(0).getX()
                                    && apex.get(3).getY() > apex2.get(0).getY()
                                    && apex.get(2).getY() < apex2.get(1).getY()
                                    && apex.get(2).getX() <= apex2.get(0).getX()){
                                obstacle = shape2;
                                return true;
                            }
                        }
                        case LEFT -> {
                            if (apex.get(1).getX() - shape.getVelocity().getVelocityX() <= apex2.get(2).getX()
                                    && apex.get(1).getY() > apex2.get(0).getY()
                                    && apex.get(0).getY() < apex2.get(1).getY()
                                    && apex.get(1).getX() >= apex2.get(2).getX()){
                                obstacle = shape2;
                                return true;
                            }
                        }
                        case NONE -> {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }


    /**
     * Update the X position of the Rectangle in the Map depending on whether the Rectangle will collide or not
     *
     * @param direction : the Direction following by the Rectangle
     * @param shape : the Rectangle in movement
     * @param map : the Map
     */
    public boolean updatePositonX(Direction direction, Rectangle shape, Map map) {
        if (!willCollide(shape, map, direction)) {
            if (direction == Direction.RIGHT) {
                shape.setPosition(shape.getPosition().getX() + shape.getVelocity().getVelocityX(),
                        shape.getPosition().getY());
                return true;
            } else if (direction == Direction.LEFT) {
                shape.setPosition(shape.getPosition().getX() - shape.getVelocity().getVelocityX(),
                        shape.getPosition().getY());
                return true;
            }
            else return false;
        }
        if (direction == Direction.RIGHT) {
            shape.setPosition(obstacle.getX() - obstacle.getWidth() /2 - shape.getWidth() /2,
                    shape.getPosition().getY());
            return true;
        } else if (direction == Direction.LEFT) {
            shape.setPosition(obstacle.getX() + obstacle.getWidth() /2 + shape.getWidth() /2 + 2,
                    shape.getPosition().getY());
            return true;
        }
        return false;
    }

    /**
     * Update the Y position of the Rectangle in the Map depending on whether the Rectangle will collide or not
     *
     * @param direction : the Direction following by the @Rectangle
     * @param shape : the Rectangle in movement
     * @param map : the Map
     */
    public boolean updatePositonY(Direction direction, Rectangle shape, Map map) {
        if (!willCollide(shape, map, direction)) {
            if (direction == Direction.UP) {
                shape.setPosition(shape.getPosition().getX(),
                        shape.getPosition().getY() - shape.getVelocity().getVelocityY());
            } else if (direction == Direction.DOWN) {
                shape.setPosition(shape.getPosition().getX(),
                        shape.getPosition().getY() + shape.getVelocity().getVelocityY());
            }
            return true;
        }
        if (direction == Direction.DOWN) {
            shape.setPosition(shape.getPosition().getX(), obstacle.getY() - obstacle.getHeight() /2 - shape.getHeight() /2);
            return true;
        } else if (direction == Direction.UP) {
            shape.setPosition(shape.getPosition().getX(), obstacle.getY() + obstacle.getHeight() /2 + shape.getHeight() /2 + 2);
            return true;
        }
        return false;
    }
}
