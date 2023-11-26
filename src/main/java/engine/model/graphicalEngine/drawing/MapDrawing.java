package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a map in a 2D space. Implement Drawing.
 * 
 * @see Drawing
 */
public class MapDrawing implements Drawing {
    /**
     * The width of the map
     */
    private double width;

    /**
     * The length of the map
     */
    private double height;

    /**
     * The color of the map
     */
    private Color color;

    /**
     * The image of the map
     */
    private Image image;

    /**
     * Constructor of MapDrawing. Draw a map with a specific width, length and color.
     *
     * @param width
     * @param height
     * @param color
     */
    public MapDrawing(double width, double height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Constructor of MapDrawing. Draw a map with a specific width, length and image.
     *
     * @param width
     * @param height
     * @param image
     */
    public MapDrawing(double width, double height, Image image) {
        this.width = width;
        this.height = height;
        this.image = image;
    }

    /**
     * Return the width of the map
     * 
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Return the height of the map
     * 
     * @return height
     */
    public double getheight() {
        return height;
    }

    /**
     * return the color of the map
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }

    @Override
    public void drawColor(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(0, 0, this.width, this.height);
    }

    @Override
    public void drawImage(GraphicsContext context) {
        context.drawImage(image, 0, 0);
    }
}
