package engine.model.physicalEngine.entity;

import engine.model.physicalEngine.entity.shape.Shape;
import engine.model.physicalEngine.entity.temp.Position;

public class Character extends AbstractEntity {

    public Character(Position position, double speed, double mass, boolean collisionOn, Shape shape) {
        super(position, speed, mass, collisionOn, shape);
    }
}
