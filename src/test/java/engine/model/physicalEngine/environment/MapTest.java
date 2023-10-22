package engine.model.physicalEngine.environment;


import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Circle;
import engine.model.physicalEngine.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map map;
    private Position position1;
    private Position position2;
    private Position position3;
    private Circle circle;
    private Rectangle rectangle;
    private Velocity velocity;

    @BeforeEach
    public void init() {
        map = new Map(100,100);
        position1 = new Position(2, 4);
        position2 = new Position(50, 80);
        position3 = new Position(17, 28);
        velocity = new Velocity(0.1, 5);
        circle = new Circle(position1, 2, velocity);
        rectangle = new Rectangle(position3, 10, 4, velocity);
    }


    @Test
    public void testIsShapeInPlan(){
        assertTrue(map.isShapeInPlan(circle));
        circle.setCenter(new Position(120, 4));
        assertFalse(map.isShapeInPlan(circle));
    }


    @Test
    public void testIsInPlan(){
        assertFalse(map.isInPlan(20, 400));
        assertFalse(map.isInPlan(-3, 4));
        assertFalse(map.isInPlan(200, 40));
        assertFalse(map.isInPlan(0, -3));
        assertTrue(map.isInPlan(4, 3));
        assertTrue(map.isInPlan(2, 3));
        assertTrue(map.isInPlan(1, 0));
        assertTrue(map.isInPlan(1, 2));
    }


    @Test
    public void testAddShape(){
        map.addShape(circle);
        map.addShape(rectangle);
        assertTrue(map.getShapeList().contains(rectangle));
        assertTrue(map.getShapeList().contains(circle));
    }

    @Test
    void testRemoveShape(){
        map.addShape(circle);
        map.addShape(rectangle);
        map.removeShape(circle);
        map.removeShape(rectangle);
        assertFalse(map.getShapeList().contains(rectangle));
        assertFalse(map.getShapeList().contains(circle));
    }





}
