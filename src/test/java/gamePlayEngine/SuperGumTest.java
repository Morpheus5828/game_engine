package gamePlayEngine;

import engine.gamePlay.Category;
import engine.gamePlay.SuperGum;
import engine.model.Kernel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SuperGumTest {

    private SuperGum superGum;

    @BeforeEach
    void setUp() {
        Kernel kernel = new Kernel(800,800,Color.BLUE);
        superGum = new SuperGum(10, 20, 5, 5, kernel, new Image("https://www.classicgaming.cc/classics/pac-man/icons"));
    }

    @Test
    void getSuperPacGum() {
        assertNotNull(superGum.getSuperPacGum());

    }

    @Test
    void getType() {
        assertEquals(Category.SUPERPACGUM, superGum.getType());
    }

    @Test
    void getPosition() {
        assertNotNull(superGum.getPosition());

    }

}
