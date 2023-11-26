package engine.gamePlay;

import engine.gamePlay.entity.Pacman;
import engine.model.Kernel;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PacmanTest {
    private Pacman pacman;

    @BeforeEach
    void setUp() {
        Kernel kernel = new Kernel(800, 800, Color.BLACK);
        pacman = new Pacman(10, 10, 20, 20, kernel);
    }

    @Test
    void getPacman() {
        assertNotNull(pacman.getPacman());
    }

    @Test
    void getType() {
        assertEquals(Category.PACMAN, pacman.getType());
    }

    @Test
    void getPosition() {
        assertNotNull(pacman.getPosition());
    }
}
