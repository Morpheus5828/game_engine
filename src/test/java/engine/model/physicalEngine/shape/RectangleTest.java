package engine.model.physicalEngine.shape;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import engine.model.physicalEngine.shape.temp.Position;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void testgetHeight(){
        Rectangle rec=new Rectangle(1,1,10,5);
        assertEquals(rec.getWidth(),5);
    }
    @Test
    void testsetHeight(){
        Rectangle rec=new Rectangle(1,1,10,5);
        double a=10;
        rec.setWidth(a);
        assertEquals(rec.getWidth(),a);
    }
    @Test
    void testgetLength(){
        Rectangle rec=new Rectangle(1,1,10,5);
        assertEquals(rec.getLength(),10);
    }
    @Test
    void testsetLength(){
        Rectangle rec=new Rectangle(1,1,10,5);
        double a=10;
        rec.setLength(a);
        assertEquals(rec.getLength(),a);
    }
    @Test
    void testsetCenter(){
        Rectangle rec=new Rectangle(1,1,10,5);
        rec.setCenter(new Position(5,5));
        assertEquals(rec.getCenter().getX(),5);
        assertEquals(rec.getCenter().getY(),5);
    }
    @Test
    void testgetCenter(){
        Rectangle rec=new Rectangle(1,1,10,5);
        assertEquals(rec.getCenter().getX(),1);
        assertEquals(rec.getCenter().getY(),1);
    }
    @Test
    void testisMoving(){
        Rectangle rec=new Rectangle(1,1,10,5);
        assertEquals(rec.isMoving(),false);
    }
    @Test
    void testsetIsMoving(){
        Rectangle rec=new Rectangle(1,1,10,5);
        boolean bool=true;
        rec.setIsMoving(bool);
        assertEquals(rec.isMoving(),true);
    }
    @Test
    void testgetApex(){
        Rectangle rec=new Rectangle(1,1,10,5);
        List<Position> list= rec.getApex();

        assertEquals(list.get(0).getX(), -4);
        assertEquals(list.get(0).getY(), -1.5);

        assertEquals(list.get(1).getX(), -4);
        assertEquals(list.get(1).getY(), 3.5);

        assertEquals(list.get(2).getX(), 6);
        assertEquals(list.get(2).getY(), -1.5);

        assertEquals(list.get(3).getX(), -4);
        assertEquals(list.get(3).getY(), 3.5);
    }
}
