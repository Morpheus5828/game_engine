package engine.gamePlay.entity;

import engine.gamePlay.Category;
import engine.model.FinalShape;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;

/**
 * This class is used to represent a pacgum in the game.
 * 
 * @see FinalShape
 * @see Category
 */
public class PacGum {
    /**
     * The FinalShape of the PacGum.
     */
    private FinalShape pacGum;

    /**
     * The Category of the PacGum.
     */
    private final Category type = Category.PACGUM;

    /**
     * Constructor of PacGum. Create a pac-gum with a specific x, y, width, height, image and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param kernel
     */
    public PacGum(double x, double y, double width, double height, Kernel kernel, Image image) {
        pacGum = kernel.addEntity(x, y, width, height, image, false, 0, 0, false);
    }

    /**
     * Get the PacGum.
     * 
     * @return FinalShape
     */
    public FinalShape getPacGum() {
        return pacGum;
    }

    /**
     * Get the Category of the PacGum.
     * 
     * @return Category
     */
    public Category getType() {
        return type;
    }

    /**
     * Get the Position of the PacGum.
     * 
     * @return Position
     */
    public Position getPosition() {
        return pacGum.getRectangle().getPosition();
    }
    public FinalShape getRectangle() {
        return pacGum;
    }


}
