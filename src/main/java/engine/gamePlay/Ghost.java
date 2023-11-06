package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;

import java.awt.*;

public abstract class Ghost {
    private final Category type = Category.GHOST;
    private Rectangle ghost;

    public Ghost(double x, double y, double width, double height, Color color, Kernel kernel) {
        ghost = kernel.addEntity(x, y, width, height, color, true, 10, 10);
    }

    public Rectangle getGhost() {
        return ghost;
    }

    public Category getType() {
        return type;
    }

    public abstract void IA();

    public Position getPosition() {
        return ghost.getPosition();
    }


}
