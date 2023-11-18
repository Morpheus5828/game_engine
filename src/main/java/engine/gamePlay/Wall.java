package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Wall {
    private Rectangle wall;
    private final Category type = Category.WALL;

    public Wall(double x, double y, double width, double height, Kernel kernel, Image image) {
        this.wall = kernel.addEntity(x, y, width, height, image, true, 10, 10);
    }

    public Wall(double x, double y, double width, double height, Kernel kernel) {
        this.wall = kernel.addEntity(x, y, width, height, Color.BLUE, true, 1, 1);
    }

    public Rectangle getPacman() {
        return wall;
    }

    public Category getType() {
        return type;
    }

    public Position getPosition() {
        return wall.getPosition();
    }
}
