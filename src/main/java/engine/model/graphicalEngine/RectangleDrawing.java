package engine.model.graphicalEngine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectangleDrawing implements Drawing {
    private double x;
    private double y;
    private double width;
    private double length;
    private Color color;

    public RectangleDrawing(double x, double y, double width, double length, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(this.color);
        context.fillRect(this.x, this.y, this.width, this.length);
    }




}
