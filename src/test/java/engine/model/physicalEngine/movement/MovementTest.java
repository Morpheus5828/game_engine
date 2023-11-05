package engine.model.physicalEngine.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.paint.Color;

import static org.junit.Assert.*;

public class MovementTest {
    
    private Movement movement;
    private Map map;
    private Rectangle rectangle;
    private Rectangle rectangle2;

    @BeforeEach
    public void setUp() {
        double width = 10;
        double height = 10;
        Color color = Color.YELLOW;
        boolean moving = true;
        Velocity velocity = new Velocity(10, 10);
        rectangle = new Rectangle(new Position(10,10), width, height, color, moving, velocity);
        rectangle2 = new Rectangle(new Position(20,20), width, height, color, moving, velocity);
        map = new Map(100,100);
        map.addShape(rectangle);
    }

    @Test
    public void testUpdatePositionX() {
        movement = new Movement(Direction.RIGHT);
        movement.updatePositonX(Direction.RIGHT, rectangle, map);
        assertEquals(20, rectangle.getX());
    }

    @Test
    public void testUpdatePositionY() {
        movement = new Movement(Direction.UP);
        movement.updatePositonY(Direction.UP, rectangle, map);
        assertEquals(0, rectangle.getY());
    }

    @Test
    public void testIsColliding() {
        map.addShape(rectangle2);
        movement = new Movement(Direction.RIGHT);
        assertTrue(movement.isColliding(rectangle, map, Direction.RIGHT));
        movement = new Movement(Direction.UP);
        assertTrue(movement.isColliding(rectangle, map, Direction.UP));
    }

    @Test
    public void getDirection() {
        movement = new Movement(Direction.RIGHT);
        assertEquals(Direction.RIGHT, movement.getDirection());
    }

    @Test
    public void setDirection() {
        movement = new Movement(Direction.RIGHT);
        movement.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, movement.getDirection());
    }
}
