package gamePlayEngine;

import engine.gamePlay.Category;
import engine.gamePlay.Pacman;
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
        Kernel kernel = new Kernel(800,800, Color.BLACK);
        pacman = new Pacman(0, 0, 20, 20, kernel);
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
