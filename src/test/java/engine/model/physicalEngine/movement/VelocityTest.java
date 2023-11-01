package engine.model.physicalEngine.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VelocityTest {

    @Test
    void getVelocityX() {
        Velocity velocity = new Velocity(1, 2);
        assertEquals(1, velocity.getVelocityX());
    }

    @Test
    void getVelocityY() {
        Velocity velocity = new Velocity(1, 2);
        assertEquals(2, velocity.getVelocityY());
    }

    @Test
    void setVelocityX() {
        Velocity velocity = new Velocity(1, 2);
        velocity.setVelocityX(3);
        assertEquals(3, velocity.getVelocityX());
    }

    @Test
    void setVelocityY() {
        Velocity velocity = new Velocity(1, 2);
        velocity.setVelocityY(3);
        assertEquals(3, velocity.getVelocityY());
    }

    @Test
    void setVelocity() {
        Velocity velocity = new Velocity(1, 2);
        velocity.setVelocity(3, 4);
        assertEquals(3, velocity.getVelocityX());
        assertEquals(4, velocity.getVelocityY());
    }

    @Test
    void addVelocity() {
        Velocity velocity = new Velocity(1, 2);
        velocity.addVelocity(3, 4);
        assertEquals(4, velocity.getVelocityX());
        assertEquals(6, velocity.getVelocityY());
    }
}