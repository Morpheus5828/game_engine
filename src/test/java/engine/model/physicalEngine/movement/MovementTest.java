package engine.model.physicalEngine.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;

import static org.junit.jupiter.api.Assertions.*;

public class MovementTest {

    private Movement movement;
    private Map map;
    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private Rectangle rectangle4;

    @BeforeEach
    public void setUp() {
        double width = 10;
        double height = 10;
        boolean moving = true;
        Velocity velocity = new Velocity(10, 10);
        rectangle = new Rectangle(new Position(10,10), width, height, moving, velocity);
        rectangle2 = new Rectangle(new Position(20,20), width, height, moving, velocity);
        rectangle3 = new Rectangle(new Position(19, 20), width, height, moving, velocity);
        rectangle4 = new Rectangle(new Position(20, 19), width, height, moving, velocity);
        map = new Map(100,100);
        map.addShape(rectangle);
        movement = new Movement();
    }


    //Remarque : l'axe des y est inversé
    @Test
    public void testIsColliding() {
        map.addShape(rectangle2);
        assertFalse(movement.isColliding(rectangle, map, Direction.RIGHT));
        assertFalse(movement.isColliding(rectangle, map, Direction.DOWN));
        map.removeShape(rectangle2);
        map.addShape(rectangle3);
        map.addShape(rectangle4);
        assertTrue(movement.isColliding(rectangle, map, Direction.RIGHT));
        assertTrue(movement.isColliding(rectangle, map, Direction.DOWN));
    }


    @Test
    public void testUpdatePositionX() {
        movement.updatePositonX(Direction.RIGHT, rectangle, map);
        assertEquals(20, rectangle.getX());
        movement.updatePositonX(Direction.LEFT, rectangle, map);
        assertEquals(10, rectangle.getX());
    }

    //Remarque : l'axe des y est inversé
    @Test
    public void testUpdatePositionY() {
        movement.updatePositonY(Direction.UP, rectangle, map);
        assertEquals(0, rectangle.getY());
        movement.updatePositonY(Direction.DOWN, rectangle, map);
        assertEquals(10, rectangle.getY());
    }
}
