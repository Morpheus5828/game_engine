package engine.model.graphicalEngine;

import engine.model.inputOutputEngine.EventListener;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicalEngine {
    private GraphicsContext graphicsContext;
    private Group playGround;
    private Canvas canvas;
    private boolean isPressed = false;

    public GraphicalEngine(double width, double height) {
        this.playGround = new Group();
        this.canvas = new Canvas(width, height);
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.playGround.getChildren().add(canvas);
        drawMap(width, height, Color.BLACK);
    }

    public void addEventListener(EventListener movementController) {
        this.canvas.setFocusTraversable(true);
        this.playGround.setOnKeyPressed(event -> {
            movementController.keyPressed(event.getCode().getCode());
            isPressed = true;
        });
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public Group getPlayGround() {
        return this.playGround;
    }

    public void drawMap(double width, double height, Color color) {
        MapDrawing mapDrawing = new MapDrawing(width, height, color);
        draw(mapDrawing);
    }

    public void draw(Drawing drawing) {
        drawing.draw(this.graphicsContext);
    }

    public void clear(double x, double y, double width, double height) {
        this.graphicsContext.clearRect(x, y, width, height);
    }
}
