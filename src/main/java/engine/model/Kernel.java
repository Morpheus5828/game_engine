package engine.model;

import java.util.ArrayList;
import java.util.List;


import engine.model.graphicalEngine.GraphicalEngine;
import engine.model.graphicalEngine.RectangleDrawing;
import engine.model.physicalEngine.*;
import engine.model.physicalEngine.shape.Rectangle;
import engine.model.physicalEngine.shape.Type;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Kernel {
    private PhysicalEngine physicalEngine;
    private GraphicalEngine graphicalEngine;
    private double width = 800;
    private double length = 800;

    public Kernel() {
        this.physicalEngine = new PhysicalEngine(length, width);
        this.graphicalEngine = new GraphicalEngine(length, width);

    }

    public void addMovement() throws InterruptedException {
        for(var i = 0; ; i++) {
            this.physicalEngine.getMap().getShapeList().get(0).setPosition(i, i);
            update();
            Thread.sleep(10);
        }
    }

    public void drawEntity() {
        List<Rectangle> shapeList = this.physicalEngine.getMap().getShapeList();
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
                        Color.BLUE
                );
                this.graphicalEngine.draw(rectangleDrawing);
            }
        }
    }

    public void update() {
        clear();
        drawEntity();
    }

    public void clear() {
        for(Rectangle rectangle : this.physicalEngine.getMap().getShapeList())
            this.graphicalEngine.clear(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getLength());
    }

    public Group getPlayGround() {
        return this.graphicalEngine.getPlayGround();
    }

    public PhysicalEngine getPhysicalEngine() {
        return physicalEngine;
    }
}
