package engine.model.physicalEngine.environment;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.shape.Circle;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMap {
    private Map map;

    // @BeforeEach
    // public void init() {
    //     map = new Map(10, 10);
    // }

    // @Test
    // public void testIsInPlan() {
    //     assertFalse(map.isInPlan(22, 6));
    //     assertTrue(map.isInPlan(2, 6));
    //     assertTrue(map.isInPlan(0, 0));
    //     assertFalse(map.isInPlan(22, 60));
    //     assertFalse(map.isInPlan(2, 60));
    // }

    // @Test
    // public void testShapeIsInPlan() {
    //     Shape circle = new Circle(5, 5, 2);
    //     assertTrue(map.isShapeInPlan(circle));
    //     circle = new Circle(2, 2, 1);
    //     assertTrue(map.isShapeInPlan(circle));
    //     circle = new Circle(0, 0, 1);
    //     assertFalse(map.isShapeInPlan(circle));
    //     circle = new Circle(5, 5, 10);
    //     assertFalse(map.isShapeInPlan(circle));

    //     Shape rectangle = new Rectangle(5, 5, 2, 3);
    //     assertTrue(map.isShapeInPlan(rectangle));
    //     rectangle = new Rectangle(2, 2, 1, 2);
    //     assertTrue(map.isShapeInPlan(rectangle));
    //     rectangle = new Rectangle(0, 0, 1, 5);
    //     assertFalse(map.isShapeInPlan(rectangle));
    //     rectangle = new Rectangle(5, 5, 20, 20);
    //     assertFalse(map.isShapeInPlan(rectangle));
    // }

    // @Test
    // public void testAddShape() {
    //     Shape circle = new Circle(5, 5, 2);
    //     assertEquals(0, map.getShapeList().size());
    //     map.addShape(circle);
    //     assertEquals(1, map.getShapeList().size());
    // }

    // @Test
    // public void testRemoveShape() {
    //     Shape circle = new Circle(5, 5, 2);
    //     map.addShape(circle);
    //     assertEquals(1, map.getShapeList().size());
    //     map.removeShape(circle);
    //     assertEquals(0, map.getShapeList().size());
    // }



}
