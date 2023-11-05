package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectangleDrawing implements Drawing {
    /**
     * The x coordinate of the rectangle's top-left corner.
     */
    private double x;
    /**
     * The y coordinate of the rectangle's top-left corner.
     */
    private double y;
    private double width;
    private double height;
    private Color color;
    /**
     * Constructor of RectangleDrawing
     * Use to draw a rectangle on the canvas with and implementation of @Drawing
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     *
     * @see Drawing
     */
    public RectangleDrawing(double x, double y, double width, double height, Color color) {
        this.x = x - width / 2;
        this.y = y - height / 2;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * return the x of the rectangleDrawing
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * return the y of the rectangleDrawing
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * return the width of the rectangleDrawing
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * return the height of the rectangleDrawing
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * return the color of the rectangleDrawing
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setheight(double height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * draw the rectangle on the canvas
     *
     * @param context
     *
     * @see GraphicsContext
     */
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(this.x, this.y, this.width, this.height);
    }
}
