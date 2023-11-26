package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a rectangle in a 2D space. Implement Drawing.
 *
 * @see Drawing
 */
public class RectangleDrawing implements Drawing {
    /**
     * The x coordinate of the rectangle's top-left corner.
     */
    private double x;

    /**
     * The y coordinate of the rectangle's top-left corner.
     */
    private double y;

    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * The height of the rectangle.
     */
    private double height;

    /**
     * The color of the rectangle.
     */
    private Color color;

    /**
     * The image of the rectangle.
     */
    private Image image;

    /**
     * Constructor of RectangleDrawing. Draw a rectangle with a specific x, y, width, height and color.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public RectangleDrawing(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Constructor of RectangleDrawing. Draw a rectangle with a specific x, y, width, height and image.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     */
    public RectangleDrawing(double x, double y, double width, double height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    /**
     * Return the x of the rectangleDrawing
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Return the y of the rectangleDrawing
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Return the width of the rectangleDrawing
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Return the height of the rectangleDrawing
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Return the color of the rectangleDrawing
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the x of the rectangleDrawing
     * 
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set the y of the rectangleDrawing
     * 
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Set the width of the rectangleDrawing
     * 
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Set the height of the rectangleDrawing
     * 
     * @param height
     */
    public void setheight(double height) {
        this.height = height;
    }

    /**
     * Set the color of the rectangleDrawing
     * 
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Set the image of the rectangleDrawing
     */
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void drawColor(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void drawImage(GraphicsContext context) {
        context.drawImage(this.image, this.x, this.y);
    }
}
