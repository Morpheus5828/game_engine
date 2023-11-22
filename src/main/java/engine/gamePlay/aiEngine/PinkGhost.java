package engine.gamePlay.aiEngine;

import engine.gamePlay.Category;
import engine.gamePlay.Ghost;
import engine.gamePlay.Pacman;
import engine.model.Kernel;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PinkGhost {

    private double x;
    private double y;
    private Rectangle rectangle;
    //private Pacman pacman;
    private final Category type = Category.GHOST;


    public PinkGhost(double x, double y, double width, double height, Kernel kernel, Image image) {
        super();
        this.rectangle = kernel.addEntity(x,y , width, height, image, true, type, 16, 16);
        this.x = x;
        this.y = y;
    }

    public PinkGhost(double x, double y, double width, double height, Kernel kernel, Color color, Pacman pacman) {
        super();
        this.rectangle = kernel.addEntity(x,y , width, height, color, true, type, 16, 16);
        this.x = x;
        this.y = y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
