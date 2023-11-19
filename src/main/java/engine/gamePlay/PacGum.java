package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PacGum {
    private Rectangle pacGum;
    private final Category type = Category.PACGUM;

    public PacGum(double x, double y, double width, double height, Kernel kernel, Image image) {
        pacGum = kernel.addEntity(x,y , width, height, image, false, 0, 0, false);
    }

    public PacGum(double x, double y, double width, double height, Kernel kernel) {
        kernel.addEntity(x,y , width, height, Color.PINK, false, 0, 0, false);}

    public Rectangle getPacGum() {
        return pacGum;
    }

    public Category getType() {
        return type;
    }

    public Position getPosition() {
        return pacGum.getPosition();
    }

}
