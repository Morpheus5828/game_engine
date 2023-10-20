package engine.model.physicalEngine.shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.model.physicalEngine.movement.*;

public class CircleTest {
    private Circle circle;
    private Position position;
    private double radius;
    private boolean moving;
    private Velocity velocity;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
        radius = 10;
        moving = true;
        velocity = new Velocity(0, 0);
        circle = new Circle(position, radius, moving, velocity);
    }

    @Test
    void testGetRadius() {
        assertEquals(10, circle.getRadius());
    }

    @Test
    void testSetRadius() {
        float newRadius = 5;
        circle.setRadius(newRadius);
        assertEquals(newRadius, circle.getRadius());
    }

    @Test
    void testGetApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(-10, 0));
        apex.add(new Position(10, 0));
        apex.add(new Position(0, -10));
        apex.add(new Position(0, 10));
        for (int i = 0; i < apex.size(); i++) {
            assertEquals(apex.get(i).getX(), circle.getApex().get(i).getX());
            assertEquals(apex.get(i).getY(), circle.getApex().get(i).getY());
        }
    }

    @Test
    void testGetHead() {
        assertEquals(position.getX() + radius / 2, circle.getHead().getX());
        assertEquals(position.getY(), circle.getHead().getY());
    }

    @Test
    void testSetHead() {
        Position newPosition = new Position(position.getX() - radius / 2, circle.getHead().getY());
        circle.setHead(newPosition);
        assertEquals(newPosition.getX(), circle.getHead().getX());
        assertEquals(newPosition.getY(), circle.getHead().getY());
    }

    @Test
    void testGetPosition() {
        assertEquals(position, circle.getPosition());
    }

    @Test
    void testSetPostion() {
        Position newPosition = new Position(10, 5);
        circle.setPosition(newPosition);
        assertEquals(newPosition, circle.getPosition());
    }

    @Test
    void testGetX() {
        assertEquals(position.getX(), circle.getPosition().getX());
    }

    @Test
    void testGetY() {
        assertEquals(position.getY(), circle.getPosition().getY());
    }

    @Test
    void testIsMoving() {
        assertEquals(moving, circle.isMoving());
    }

    @Test
    void testSetIsMoving() {
        boolean newMoving = true;
        circle.setMoving(newMoving);
        assertEquals(newMoving, circle.isMoving());
    }

    @Test
    void testIsColliding() {
        assertEquals(true, circle.isColliding());
    }

    @Test
    void testSetIsColliding() {
        boolean newColliding = false;
        circle.setColliding(newColliding);
        assertEquals(newColliding, circle.isColliding());
    }

    @Test
    void testGetVelocity() {
        assertEquals(velocity, circle.getVelocity());
    }

    @Test
    void testSetVelocity() {
        Velocity newVelocity = new Velocity(2, 3);
        circle.setVelocity(newVelocity);
        assertEquals(newVelocity, circle.getVelocity());
    }

    @Test
    void testGetDirection() {
        assertEquals(Direction.NONE, circle.getDirection());
    }

    @Test
    void testSetDirection() {
        Direction newDirection = Direction.RIGHT;
        circle.setDirection(newDirection);
        assertEquals(newDirection, circle.getDirection());
    }
}
