package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Pacman {
    private Rectangle pacman;
    private final Category type = Category.PACMAN;

    public Pacman(double x, double y, double width, double height, Kernel kernel, Image image) {
        pacman = kernel.addEntity(x, y, width, height, image, true, 10, 10);
    }

    public Pacman(double x, double y, double width, double height, Kernel kernel) {
        pacman = kernel.addEntity(x, y, width, height, Color.YELLOW, true, 1, 1);
    }

    public Rectangle getPacman() {
        return pacman;
    }

    public Category getType() {
        return type;
    }

    public Position getPosition() {
        return pacman.getPosition();
    }

}
