package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import java.util.List;

public class Movement {
    static boolean shapeIsNearLeftWall = false;
    static boolean shapeIsNearRightWall = false;
    static boolean shapeIsNearUpWall = false;
    static boolean shapeIsNearDownWall = false;

    /**
     * Shape has to create a movement which be call for moving.
     **/

    private Direction direction;

    /**
     * Create a new movement that will be called by a @Rectangle to move in the @Map We use the
     * different direction listed in the enum @Direction
     *
     * @param direction The direction of the movement
     * @see Direction
     * @see Rectangle
     */
    public Movement(Direction direction) {
        this.direction = direction;
    }

    /**
     * Update the X position of the @Rectangle in the @Map after checking if there is nothing to collide
     * with
     *
     * @param direction
     * @param shape
     * @param map
     */

    /**
     * Update the Y position of the @Rectangle in the @Map after checking if there is nothing to collide
     * with
     *
     * @param direction
     * @param shape
     * @param map
     */

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
     * @param currentShape
     * @param map
     * @param direction
     * @return true if the @Rectangle is colliding with another @Rectangle in the @Map
     */

    public boolean updatePositonX(Direction direction, Rectangle currentShape, Map map) {
            List<Position> currentApex = currentShape.getApex();
            for (Rectangle shape : map.getShapes()) {
                if (shape != currentShape) {
                    List<Position> apex = shape.getApex();
                    switch (direction) {
                        case RIGHT -> {
                            if (!shapeIsNearRightWall) {
                                if (
                                        currentApex.get(3).getY() == apex.get(1).getY() && currentApex.get(2).getY() == apex.get(0).getY() &&
                                                currentApex.get(2).getX() + currentShape.getVelocity().getVelocityX() <= apex.get(0).getX() &&
                                                currentApex.get(3).getX() + currentShape.getVelocity().getVelocityX() <= apex.get(1).getX()
                                ) {
                                    currentShape.setPosition(
                                            currentShape.getPosition().getX() + currentShape.getVelocity().getVelocityX(),
                                            currentShape.getPosition().getY()
                                    );

                                    return true;
                                }
                                if (
                                        currentApex.get(3).getY() == apex.get(1).getY() && currentApex.get(2).getY() == apex.get(0).getY() &&
                                                currentApex.get(2).getX() + currentShape.getVelocity().getVelocityX() > apex.get(0).getX() &&
                                                currentApex.get(3).getX() + currentShape.getVelocity().getVelocityX() > apex.get(1).getX() &&
                                                currentApex.get(2).getX() < apex.get(0).getX()
                                ) {
                                    currentShape.setPosition(apex.get(0).getX() - currentShape.getWidth() / 2, currentShape.getPosition().getY());
                                    shapeIsNearRightWall = true;
                                    return true;
                                }
                            } else {
                                currentShape.setPosition(currentShape.getPosition().getX(), currentShape.getPosition().getY());
                            }
                        }
                        case LEFT -> {
                            if(!shapeIsNearLeftWall) {
                                if (
                                    currentApex.get(1).getY() == apex.get(3).getY() && currentApex.get(0).getY() == apex.get(2).getY() &&
                                    currentApex.get(0).getX() - currentShape.getVelocity().getVelocityX() >= apex.get(2).getX() &&
                                    currentApex.get(1).getX() - currentShape.getVelocity().getVelocityX() >= apex.get(3).getX()
                                ) {
                                    currentShape.setPosition(
                                 currentShape.getPosition().getX() - currentShape.getVelocity().getVelocityX(),
                                    currentShape.getPosition().getY()
                                    );
                                    return true;
                                }

                                if (
                                    currentApex.get(3).getY() == apex.get(1).getY() && currentApex.get(2).getY() == apex.get(0).getY() &&
                                    currentApex.get(0).getX() - currentShape.getVelocity().getVelocityX() < apex.get(2).getX() &&
                                    currentApex.get(1).getX() - currentShape.getVelocity().getVelocityX() < apex.get(3).getX() &&
                                    currentApex.get(0).getX() > apex.get(1).getX()
                                ) {
                                    System.out.println("coucou");
                                    currentShape.setPosition(apex.get(2).getX()+currentShape.getWidth()/2, currentShape.getPosition().getY());
                                    shapeIsNearLeftWall = true;
                                    return true;
                                }
                            }
                            else {
                                currentShape.setPosition(currentShape.getPosition().getX(), currentShape.getPosition().getY());
                            }
                        }
                    }
                }
            }

        return false;
    }

    public boolean updatePositonY(Direction direction, Rectangle currentShape, Map map) {
        List<Position> currentApex = currentShape.getApex();
        for (Rectangle shape : map.getShapes()) {
            if (shape != currentShape) {
                List<Position> apex = shape.getApex();
                switch (direction) {
                    case UP -> {
                        if(!shapeIsNearUpWall) {
                            if (
                                    currentApex.get(1).getX() == apex.get(0).getX() && currentApex.get(3).getX() == apex.get(2).getX() &&
                                    currentApex.get(0).getY() - currentShape.getVelocity().getVelocityY() <= apex.get(1).getY() &&
                                    currentApex.get(2).getY() - currentShape.getVelocity().getVelocityY() <= apex.get(3).getY()
                            ) {
                                currentShape.setPosition(
                                        currentShape.getPosition().getX(),
                                        currentShape.getPosition().getY() - currentShape.getVelocity().getVelocityY()
                                );

                                return true;
                            } if ( //TODO marche pas ici
                                    currentApex.get(1).getX() == apex.get(0).getX() && currentApex.get(3).getX() == apex.get(2).getX() &&
                                    currentApex.get(0).getY() - currentShape.getVelocity().getVelocityY() > apex.get(1).getY() &&
                                    currentApex.get(2).getY() - currentShape.getVelocity().getVelocityY() > apex.get(3).getY() &&
                                    currentApex.get(0).getY() < apex.get(1).getY()
                            ) {
                                System.out.println("cc");
                                currentShape.setPosition(currentShape.getPosition().getX(), currentShape.getPosition().getY() + currentShape.getHeight()/2);
                                shapeIsNearUpWall = true;
                                return true;
                            }
                        } else {
                            currentShape.setPosition(currentShape.getPosition().getX(), currentShape.getPosition().getY());
                        }
                    }
                    // TODO pas fait
                    case DOWN -> {
                        if(!shapeIsNearDownWall) {

                        } else {
                            currentShape.setPosition(currentShape.getPosition().getX(), currentShape.getPosition().getY());
                        }
                    }

                }
            }
        }

        return false;
    }

}
