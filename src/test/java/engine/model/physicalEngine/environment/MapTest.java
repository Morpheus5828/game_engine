package engine.model.physicalEngine.environment;


import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.shape.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
    private Map map;
    private Rectangle rectangle;
    private Position position;
    private Velocity velocity;
    private float length = 10;
    private float width = 4;
    private boolean moving = true;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
        velocity = new Velocity(0, 0);
        rectangle = new Rectangle(Type.PACMAN, position, length, width, moving, velocity);
        map = new Map(100,100);
        map.getShapeList().add(rectangle);
    }

    @Test
    void TestGetLength(){
        assertEquals(map.getLength(),100.00);
    }

    @Test
    void TestGetWidth(){
        assertEquals(map.getWidth(),100.00);
    }

    @Test
    void TestIsInPlan(){
        assertTrue(map.isInPlan(rectangle.getPosition()));
    }

    @Test
    void TestGetShapeList(){
        assertTrue(map.getShapeList().contains(rectangle));
    }

    @Test
    void TestShapeIsInShape(){
        Rectangle square = new Rectangle(Type.PACMAN, new Position(101,101),10,10,true,new Velocity(0,0));
        assertTrue(map.shapeIsInPlan(rectangle));
        assertFalse(map.shapeIsInPlan(square));
    }

    @Test
    void TestAddShape(){
        Rectangle square = new Rectangle(Type.PACMAN, new Position(101,101),10,10,true,new Velocity(0,0));
        Rectangle rectangle = new Rectangle(Type.PACMAN, new Position(10,10),15,10,true,new Velocity(0,0));
        map.addShape(square);
        map.addShape(rectangle);

        assertTrue(map.getShapeList().contains(rectangle));
        assertFalse(map.getShapeList().contains(square));
    }

    @Test
    void TestRemoveShape(){
        assertTrue(map.getShapeList().contains(rectangle));
        map.removeShape(rectangle);
        assertFalse(map.getShapeList().contains(rectangle));
    }





}
