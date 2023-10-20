package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Shape;

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


    public void updatePositonX(Direction direction, Shape shape, Map map) {
        if(!isColliding(shape, map, direction)){
            if (direction == Direction.RIGHT) {
                shape.setPosition(shape.getPosition().getX() + shape.getVelocity().getVelocityX(), shape.getPosition().getY());
            }
            else if (direction == Direction.LEFT) {
                shape.setPosition(shape.getPosition().getX() - shape.getVelocity().getVelocityX(), shape.getPosition().getY());
            }
        }
    }

    public void updatePositonY(Direction direction, Shape shape, Map map) {
        if (!isColliding(shape, map, direction)) {
            if (direction == Direction.UP) {
                shape.setPosition(shape.getPosition().getX(), shape.getPosition().getY() + shape.getVelocity().getVelocityY());
            }
            else if (direction == Direction.DOWN) {
                shape.setPosition(shape.getPosition().getX(), shape.getPosition().getY() - shape.getVelocity().getVelocityY());
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isColliding(Shape shape, Map map, Direction direction) {
        List<Position> apex = shape.getApex();
        for (Shape shape2 : map.getShapeList()) {
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
