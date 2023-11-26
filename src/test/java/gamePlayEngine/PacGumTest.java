package gamePlayEngine;

import engine.gamePlay.Category;
import engine.gamePlay.PacGum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PacGumTest {

    private PacGum pacGum;



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
