package engine.model.inputOutputEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class EventListenerTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pac-Man EventListener Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        EventListener movementController = new EventListener();

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                movementController.keyPressed(e.getKeyCode());
                System.out.println("Current Direction: " + movementController.getCurrentDirection());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                movementController.keyReleased(e.getKeyCode());
                System.out.println("Current Direction: " + movementController.getCurrentDirection());
            }
        });
    }
}

