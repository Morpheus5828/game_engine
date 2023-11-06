package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.paint.Color;

public class SuperGum {

    private Rectangle superGum;
    private final Category type = Category.PACGUM;

    public SuperGum(double x, double y, double width, double height, Kernel kernel) {
        this.superGum = kernel.addEntity(x, y, width, height, Color.PINK, false, 10, 10);
        superGum.setColliding(false);
    }

    public Rectangle getSuperGum() {
        return superGum;
    }

    public Category getType() {
        return type;
    }

    public Position getPosition() {
        return superGum.getPosition();
    }
}
