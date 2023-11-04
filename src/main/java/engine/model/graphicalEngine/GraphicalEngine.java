package engine.model.graphicalEngine;

import engine.model.graphicalEngine.drawing.Drawing;
import engine.model.graphicalEngine.drawing.MapDrawing;
import engine.model.inputOutputEngine.EventListener;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicalEngine {
    private GraphicsContext graphicsContext;
    private Group playGround;
    private Canvas canvas;
    private boolean keyIsPressed = false;

    public GraphicalEngine(double width, double height) {
        this.playGround = new Group();
        this.canvas = new Canvas(width, height);
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.playGround.getChildren().add(canvas);
        drawPlayGround(width, height, Color.BLACK);
    }

    public void addEventListener(EventListener movementController) {
        this.canvas.setFocusTraversable(true);
        this.playGround.setOnKeyPressed(event -> {
            movementController.keyPressed(event.getCode().getCode());
            keyIsPressed = true;
        });
    }

    public boolean isKeyIsPressed() {
        return keyIsPressed;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public Group getPlayGround() {
        return this.playGround;
    }

    public void drawPlayGround(double width, double height, Color color) {
        MapDrawing mapDrawing = new MapDrawing(width, height, color);
        draw(mapDrawing);
    }

    public void draw(Drawing drawing) {
        drawing.draw(this.graphicsContext);
    }

    public void clearShape(double x, double y, double width, double height) {
        x = x - width / 2;
        y = y - height / 2;
        this.graphicsContext.clearRect(x, y, width, height);
    }
}
