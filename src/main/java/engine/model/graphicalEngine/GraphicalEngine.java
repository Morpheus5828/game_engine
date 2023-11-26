package engine.model.graphicalEngine;

import engine.model.graphicalEngine.drawing.Drawing;
import engine.model.graphicalEngine.drawing.MapDrawing;
import engine.model.inputOutputEngine.EventListener;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is used to represent a graphical engine. The role of the GraphicalEngine is to draw
 * the map and the entities.
 * 
 * @see GraphicsContext
 * @see Canvas
 * @see Group
 */
public class GraphicalEngine {
    private GraphicsContext playGroundGraphicsContext;
    private GraphicsContext graphicsContext;
    private Group playGround;
    private Canvas playGroundCanvas;
    private Canvas canvas;
    private boolean keyIsPressed = false;

    /**
     * Constructor of GraphicalEngine. Draw a map with a specific width, length and color.
     *
     * @param width
     * @param height
     * @param color
     */

    public GraphicalEngine(double width, double height, Color color) {
        this.playGround = new Group();
        this.playGroundCanvas = new Canvas(width, height);
        this.canvas = new Canvas(width, height);
        this.playGroundGraphicsContext = playGroundCanvas.getGraphicsContext2D();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.playGround.getChildren().add(playGroundCanvas);
        this.playGround.getChildren().add(canvas);
        drawPlayGround(width, height, color);
    }

    /**
     * Add an event listener to the canvas
     * 
     * @param movementController
     * @see EventListener
     */
    public void addEventListener(EventListener movementController) {
        this.canvas.setFocusTraversable(true);
        this.playGround.setOnKeyPressed(event -> {
            movementController.keyPressed(event.getCode().getCode());
            keyIsPressed = true;
        });
    }

    /**
     * Return if a key is pressed
     * 
     * @return boolean
     */
    public boolean isKeyIsPressed() {
        return keyIsPressed;
    }

    /**
     * Set if a key is pressed
     * 
     * @param keyIsPressed
     */
    public void setKeyIsPressed(boolean keyIsPressed) {
        this.keyIsPressed = keyIsPressed;
    }

    /**
     * Return the GraphicsContext of the canvas
     * 
     * @return GraphicsContext
     */
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    /**
     * Return the Group of the canvas
     * 
     * @return Group
     */
    public Group getPlayGround() {
        return this.playGround;
    }

    /**
     * Draw the map on the canvas
     * 
     * @param width
     * @param height
     * @param color
     * @see MapDrawing
     */

    public void drawPlayGround(double width, double height, Color color) {
        MapDrawing mapDrawing = new MapDrawing(width, height, color);
        mapDrawing.drawColor(playGroundGraphicsContext);
    }

    /**
     * Draw the entities with the color on the canvas
     * 
     * @param drawing
     * @see Drawing
     */
    public void drawColor(Drawing drawing) {
        drawing.drawColor(this.graphicsContext);
    }

    /**
     * Draw the entities with the image on the canvas
     * 
     * @param drawing
     * @see Drawing
     */
    public void drawImage(Drawing drawing) {
        drawing.drawImage(this.graphicsContext);
    }

    /**
     * Clear the canvas
     */
    public void clearShape(double x, double y, double width, double height) {
        this.graphicsContext.clearRect(x, y, width, height);
    }
}
