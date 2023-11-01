package engine.model.graphicalEngine;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicalEngine {
    private GraphicsContext graphicsContext;
    private Group playGround;
    private Canvas canvas;

    public GraphicalEngine(double width, double length) {
        this.playGround = new Group();
        this.canvas = new Canvas(width, length);
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.playGround.getChildren().add(canvas);
        drawMap(width, length, Color.BLACK);
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public Group getPlayGround() {
        return this.playGround;
    }

    public void drawMap(double width, double length, Color color) {
        MapDrawing mapDrawing = new MapDrawing(width, length, color);
        draw(mapDrawing);
    }

    public void draw(Drawing drawing) {
        drawing.draw(this.graphicsContext);
    }

    public void clear() {
        this.graphicsContext.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
    }
}
