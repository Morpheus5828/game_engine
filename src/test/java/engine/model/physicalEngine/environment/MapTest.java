package engine.model.physicalEngine.environment;

import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(100, 100);
    }

    @Test
    void TestGetWidth() {
        assertEquals(100.00, map.getWidth());
    }

    @Test
    void testGetHeight() {
        assertEquals(100.00, map.getHeight());
    }

    @Test
    void TestIsInPlan() {
        assertTrue(map.isInPlan(new Position(50, 50)));
        assertFalse(map.isInPlan(new Position(101, 101)));
    }

    @Test
    void TestAddShape() {
        Rectangle square = new Rectangle(new Position(101, 101), 10, 10, true, new Velocity(0, 0));
        Rectangle rectangle = new Rectangle(new Position(10, 10), 15, 10, true, new Velocity(0, 0));
        map.addShape(square);
        map.addShape(rectangle);
        assertTrue(map.getShapes().contains(rectangle));
        assertFalse(map.getShapes().contains(square));
    }

    @Test
    void TestGetShapes() {
        Rectangle rectangle = new Rectangle(new Position(10, 10), 15, 10, true, new Velocity(0, 0));
        map.addShape(rectangle);
        assertTrue(map.getShapes().contains(rectangle));
    }

    @Test
    void TestGetShapesMoving() {
        Rectangle rectangle = new Rectangle(new Position(10, 10), 10, 10, true, new Velocity(0, 0));
        map.addShape(rectangle);
        assertTrue(map.getShapesMoving().contains(rectangle));
        assertFalse(map.getShapesStatic().contains(rectangle));
    }

    @Test
    void TestGetShapesStatic() {
        Rectangle rectangle = new Rectangle(new Position(10, 10), 10, 10, false, new Velocity(0, 0));
        map.addShape(rectangle);
        assertTrue(map.getShapesStatic().contains(rectangle));
        assertFalse(map.getShapesMoving().contains(rectangle));
    }

    @Test
    void TestShapeIsInPlan() {
        Rectangle rectangle = new Rectangle(new Position(10, 10), 10, 10, false, new Velocity(0, 0));
        Rectangle square = new Rectangle(new Position(101, 101), 10, 10, true, new Velocity(0, 0));
        assertTrue(map.shapeIsInPlan(rectangle));
        assertFalse(map.shapeIsInPlan(square));
    }

    @Test
    void TestRemoveShape() {
        Rectangle rectangle = new Rectangle(new Position(10, 10), 10, 10, false, new Velocity(0, 0));
        map.addShape(rectangle);
        assertTrue(map.getShapes().contains(rectangle));
        map.removeShape(rectangle);
        assertFalse(map.getShapes().contains(rectangle));
    }
}
