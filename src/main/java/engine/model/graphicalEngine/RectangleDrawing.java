package engine.model.graphicalEngine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectangleDrawing implements Drawing {
    private double x;
    private double y;
    private double width;
    private double length;
    private Color color;

    /**
     * Constructor of RectangleDrawing
     * Use to draw a rectangle on the canvas with and implementation of @Drawing
     *
     * @param x
     * @param y
     * @param width
     * @param length
     * @param color
     *
     * @see Drawing
     */
    public RectangleDrawing(double x, double y, double width, double length, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
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
     * return the length of the rectangleDrawing
     *
     * @return length
     */

    public double getLength() {
        return length;
    }

    /**
     * return the color of the rectangleDrawing
     *
     * @return color
     */

    public Color getColor() {
        return color;
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
        context.fillRect(this.x, this.y, this.width, this.length);
    }
}
