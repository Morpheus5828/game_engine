package gamePlayEngine;

import engine.gamePlay.Category;
import engine.gamePlay.Wall;
import engine.model.Kernel;
import javafx.scene.image.Image;
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
        wall = new Wall(10, 20, 5, 5, kernel,new Image("https://www.classicgaming.cc/classics/pac-man/icons") );
    }

    @Test
    void getPacman() {
        assertNotNull(wall.getPacman());

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
