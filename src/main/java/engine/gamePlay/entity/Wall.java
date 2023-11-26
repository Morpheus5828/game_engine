package engine.gamePlay.entity;

import engine.gamePlay.Category;
import engine.model.FinalShape;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a wall in the game.
 * 
 * @see FinalShape
 * @see Category
 */
public class Wall {
    /**
     * The FinalShape of the Wall.
     */
    private FinalShape wall;

    /**
     * The Category of the Wall.
     */
    private final Category type = Category.WALL;

    /**
     * Constructor of Wall. Create a wall with a specific x, y, width, height, image and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param kernel
     */
    public Wall(double x, double y, double width, double height, Kernel kernel, Image image) {
        this.wall = kernel.addEntity(x, y, width, height, image, false, 0, 0, true);
    }

    /**
     * Constructor of Wall. Create a wall with a specific x, y, width, height and kernel.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param kernel
     */
    public Wall(double x, double y, double width, double height, Kernel kernel) {
        this.wall = kernel.addEntity(x, y, width, height, Color.BLUE, false, 0, 0, true);
    }

    /**
     * Get the Wall.
     * 
     * @return FinalShape
     */
    public FinalShape getWall() {
        return wall;
    }

    /**
     * Get the Category of the Wall.
     * 
     * @return Category
     */
    public Category getType() {
        return type;
    }

    /**
     * Get the Position of the Wall.
     * 
     * @return Position
     */
    public Position getPosition() {
        return wall.getRectangle().getPosition();
    }
}
