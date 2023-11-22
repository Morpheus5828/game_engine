package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Nothing {
    private Rectangle nothing;
    private final Category type = Category.NOTHING;

    public Nothing(double x, double y, double width, double height, Kernel kernel, Image image) {
        nothing = kernel.addEntity(x,y , width, height, image, false, type, 0, 0);
    }

    public Nothing(double x, double y, double width, double height, Kernel kernel) {
        kernel.addEntity(x,y , width, height, Color.BLACK, false, type, 0, 0);}

    public Rectangle getNothing() {
        return nothing;
    }

    public Category getType() {
        return type;
    }

    public Position getPosition() {
        return nothing.getPosition();
    }


}
