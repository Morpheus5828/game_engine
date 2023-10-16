package engine.model.physicalEngine.movement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMovement {

    private Movement movement;

    @Before
    public void setUp() {
        movement = new Movement(0.0f, 0.0f, 2.0f, 2.0f);
    }

    @Test
    public void testUpdatePositionX() {
        movement.setDirection(Direction.DROITE);
        movement.updatePositonX(movement.getDirection());
        assertEquals(2.0f, movement.position.getX());
    }

    @Test
    public void testUpdatePositionY() {
        movement.setDirection(Direction.HAUT);
        movement.updatePositonY(movement.getDirection());
        assertEquals(2.0f, movement.position.getY());
    }

    @Test
    public void testIsColliding() {

        movement.setDirection(Direction.DROITE);
                 assertTrue(movement.isColliding());
    }

}
