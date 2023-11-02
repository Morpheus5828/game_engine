package engine.model.graphicalEngine;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicalEngine {
    private GraphicsContext graphicsContext;
    private Group playGround;
    private Canvas canvas;

    /**
     * Constructor of GraphicalEngine
     * The role of the GraphicalEngine is to draw the map and the entities.
     * It is also used to clear the canvas.
     * The playGround is a JavaFX object that contains the canvas.
     * The canvas is the place where the map and the entities are drawn.
     * The canvas is a JavaFX object.
     * The canvas has the width and the length of the window.
     * The GraphicsContext is the object that allows to draw on the canvas.
     * The Group is a JavaFX object that contains the canvas.
     *
     * @param width
     * @param length
     */
    public GraphicalEngine(double width, double length) {
        this.playGround = new Group();
        this.canvas = new Canvas(width, length);
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.playGround.getChildren().add(canvas);
        drawMap(width, length, Color.BLACK);
    }

    /**
     * Return the GraphicsContext of the canvas
     * @return GraphicsContext
     */
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    /**
     * Return the Group of the canvas
     * @return Group
     */

    public Group getPlayGround() {
        return this.playGround;
    }

    /**
     * Draw the map on the canvas
     * @param width
     * @param length
     * @param color
     *
     * @see MapDrawing
     */

    public void drawMap(double width, double length, Color color) {
        MapDrawing mapDrawing = new MapDrawing(width, length, color);
        draw(mapDrawing);
    }

    /**
     * Draw the entities on the canvas
     * @param drawing
     *
     * @see Drawing
     */

    public void draw(Drawing drawing) {
        drawing.draw(this.graphicsContext);
    }

    /**
     * Clear the canvas
     */

    public void clear() {
        this.graphicsContext.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
    }
}
