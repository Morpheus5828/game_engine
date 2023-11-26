package engine.gamePlay;

import engine.gamePlay.entity.SuperPacGum;
import engine.model.Kernel;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SuperGumTest {
    private SuperPacGum superPacGum;

    @BeforeEach
    void setUp() {
        Kernel kernel = new Kernel(800, 800, Color.BLUE);
        superPacGum = new SuperPacGum(10, 10, 5, 5, kernel, null);
    }

    @Test
    void getSuperPacGum() {
        assertNotNull(superPacGum.getSuperPacGum());
    }

    @Test
    void getType() {
        assertEquals(Category.SUPERPACGUM, superPacGum.getType());
    }

    @Test
    void getPosition() {
        assertNotNull(superPacGum.getPosition());
    }
}
