package engine.model.physicalEngine.shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import engine.model.physicalEngine.environment.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;
import javafx.scene.paint.Color;

public class RectangleTest {
    private Rectangle rectangle;
    private Position position;
    private double height;
    private double width;
    private Color color;
    private boolean moving;
    private Velocity velocity;

    @BeforeEach
    void setUp() {
        position = new Position(10, 10);
        height = 10;
        width = 10;
        color = Color.YELLOW;
        moving = true;
        velocity = new Velocity(10, 10);
        rectangle = new Rectangle(position, width, height, moving, velocity);
    }

    @Test
    public void testOutOfMap(){
        Map map = new Map(100, 100);
        assertFalse(rectangle.outOfMap(map));
        Rectangle rectangle2 = new Rectangle(new Position(-1, 10), width, height, moving, velocity);
        assertTrue(rectangle2.outOfMap(map));
        Rectangle rectangle3 = new Rectangle(new Position(map.getWidth() + 1, 10), width, height, moving, velocity);
        assertTrue(rectangle3.outOfMap(map));
        Rectangle rectangle4 = new Rectangle(new Position(10, -1), width, height, moving, velocity);
        assertTrue(rectangle4.outOfMap(map));
        Rectangle rectangle5 = new Rectangle(new Position(10, map.getHeight() + 1), width, height, moving, velocity);
        assertTrue(rectangle5.outOfMap(map));
    }

    @Test
    public void testIsTouching(){
        Rectangle rectangle2 = new Rectangle(new Position(20, 10), width, height, moving, velocity);
        assertTrue(rectangle.isTouching(rectangle2));
        assertFalse(rectangle.isTouching(new Rectangle(new Position(40, 40), width, height, moving, velocity)));
    }

    @Test
    void testGetWidth() {
        assertEquals(10, rectangle.getWidth());
    }

    @Test
    void testSetWidth() {
        double newWidth = 15;
        rectangle.setWidth(newWidth);
        assertEquals(newWidth, rectangle.getWidth());
    }

    @Test
    void testGetHeight() {
        assertEquals(10, rectangle.getHeight());
    }

    @Test
    void testSetHeight() {
        double newHeight = 15;
        rectangle.setHeight(newHeight);
        assertEquals(newHeight, rectangle.getHeight());
    }

    @Test
    void testGetApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(5, 5));
        apex.add(new Position(5, 15));
        apex.add(new Position(15, 5));
        apex.add(new Position(15, 15));
        for (int i = 0; i < apex.size(); i++) {
            assertEquals(apex.get(i).getX(), rectangle.getApex().get(i).getX());
            assertEquals(apex.get(i).getY(), rectangle.getApex().get(i).getY());
        }
    }

    @Test
    void testGetHead() {
        assertEquals(position.getX() + height / 2, rectangle.getHead().getX());
        assertEquals(position.getY(), rectangle.getHead().getY());
    }

    @Test
    void testSetHead() {
        Position newPosition = new Position(position.getX() - height / 2, rectangle.getHead().getY());
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
        Position newPosition = new Position(10, 15);
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
        assertTrue(rectangle.isColliding());
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
