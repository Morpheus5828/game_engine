package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import java.util.List;

public class Movement {
    /**
     * Shape has to create a movement which be call for moving.
     **/
    private Rectangle nearest;

    /**
     * Check if the @Rectangle is colliding with another @Rectangle in the @Map
     *
     * @param shape
     * @param map
     * @param direction
     * @return true if the @Rectangle is colliding with another @Rectangle in the @Map
     */
    public boolean isColliding(Rectangle shape, Map map, Direction direction) {
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
                                nearest = shape2;
                                return true;
                            }
                        }
                        case DOWN -> {
                            if (apex.get(1).getY() + shape.getVelocity().getVelocityY() >= apex2.get(0).getY()
                                    && apex.get(3).getX() > apex2.get(0).getX()
                                    && apex.get(1).getX() < apex2.get(2).getX()
                                    && apex.get(1).getY() <= apex2.get(0).getY()) {
                                nearest = shape2;
                                return true;
                            }
                        }
                        case RIGHT -> {
                            if (apex.get(2).getX() + shape.getVelocity().getVelocityX() >= apex2.get(0).getX()
                                    && apex.get(3).getY() > apex2.get(0).getY()
                                    && apex.get(2).getY() < apex2.get(1).getY()
                                    && apex.get(2).getX() <= apex2.get(0).getX()){
                                nearest = shape2;
                                return true;
                            }
                        }
                        case LEFT -> {
                            if (apex.get(1).getX() - shape.getVelocity().getVelocityX() <= apex2.get(2).getX()
                                    && apex.get(1).getY() > apex2.get(0).getY()
                                    && apex.get(0).getY() < apex2.get(1).getY()
                                    && apex.get(1).getX() >= apex2.get(2).getX()){
                                nearest = shape2;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    /**
     * Update the X position of the @Rectangle in the @Map after checking if there is nothing to collide with
     *
     * @param direction
     * @param shape
     * @param map
     */
    public boolean updatePositonX(Direction direction, Rectangle shape, Map map) {
        if (!isColliding(shape, map, direction)) {
            if (direction == Direction.RIGHT) {
                shape.setPosition(shape.getPosition().getX() + shape.getVelocity().getVelocityX(),
                        shape.getPosition().getY());
                return false;
            } else if (direction == Direction.LEFT) {
                shape.setPosition(shape.getPosition().getX() - shape.getVelocity().getVelocityX(),
                        shape.getPosition().getY());
                return false;
            }
        }
        /*
        if (nearest == null) {
            if (direction == Direction.RIGHT) {
                shape.setPosition(0,
                        shape.getPosition().getY());
            } else if (direction == Direction.LEFT){
                shape.setPosition(map.getWidth(), shape.getPosition().getY());
            }
            return true;
        }

         */
        if (direction == Direction.RIGHT) {
            shape.setPosition(nearest.getX() - nearest.getWidth() /2 - shape.getWidth() /2,
                    shape.getPosition().getY());
            return true;
        } else if (direction == Direction.LEFT) {
            shape.setPosition(nearest.getX() + nearest.getWidth() /2 + shape.getWidth() /2 + 2,
                    shape.getPosition().getY());
            return true;
        }
        return true;
    }

    /**
     * Update the Y position of the @Rectangle in the @Map after checking if there is nothing to collide with
     *
     * @param direction
     * @param shape
     * @param map
     */
    public boolean updatePositonY(Direction direction, Rectangle shape, Map map) {
        if (!isColliding(shape, map, direction)) {
            if (direction == Direction.UP) {
                shape.setPosition(shape.getPosition().getX(),
                        shape.getPosition().getY() - shape.getVelocity().getVelocityY());
                return false;
            } else if (direction == Direction.DOWN) {
                shape.setPosition(shape.getPosition().getX(),
                        shape.getPosition().getY() + shape.getVelocity().getVelocityY());
            }
            return false;
        }
        if (direction == Direction.DOWN) {
            shape.setPosition(shape.getPosition().getX(), nearest.getY() - nearest.getHeight() /2 - shape.getHeight() /2);
            return true;
        } else if (direction == Direction.UP) {
            shape.setPosition(shape.getPosition().getX(), nearest.getY() + nearest.getHeight() /2 + shape.getHeight() /2 + 2);
            return true;
        }
        return false;
    }
}
