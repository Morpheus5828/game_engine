package engine.model.physicalEngine.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import static org.junit.Assert.*;

public class MovementTest {

    private Movement movement;
    private Map map;
    private Rectangle rectangle;
    private Rectangle rectangle2;
    
    @BeforeEach
    public void setUp() {
        double radius = 1;
        boolean moving = true;
        Velocity velocity = new Velocity(2, 2);
        rectangle = new Rectangle(new Position(0,0), radius, radius, moving, velocity);
        rectangle2 = new Rectangle(new Position(2,2), radius, radius, moving, velocity);
        map = new Map(100,100);
        map.addShape(rectangle);
        map.addShape(rectangle2);
    }

    @Test
    public void testUpdatePositionX() {
        movement = new Movement(Direction.RIGHT);
        movement.updatePositonX(Direction.RIGHT, rectangle, map);
        assertEquals(rectangle.getPosition().getX(), 2);
    }

    @Test
    public void testUpdatePositionY() {
        movement = new Movement(Direction.UP);
        movement.updatePositonY(Direction.UP, rectangle, map);
        assertEquals(rectangle.getPosition().getY(), 2);
    }

    @Test
    public void testIsColliding() {
        movement = new Movement(Direction.RIGHT);
        assertTrue(movement.isColliding(rectangle, map, Direction.RIGHT));
        movement = new Movement(Direction.UP);
        assertTrue(movement.isColliding(rectangle, map, Direction.UP));
    }

    @Test
    public void getDirection() {
        movement = new Movement(Direction.RIGHT);
        assertEquals(movement.getDirection(), Direction.RIGHT);
    }

    @Test
    public void setDirection() {
        movement = new Movement(Direction.RIGHT);
        movement.setDirection(Direction.LEFT);
        assertEquals(movement.getDirection(), Direction.LEFT);
    }

}
