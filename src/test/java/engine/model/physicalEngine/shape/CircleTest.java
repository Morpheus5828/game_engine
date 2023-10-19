package engine.model.physicalEngine.shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import engine.model.physicalEngine.movement.*;

public class CircleTest {

    @Test
    void testSetCenter() {
        Position pos = new Position(5, 5);
        Circle circle = new Circle(1, 1, 5);
        circle.setCenter(pos);
        assertEquals(circle.getCenter(), pos);
    }

    @Test
    void testGetCenter() {
        Position pos = new Position(10, 10);
        Circle circle = new Circle(10, 10, 5);
        assertEquals(circle.getCenter().getX(), pos.getX());
        assertEquals(circle.getCenter().getY(), pos.getY());
    }

    @Test
    void testSetIsMoving() {
        boolean bool = true;
        Circle circle = new Circle(1, 1, 10);
        circle.setMoving(bool);
        assertEquals(circle.isMoving(), bool);
    }

    @Test
    void testIsMoving() {
        Circle circle = new Circle(10, 10, 10);
        assertEquals(circle.isMoving(), false);
    }

    @Test
    void testGetRadius() {
        Circle circle = new Circle(1, 1, 15);
        assertEquals(circle.getRadius(), 15);
    }

    @Test
    void testSetRadius() {
        Circle circle = new Circle(1, 1, 15);
        double a = 10;
        circle.setRadius(a);
        assertEquals(circle.getRadius(), a);
    }
}
