package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import java.util.List;

public class Movement {
    private Direction direction;

    public Movement(Direction direction) {
        this.direction = direction;
    }

    /*
    un mouvement est un objet qui va etre appeler par une shape pour se deplacer, donc la postion et la velocite est recupere
     dans la shape et le mouvement va juste se deplacer en fonction de la direction et de la velocite.
     */


    public void updatePositonX(Direction direction, Rectangle rectangle, Map map) {
        if(!isColliding(rectangle, map, direction)){
            if (direction == Direction.RIGHT) {
                rectangle.setPosition(rectangle.getPosition().getX() + rectangle.getVelocity().getVelocityX(), rectangle.getPosition().getY());
            }
            else if (direction == Direction.LEFT) {
                rectangle.setPosition(rectangle.getPosition().getX() - rectangle.getVelocity().getVelocityX(), rectangle.getPosition().getY());
            }
        }
    }

    public void updatePositonY(Direction direction, Rectangle rectangle, Map map) {
        if (!isColliding(rectangle, map, direction)) {
            if (direction == Direction.UP) {
                rectangle.setPosition(rectangle.getPosition().getX(), rectangle.getPosition().getY() + rectangle.getVelocity().getVelocityY());
            }
            else if (direction == Direction.DOWN) {
                rectangle.setPosition(rectangle.getPosition().getX(), rectangle.getPosition().getY() - rectangle.getVelocity().getVelocityY());
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isColliding(Rectangle rectangle, Map map, Direction direction) {
        List<Position> apex = rectangle.getApex();
        for (Rectangle shape2 : map.getShapeList()) {
            if (shape2 != rectangle) {
                List<Position> apex2 = shape2.getApex();
                for (int i = 0; i < apex.size(); i++) {
                    switch (direction){
                        case UP -> {
                            if (apex.get(i).getY() < apex2.get(i).getY() && apex.get(i).getY() + rectangle.getVelocity().getVelocityY() >= apex2.get(i).getY())
                                return true;
                        }
                        case DOWN -> {
                            if (apex.get(i).getY() > apex2.get(i).getY() && apex.get(i).getY() - rectangle.getVelocity().getVelocityY() <= apex2.get(i).getY())
                                return true;
                        }
                        case RIGHT -> {
                            if (apex.get(i).getX() < apex2.get(i).getX() && apex.get(i).getX() + rectangle.getVelocity().getVelocityX() >= apex2.get(i).getX())
                                return true;
                        }
                        case LEFT -> {
                            if (apex.get(i).getX() > apex2.get(i).getX() && apex.get(i).getX() - rectangle.getVelocity().getVelocityX() <= apex2.get(i).getX())
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
