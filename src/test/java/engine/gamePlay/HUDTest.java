package engine.gamePlay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HUDTest {
    private HUD hud;

    @BeforeEach
    void setUp() {
        hud = new HUD();
    }

    @Test
    void constructorShouldSetInitialValues() {
        assertEquals(0, hud.getScore());
        assertEquals(3, hud.getLives());
    }

    @Test
    void addScoreShouldIncreaseScore() {
        int initialScore = hud.getScore();
        int addedScore = 50;

        hud.addScore(addedScore);

        assertEquals(initialScore + addedScore, hud.getScore());
    }

    @Test
    void removeLifeShouldDecreaseLives() {
        int initialLives = hud.getLives();

        hud.removeLife();

        assertEquals(initialLives - 1, hud.getLives());
    }

    @Test
    void resetShouldSetScoreAndLivesToInitialValues() {
        hud.addScore(50);
        hud.removeLife();

        hud.reset();

        assertEquals(0, hud.getScore());
        assertEquals(3, hud.getLives());
    }

    @Test
    void setScoreShouldSetScore() {
        int newScore = 100;

        hud.setScore(newScore);

        assertEquals(newScore, hud.getScore());
    }

    @Test
    void setLivesShouldSetLives() {
        int newLives = 2;

        hud.setLives(newLives);

        assertEquals(newLives, hud.getLives());
    }
}
