package engine.gamePlay;

import engine.gamePlay.entity.Wall;
import engine.model.Kernel;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WallTest {
    private Wall wall;

    @BeforeEach
    void setUp() {
        Kernel kernel = new Kernel(800, 800, Color.BLUE);
        wall = new Wall(10, 10, 5, 5, kernel, null);
    }

    @Test
    void getPacman() {
        assertNotNull(wall.getWall());
    }

    @Test
    void getType() {
        assertEquals(Category.WALL, wall.getType());
    }

    @Test
    void getPosition() {
        assertNotNull(wall.getPosition());
    }
}
