package engine.gamePlay.entity;

import engine.gamePlay.Category;
import engine.model.FinalShape;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a void space in the game.
 * 
 * @see FinalShape
 * @see Category
 */
public class Nothing {
    /**
     * The FinalShape of the void space.
     */
    private FinalShape nothing;

    /**
     * The Category of the void space.
     */
    private final Category type = Category.NOTHING;

    /**
     * Constructor of Nothing. Create a void space with a specific x, y, width, height, image and
     * kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param kernel
     */
    public Nothing(double x, double y, double width, double height, Kernel kernel, Image image) {
        nothing = kernel.addEntity(x, y, width, height, image, false, 0, 0, false);
    }

    /**
     * Constructor of Nothing. Create a void space with a specific x, y, width, height and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param kernel
     */
    public Nothing(double x, double y, double width, double height, Kernel kernel) {
        kernel.addEntity(x, y, width, height, Color.BLACK, false, 0, 0, false);
    }

    /**
     * Get Nothing object.
     * 
     * @return FinalShape
     */
    public FinalShape getNothing() {
        return nothing;
    }

    /**
     * Get the Category of the void space.
     * 
     * @return Category
     */
    public Category getType() {
        return type;
    }

    /**
     * Get the Position of the void space.
     * 
     * @return Position
     */
    public Position getPosition() {
        return nothing.getRectangle().getPosition();
    }

}
