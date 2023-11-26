package engine.gamePlay.entity;

import engine.gamePlay.Category;
import engine.model.FinalShape;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a super pacgum in the game.
 * 
 * @see FinalShape
 * @see Category
 */
public class SuperPacGum {
    /**
     * The FinalShape of the SuperPacGum.
     */
    private FinalShape superPacGum;

    /**
     * The Category of the SuperPacGum.
     */
    private final Category type = Category.SUPERPACGUM;

    /**
     * Constructor of SuperPacGum. Create a super pac-gum with a specific x, y, width, height, image and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param kernel
     */
    public SuperPacGum(double x, double y, double width, double height, Kernel kernel, Image image) {
        superPacGum = kernel.addEntity(x, y , width, height, image, false, 0, 0, false);
    }

    /**
     * Constructor of SuperPacGum. Create a super pac-gum with a specific x, y, width, height and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param kernel
     */
    public SuperPacGum(double x, double y, double width, double height, Kernel kernel) {
        kernel.addEntity(x,y , width, height, Color.PINK, false, 0, 0, false);}

    /**
     * Get the SuperPacGum.
     * 
     * @return FinalShape
     */
    public FinalShape getSuperPacGum() {
        return superPacGum;
    }

    /**
     * Get the Category of the SuperPacGum.
     * 
     * @return Category
     */
    public Category getType() {
        return type;
    }

    /**
     * Get the Position of the SuperPacGum.
     * 
     * @return Position
     */
    public Position getPosition() {
        return superPacGum.getRectangle().getPosition();
    }
}
