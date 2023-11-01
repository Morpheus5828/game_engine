package engine.model.graphicalEngineAnis;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapDrawing implements Drawing {
    private double width;
    private double length;
    private Color color;

    public MapDrawing(double width, double length, Color color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(0, 0, this.width, this.length);
    }
}
