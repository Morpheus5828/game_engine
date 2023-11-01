package engine.model.physicalEngine.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void getX() {
        Position position = new Position(0, 0);
        assertEquals(0, position.getX());
    }

    @Test
    void getY() {
        Position position = new Position(0, 0);
        assertEquals(0, position.getY());
    }

    @Test
    void setX() {
        Position position = new Position(0, 0);
        position.setX(1);
        assertEquals(1, position.getX());
    }

    @Test
    void setY() {
        Position position = new Position(0, 0);
        position.setY(1);
        assertEquals(1, position.getY());
    }

    @Test
    void setPosition() {
        Position position = new Position(0, 0);
        position.setPosition(1, 1);
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
    }
}