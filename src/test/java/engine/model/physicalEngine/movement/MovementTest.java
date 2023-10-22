package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.shape.Circle;
import engine.model.physicalEngine.shape.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import engine.model.physicalEngine.environment.Map;

public class MovementTest {

    private Position middlePosition;
    private Movement movement;
    private Circle circle;
    private Rectangle rectangle;
    private Map map;
    private Velocity velocity;

    @BeforeEach
    public void init() {
        map = new Map(100, 80);
        middlePosition = new Position(50, 40);
        velocity = new Velocity(10, 10);

        circle = new Circle(middlePosition, 2, velocity);
        rectangle = new Rectangle(middlePosition, 10, 4, velocity);
    }

    @Test
    public void testGetDistance() {
        movement = new Movement(rectangle, new Position(60,40));
        assertEquals(10, movement.getDistance());
    }

    @Test
    public void testUpdatePosition() {
        movement = new Movement(rectangle, new Position(60,40));
        movement.updatePositon(map);
        assertEquals(1, movement.getJumpX());
        assertEquals(51, rectangle.getCenter().getX());

        movement = new Movement(rectangle, new Position(51,60));
        movement.updatePositon(map);
        assertEquals(2, movement.getJumpY());
        assertEquals(37,0, rectangle.getCenter().getY());


        rectangle = new Rectangle(new Position(5, 2), 0, 0, velocity); // diag right up
        movement = new Movement(rectangle, new Position(70,60));
        for(int step = 0; step < 10; step++) movement.updatePositon(map);
        assertEquals(70, Math.round(rectangle.getCenter().getX()));
        assertEquals(60, Math.round(rectangle.getCenter().getY()));

        rectangle = new Rectangle(new Position(5, 2), 0, 0, velocity); // diag right down
        movement = new Movement(rectangle, new Position(80,20));
        for(int step = 0; step < 10; step++) movement.updatePositon(map);
        assertEquals(80, Math.round(rectangle.getCenter().getX()));
        assertEquals(20, Math.round(rectangle.getCenter().getY()));

        rectangle = new Rectangle(new Position(50, 40), 0, 0, velocity); // diag left up
        movement = new Movement(rectangle, new Position(23,56));
        for(int step = 0; step < 10; step++) movement.updatePositon(map);
        assertEquals(23, Math.round(rectangle.getCenter().getX()));
        assertEquals(56, Math.round(rectangle.getCenter().getY()));

        rectangle = new Rectangle(new Position(50, 40), 0, 0, velocity); // diag left down
        movement = new Movement(rectangle, new Position(27,27));
        for(int step = 0; step < 10; step++) movement.updatePositon(map);
        assertEquals(27, Math.round(rectangle.getCenter().getX()));
        assertEquals(27, Math.round(rectangle.getCenter().getY()));

    }

    @Test
    public void testIsColliding() {
        movement = new Movement(rectangle, new Position(60,40));
        Assertions.assertFalse(movement.isColliding(map));

        velocity = new Velocity(10, 10);
        rectangle = new Rectangle(new Position(0, 0), 10, 4, velocity);
        movement = new Movement(rectangle, new Position(60,40));

        Assertions.assertTrue(movement.isColliding(map));
    }

}
