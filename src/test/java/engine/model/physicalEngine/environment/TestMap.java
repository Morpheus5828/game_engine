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

public class TestMap {
    private Map map;

    @BeforeEach
    void setUp() {
        Position position = new Position(0, 0);
        float radius = 10;
        boolean moving = true;
        Velocity velocity = new Velocity(0, 0);
        Circle circle = new Circle(position, radius, moving, velocity);
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





}
