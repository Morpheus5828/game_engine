package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapDrawing implements Drawing {
    private double width;
    private double height;
    private Color color;

    public MapDrawing(double width, double height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getheight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(0, 0, this.width, this.height);
    }
}
