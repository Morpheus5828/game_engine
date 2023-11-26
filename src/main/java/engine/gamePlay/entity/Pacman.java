package engine.gamePlay.entity;

import engine.gamePlay.Category;
import engine.model.FinalShape;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a pacman in the game.
 * 
 * @see FinalShape
 * @see Category
 */
public class Pacman {
    /**
     * The FinalShape of the Pacman.
     */
    private FinalShape pacman;

    /**
     * The Category of the Pacman.
     */
    private final Category type = Category.PACMAN;

    /**
     * Constructor of Pacman. Create a pacman with a specific x, y, width, height, image and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param kernel
     */
    public Pacman(double x, double y, double width, double height, Kernel kernel, Image image) {
        pacman = kernel.addEntity(x, y, width, height, image, true, 16, 16, false);
    }

    /**
     * Constructor of Pacman. Create a pacman with a specific x, y, width, height and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param kernel
     */
    public Pacman(double x, double y, double width, double height, Kernel kernel) {
        pacman = kernel.addEntity(x, y, width, height, Color.YELLOW, true, 16, 16, false);
    }

    /**
     * Get the Pacman.
     * 
     * @return FinalShape
     */
    public FinalShape getPacman() {
        return pacman;
    }

    /**
     * Get the Category of the Pacman.
     * 
     * @return Category
     */
    public Category getType() {
        return type;
    }

    /**
     * Get the Position of the Pacman.
     * 
     * @return Position
     */
    public Position getPosition() {
        return pacman.getRectangle().getPosition();
    }
}
