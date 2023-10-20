package engine.model.physicalEngine.environment;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Circle;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestMap {
    private Map map;
    private Circle circle;

    @BeforeEach
    void setUp() {
        Position position = new Position(0, 0);
        float radius = 10;
        boolean moving = true;
        Velocity velocity = new Velocity(0, 0);
        circle = new Circle(position, radius, moving, velocity);
        map = new Map(100,100);
        map.getShapeList().add(circle);
    }

    @Test
    void TestGetLenght(){
        assertEquals(map.getLength(),100.00);
    }

    @Test
    void TestGetWidth(){
        assertEquals(map.getWidth(),100.00);
    }

    @Test
    void TestIsInPlan(){
        assertTrue(map.isInPlan(circle.getPosition()));
    }

    @Test
    void TestGetShapeList(){
        assertThat(map.getShapeList().contains(circle));
    }

    @Test
    void TestShapeIsInShape(){
        Rectangle square = new Rectangle(new Position(101,101),10,10,true,new Velocity(0,0));
        assertTrue(map.shapeIsInPlan(circle));
        assertFalse(map.shapeIsInPlan(square));
    }


    @Test
    void TestAddShape(){
        Rectangle square = new Rectangle(new Position(101,101),10,10,true,new Velocity(0,0));
        Rectangle rectangle = new Rectangle(new Position(10,10),15,10,true,new Velocity(0,0));
        map.addShape(square);
        map.addShape(rectangle);

        assertTrue(map.getShapeList().contains(rectangle));
        assertFalse(map.getShapeList().contains(square));
    }

    @Test
    void TestRemoveShape(){
        assertTrue(map.getShapeList().contains(circle));
        map.removeShape(circle);
        assertFalse(map.getShapeList().contains(circle));
    }





}
