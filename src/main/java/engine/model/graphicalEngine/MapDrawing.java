package engine.model.graphicalEngine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapDrawing implements Drawing {
    private double width;
    private double length;
    private Color color;

    /**
     * Constructor of MapDrawing
     * Draw a map with a specific width, length and color.
     * Implement the Drawing interface.
     *
     * @param width
     * @param length
     * @param color
     *
     * @see Drawing
     */
    public MapDrawing(double width, double length, Color color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    /**
     * return the width of the map
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * return the length of the map
     * @return length
     */

    public double getLength() {
        return length;
    }

    /**
     * return the color of the map
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Draw the map with a specific width, length and color
     * @param context
     */
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(0, 0, this.width, this.length);
    }
}
