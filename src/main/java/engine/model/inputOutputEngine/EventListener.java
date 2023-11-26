package engine.model.inputOutputEngine;

import java.awt.event.KeyEvent;

/**
 * This class is used to manage the inputs of the game. It will manage the keyboard inputs.
 * 
 * @see KeyEvent
 * @see Direction
 */
public class EventListener {
    /**
     * The current direction.
     */
    private Direction currentDirection;

    /**
     * Constructor of the EventListener. The EventListener is the engine that will manage the inputs of
     * the game. It will manage the keyboard inputs.
     */
    public EventListener() {
        currentDirection = Direction.NONE;
    }

    /**
     * Return the current direction.
     * 
     * @return currentDirection
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /**
     * Get the key pressed and set the current direction.
     * 
     * @param keyCode
     */
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

    /**
     * Get the key released and set the current direction to NONE.
     * 
     * @param keyCode
     */
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