package engine.model;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import engine.model.graphicalEngine.*;
import engine.model.graphicalEngine.drawing.*;
import engine.model.inputOutputEngine.*;
import engine.model.physicalEngine.*;
import engine.model.physicalEngine.movement.*;
import engine.model.physicalEngine.movement.Direction;
import engine.model.physicalEngine.shape.*;

public class Kernel {
    private PhysicalEngine physicalEngine;
    private GraphicalEngine graphicalEngine;
    private EventListener eventListener;

    public Kernel(double width, double height, Color color) {
        this.physicalEngine = new PhysicalEngine(width, height);
        this.graphicalEngine = new GraphicalEngine(width, height, color);
        this.eventListener = new EventListener();
        this.graphicalEngine.addEventListener(this.eventListener);
        startKeyListener();
    }

    private void startKeyListener() {
        new Thread(() -> {
            while (true) {
                try {
                    moveMainShape();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void moveMainShape() throws InterruptedException {
        if (this.graphicalEngine.isKeyIsPressed()) {
            Rectangle shape = this.physicalEngine.getMap().getShapesMoving().get(0);
            switch (this.eventListener.getCurrentDirection()) {
            case UP -> {
                clearShapesMoving();
                physicalEngine.moveEntity(shape, Direction.UP);
                drawMovingEntities();
            }
            case DOWN -> {
                clearShapesMoving();
                physicalEngine.moveEntity(shape, Direction.DOWN);
                drawMovingEntities();
            }
            case RIGHT -> {
                clearShapesMoving();
                physicalEngine.moveEntity(shape, Direction.RIGHT);
                drawMovingEntities();
            }
            case LEFT -> {
                clearShapesMoving();
                physicalEngine.moveEntity(shape, Direction.LEFT);
                drawMovingEntities();
            }
            default -> {
                break;
            }
            }
        }
    }

    public void drawMovingEntities() {
        List<Rectangle> shapesMoving = this.physicalEngine.getMap().getShapesMoving();
        for (Rectangle shape : shapesMoving) {
            RectangleDrawing rectangleDrawing = new RectangleDrawing(shape.getX(), shape.getY(), shape.getWidth(),
                    shape.getHeight(), shape.getColor());
            this.graphicalEngine.draw(rectangleDrawing);
        }
    }

    public void drawStaticEntities() {
        List<Rectangle> shapesMoving = this.physicalEngine.getMap().getShapesStatic();
        for (Rectangle shape : shapesMoving) {
            RectangleDrawing rectangleDrawing = new RectangleDrawing(shape.getX(), shape.getY(), shape.getWidth(),
                    shape.getHeight(), shape.getColor());
            this.graphicalEngine.draw(rectangleDrawing);
        }
    }

    public void clearShapesMoving() {
        for (Rectangle rectangle : this.physicalEngine.getMap().getShapesMoving())
            this.graphicalEngine.clearShape(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
                    rectangle.getHeight());
    }

    public Group getPlayGround() {
        return this.graphicalEngine.getPlayGround();
    }

    public PhysicalEngine getPhysicalEngine() {
        return physicalEngine;
    }

    public Rectangle addEntity(double x, double y, Color color, boolean isMoving, double velocityX, double velocityY) {
        Position position = new Position(x, y);
        Velocity velocity = new Velocity(velocityX, velocityY);
        Rectangle entity = this.physicalEngine.addEntity(position, color, isMoving, velocity);
        return entity;
    }
}
