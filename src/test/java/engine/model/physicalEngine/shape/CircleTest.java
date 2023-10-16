package engine.model.physicalEngine.shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import engine.model.physicalEngine.shape.temp.Position;
import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    void testsetCenter() {
        Position pos = new Position(5, 5);
        Circle circle = new Circle(1, 1, 5);
        circle.setCenter(pos);
        assertEquals(circle.getCenter(), pos);
    }

    @Test
    void testgetCenter() {
        Position pos = new Position(10, 10);
        Circle circle = new Circle(10, 10, 5);
        assertEquals(circle.getCenter().getX(), pos.getX());
        assertEquals(circle.getCenter().getY(), pos.getY());
    }

    @Test
    void testsetIsMoving() {
        boolean bool = true;
        Circle circle = new Circle(1, 1, 10);
        circle.setIsMoving(bool);
        assertEquals(circle.isMoving(), bool);
    }

    @Test
    void testisMoving() {
        Circle circle = new Circle(10, 10, 10);
        assertEquals(circle.isMoving(), false);
    }

    @Test
    void testgetRadius() {
        Circle circle = new Circle(1, 1, 15);
        assertEquals(circle.getRadius(), 15);
    }
    @Test
    void testsetRadius(){
        Circle circle = new Circle(1, 1, 15);
        double a=10;
        circle.setRadius(a);
        assertEquals(circle.getRadius(),a);
    }
}
