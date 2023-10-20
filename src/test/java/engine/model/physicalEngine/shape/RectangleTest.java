package engine.model.physicalEngine.shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class RectangleTest {
    private Rectangle rectangle;
    private Position position;
    private float length;
    private float width;
    private boolean moving;
    private Velocity velocity;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
        length = 10;
        width = 5;
        moving = true;
        velocity = new Velocity(0, 0);
        rectangle = new Rectangle(position, length, width, moving, velocity);
    }

    @Test
    void testGetLength() {
        assertEquals(10, rectangle.getLength());
    }

    @Test
    void testSetLength() {
        float newLength = 5;
        rectangle.setLength(newLength);
        assertEquals(newLength, rectangle.getLength());
    }

    @Test
    void testGetWidth() {
        assertEquals(5, rectangle.getWidth());
    }

    @Test
    void testSetWidth() {
        float newWidth = 10;
        rectangle.setWidth(newWidth);
        assertEquals(newWidth, rectangle.getWidth());
    }

    @Test
    void testGetApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(-5, -2.5f));
        apex.add(new Position(-5, 2.5f));
        apex.add(new Position(5, -2.5f));
        apex.add(new Position(-5, 2.5f));
        for (int i = 0; i < apex.size(); i++) {
            assertEquals(apex.get(i).getX(), rectangle.getApex().get(i).getX());
            assertEquals(apex.get(i).getY(), rectangle.getApex().get(i).getY());
        }
    }

    @Test
    void testGetHead() {
        assertEquals(position.getX() + length / 2, rectangle.getHead().getX());
        assertEquals(position.getY(), rectangle.getHead().getY());
    }

    @Test
    void testSetHead() {
        Position newPosition = new Position(position.getX() - length / 2, rectangle.getHead().getY());
        rectangle.setHead(newPosition);
        assertEquals(newPosition.getX(), rectangle.getHead().getX());
        assertEquals(newPosition.getY(), rectangle.getHead().getY());
    }

    @Test
    void testGetPosition() {
        assertEquals(position, rectangle.getPosition());
    }

    @Test
    void testSetPostion() {
        Position newPosition = new Position(10, 5);
        rectangle.setPosition(newPosition);
        assertEquals(newPosition, rectangle.getPosition());
    }

    @Test
    void testGetX() {
        assertEquals(position.getX(), rectangle.getPosition().getX());
    }

    @Test
    void testGetY() {
        assertEquals(position.getY(), rectangle.getPosition().getY());
    }

    @Test
    void testIsMoving() {
        assertEquals(moving, rectangle.isMoving());
    }

    @Test
    void testSetIsMoving() {
        boolean newMoving = true;
        rectangle.setMoving(newMoving);
        assertEquals(newMoving, rectangle.isMoving());
    }

    @Test
    void testIsColliding() {
        assertEquals(true, rectangle.isColliding());
    }

    @Test
    void testSetIsColliding() {
        boolean newColliding = false;
        rectangle.setColliding(newColliding);
        assertEquals(newColliding, rectangle.isColliding());
    }

    @Test
    void testGetVelocity() {
        assertEquals(velocity, rectangle.getVelocity());
    }

    @Test
    void testSetVelocity() {
        Velocity newVelocity = new Velocity(2, 3);
        rectangle.setVelocity(newVelocity);
        assertEquals(newVelocity, rectangle.getVelocity());
    }

    @Test
    void testGetDirection() {
        assertEquals(Direction.NONE, rectangle.getDirection());
    }

    @Test
    void testSetDirection() {
        Direction newDirection = Direction.RIGHT;
        rectangle.setDirection(newDirection);
        assertEquals(newDirection, rectangle.getDirection());
    }
}
