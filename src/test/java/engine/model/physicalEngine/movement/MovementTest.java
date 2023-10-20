package engine.model.physicalEngine.movement;

import engine.model.physicalEngine.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import engine.model.physicalEngine.environment.Map;

import static org.junit.Assert.*;

public class MovementTest {

    private Movement movement;
    private Map map;
    private Circle circle;
    private Circle circle2;
    @BeforeEach
    public void setUp() {
        double radius = 1;
        boolean moving = true;
        Velocity velocity = new Velocity(2, 2);
        circle = new Circle(new Position(0,0), radius, moving, velocity);
        map = new Map(100,100);
        map.addShape(circle);
    }

    @Test
    public void testUpdatePositionX() {

    }

    @Test
    public void testUpdatePositionY() {}

    @Test
    public void testIsColliding() {}

}
