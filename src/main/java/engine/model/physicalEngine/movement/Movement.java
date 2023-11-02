package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import java.util.List;

public class Movement {


    private Direction direction;

    /**
     *
     * Create a new movement that will be called by a @Rectangle to move in the @Map
     * We use the different direction listed in the enum @Direction
     *
     * @param direction
     *       The direction of the movement
     *
     * @see Direction
     * @see Rectangle
     */

    public Movement(Direction direction) {
        this.direction = direction;
    }

    /**
     * Update the X position of the @Rectangle in the @Map after checking if there is nothing to collide with
     *
     *
     * @param direction
     * @param shape
     * @param map
     */
    public void updatePositonX(Direction direction, Rectangle shape, Map map) {
        if(!isColliding(shape, map, direction)){
            if (direction == Direction.RIGHT) {
                shape.setPosition(shape.getX() + shape.getVelocity().getVelocityX(), shape.getY());
            }
            else if (direction == Direction.LEFT) {
                shape.setPosition(shape.getX() - shape.getVelocity().getVelocityX(), shape.getY());
            }
        }
    }

    /**
     * Update the Y position of the @Rectangle in the @Map after checking if there is nothing to collide with
     *
     * @param direction
     * @param shape
     * @param map
     */

    public void updatePositonY(Direction direction, Rectangle shape, Map map) {
        if (!isColliding(shape, map, direction)) {
            if (direction == Direction.UP) {
                shape.setPosition(shape.getPosition().getX(), shape.getPosition().getY() + shape.getVelocity().getVelocityY());
            }
            else if (direction == Direction.DOWN) {
                shape.setPosition(shape.getPosition().getX(), shape.getPosition().getY() - shape.getVelocity().getVelocityY());
            }
        }
    }

    /**
     * get the direction of the movement
     *
     * @return the direction of the movement
     */

    public Direction getDirection() {
        return direction;
    }

    /**
     * set the direction of the movement
     *
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }


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
        for (Rectangle shape2 : map.getShapeList()) {
            if (shape2 != shape) {
                List<Position> apex2 = shape2.getApex();
                for (int i = 0; i < apex.size(); i++) {
                    switch (direction){
                        case UP -> {
                            if (apex.get(i).getY() < apex2.get(i).getY() && apex.get(i).getY() + shape.getVelocity().getVelocityY() >= apex2.get(i).getY())
                                return true;
                        }
                        case DOWN -> {
                            if (apex.get(i).getY() > apex2.get(i).getY() && apex.get(i).getY() - shape.getVelocity().getVelocityY() <= apex2.get(i).getY())
                                return true;
                        }
                        case RIGHT -> {
                            if (apex.get(i).getX() < apex2.get(i).getX() && apex.get(i).getX() + shape.getVelocity().getVelocityX() >= apex2.get(i).getX())
                                return true;
                        }
                        case LEFT -> {
                            if (apex.get(i).getX() > apex2.get(i).getX() && apex.get(i).getX() - shape.getVelocity().getVelocityX() <= apex2.get(i).getX())
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
