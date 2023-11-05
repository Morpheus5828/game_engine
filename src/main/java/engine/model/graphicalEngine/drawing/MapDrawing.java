package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapDrawing implements Drawing {
    private double width;
    private double height;
    private Color color;

    /**
     * Constructor of MapDrawing
     * Draw a map with a specific width, length and color.
     * Implement the Drawing interface.
     *
     * @param width
     * @param height
     * @param color
     *
     * @see Drawing
     */

    public MapDrawing(double width, double height, Color color) {
        this.width = width;
        this.height = height;
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
    public double getheight() {
        return height;
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
        context.fillRect(0, 0, this.width, this.height);
    }
}
