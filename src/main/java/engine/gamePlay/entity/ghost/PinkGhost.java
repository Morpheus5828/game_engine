package engine.gamePlay.entity.ghost;

import engine.model.Kernel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PinkGhost extends Ghost {
    private double x;
    private double y;

    public PinkGhost(double x, double y, double width, double height, Kernel kernel, Image image) {
        super();
        this.rectangle = kernel.addEntity(x, y, width, height, image, true, 16, 16, false);
        this.x = x;
        this.y = y;
    }

    public PinkGhost(double x, double y, double width, double height, Kernel kernel, Color color) {
        super();
        this.rectangle = kernel.addEntity(x, y, width, height, color, true, 16, 16, false);
        this.x = x;
        this.y = y;
    }

    public void IA() {

    }
}
