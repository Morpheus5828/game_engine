package engine.model.inputOutputEngine;

import java.awt.event.KeyEvent;

public class EventListener {
    private Direction currentDirection;

    public EventListener() {
        currentDirection = Direction.NONE;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void keyPressed(int keyCode) {
        switch (keyCode) {
        case KeyEvent.VK_UP:
            currentDirection = Direction.UP;
            break;
        case KeyEvent.VK_DOWN:
            currentDirection = Direction.DOWN;
            break;
        case KeyEvent.VK_LEFT:
            currentDirection = Direction.LEFT;
            break;
        case KeyEvent.VK_RIGHT:
            currentDirection = Direction.RIGHT;
            break;
        }
    }

    public void keyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_UP && currentDirection == Direction.UP) {
            currentDirection = Direction.NONE;
        } else if (keyCode == KeyEvent.VK_DOWN && currentDirection == Direction.DOWN) {
            currentDirection = Direction.NONE;
        } else if (keyCode == KeyEvent.VK_LEFT && currentDirection == Direction.LEFT) {
            currentDirection = Direction.NONE;
        } else if (keyCode == KeyEvent.VK_RIGHT && currentDirection == Direction.RIGHT) {
            currentDirection = Direction.NONE;
        }
    }
}