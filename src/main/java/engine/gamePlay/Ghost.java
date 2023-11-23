package engine.gamePlay;

import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.paint.Color;


public abstract class Ghost {

    private double x;
    private double y;
    protected Rectangle rectangle;


    public Rectangle getRectangle() {
        return rectangle;
    }


}
