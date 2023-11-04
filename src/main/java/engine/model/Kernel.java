package engine.model;

import java.util.ArrayList;
import java.util.List;


import engine.model.graphicalEngine.GraphicalEngine;
import engine.model.graphicalEngine.RectangleDrawing;
import engine.model.inputOutputEngine.EventListener;
import engine.model.physicalEngine.*;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.shape.Type;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Kernel {
    private PhysicalEngine physicalEngine;
    private GraphicalEngine graphicalEngine;
    private EventListener eventListener;
    private double width = 800;
    private double length = 800;


    public Kernel() {
        this.physicalEngine = new PhysicalEngine(length, width);
        this.graphicalEngine = new GraphicalEngine(length, width);
        this.eventListener = new EventListener();
        this.graphicalEngine.addEventListener(this.eventListener);
    }

    public void addMovement() throws InterruptedException {
        if(this.graphicalEngine.isPressed()) {
            var rect = this.physicalEngine.getMap().getMovingRectList().get(0);
            switch (this.eventListener.getCurrentDirection()) {
                case UP -> {
                    clear();
                    this.physicalEngine.getMap().getMovingRectList().get(0).setPosition(rect.getX(), rect.getY() - 10);
                    drawEntity();
                }
                case DOWN -> {
                    clear();
                    this.physicalEngine.getMap().getMovingRectList().get(0).setPosition(rect.getX(), rect.getY() + 10);
                    drawEntity();
                }
                case RIGHT -> {
                    clear();
                    this.physicalEngine.getMap().getMovingRectList().get(0).setPosition(rect.getX() + 10, rect.getY());
                    drawEntity();
                }
                case LEFT -> {
                    clear();
                    this.physicalEngine.getMap().getMovingRectList().get(0).setPosition(rect.getX() - 10, rect.getY());
                    drawEntity();
                }
            }
        }
    }

    public void drawEntity() {
        List<Rectangle> shapeList = this.physicalEngine.getMap().getMovingRectList();
        for (Rectangle rectangle : shapeList) {
            if(rectangle.getId() == Type.PACMAN) {
                RectangleDrawing rectangleDrawing = new RectangleDrawing(
                        rectangle.getX(),
                        rectangle.getY(),
                        rectangle.getWidth(),
                        rectangle.getLength(),
                        Color.YELLOW
                );
                this.graphicalEngine.draw(rectangleDrawing);
            } else if (rectangle.getId() == Type.GHOST) {
                RectangleDrawing rectangleDrawing = new RectangleDrawing(
                        rectangle.getX(),
                        rectangle.getY(),
                        rectangle.getWidth(),
                        rectangle.getLength(),
                        Color.BLUEVIOLET
                );
                this.graphicalEngine.draw(rectangleDrawing);
            } else if (rectangle.getId() == Type.FOOD) {
                RectangleDrawing rectangleDrawing = new RectangleDrawing(
                        rectangle.getX(),
                        rectangle.getY(),
                        rectangle.getWidth(),
                        rectangle.getLength(),
                        Color.ORANGE
                );
                this.graphicalEngine.draw(rectangleDrawing);
            } else if (rectangle.getId() == Type.STATIC) {
                RectangleDrawing rectangleDrawing = new RectangleDrawing(
                        rectangle.getX(),
                        rectangle.getY(),
                        rectangle.getWidth(),
                        rectangle.getLength(),
                        Color.BLUE
                );
                this.graphicalEngine.draw(rectangleDrawing);
            }
        }
    }


    public void clear() {
        for(Rectangle rectangle : this.physicalEngine.getMap().getMovingRectList())
            this.graphicalEngine.clear(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getLength());

    }

    public Group getPlayGround() {
        return this.graphicalEngine.getPlayGround();
    }

    public PhysicalEngine getPhysicalEngine() {
        return physicalEngine;
    }
}
