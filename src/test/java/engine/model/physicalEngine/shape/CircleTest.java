package engine.model.physicalEngine.shape;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import engine.model.physicalEngine.shape.temp.Position;
import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    void testsetCenter(){
        Position pos1=new Position(5,5);
        Circle circle1=new Circle(1,1,5);
        circle1.setCenter(pos1);
        assertEquals(circle1.getCenter(),pos1);
    }

    @Test
    void testgetCenter(){
        Position pos2=new Position(10,10);
        Circle circle2=new Circle(10,10,5);
        assertEquals(circle2.getCenter().getX(),pos2.getX());
        assertEquals(circle2.getCenter().getY(),pos2.getY());
    }
    @Test
    void testsetIsMoving(){
        boolean bool=true;
        Circle circle1=new Circle(1,1,10);
        circle1.setIsMoving(bool);
        assertEquals(circle1.isMoving(),bool);
    }
    @Test
    void testisMoving(){
        boolean bool=true;
        Circle circle1=new Circle(10,10,10);
        circle1.setIsMoving(bool);
        assertEquals(circle1.isMoving(),true);
    }
}
