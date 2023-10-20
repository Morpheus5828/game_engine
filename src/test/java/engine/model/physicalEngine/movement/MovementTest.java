package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.environment.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovementTest {

    private Movement movement;
    private Map map;

    @Before
    public void setUp() {
        movement = new Movement(0.0, 0.0, 2.0, 2.0);
        map = new Map(10,10);
    }

    @Test
    public void testUpdatePositionX() {
        movement.setDirection(Direction.RIGHT);
        movement.updatePositonX(movement.getDirection(),map);
        assertEquals(2.0, movement.getPosition().getX());
    }

    @Test
    public void testUpdatePositionY() {
        movement.setDirection(Direction.UP);
        movement.updatePositonY(movement.getDirection(),map);
        assertEquals(2.0f, movement.getPosition().getY());
    }

    @Test
    public void testIsColliding() {

        movement.setDirection(Direction.RIGHT);
                 assertTrue(movement.isColliding(map,Direction.LEFT));
    }

}
