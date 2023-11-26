package engine.gamePlay;

import engine.gamePlay.entity.PacGum;
import engine.model.Kernel;
import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;

class PacGumTest {
    private PacGum pacGum;

    @BeforeEach
    void setUp() {
        Kernel kernel = new Kernel(800, 800, Color.BLACK);
        pacGum = new PacGum(10, 10, 5, 5, kernel, null);
    }

    @Test
    void getPacGum() {
        assertNotNull(pacGum.getPacGum());
    }

    @Test
    void getType() {
        assertEquals(Category.PACGUM, pacGum.getType());
    }

    @Test
    void getPosition() {
        assertNotNull(pacGum.getPosition());

    }
}
