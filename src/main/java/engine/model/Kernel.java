package engine.model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import engine.model.graphicalEngine.*;
import engine.model.inputOutputEngine.*;
import engine.model.physicalEngine.*;
import engine.model.physicalEngine.movement.*;
import engine.model.physicalEngine.movement.Direction;
import engine.model.physicalEngine.shape.*;

public class Kernel {
    private PhysicalEngine physicalEngine;
    private GraphicalEngine graphicalEngine;
    private EventListener eventListener;
    private List<FinalShape> finalShapes;

    public Kernel(double width, double height, Color color) {
        this.physicalEngine = new PhysicalEngine(width, height);
        this.graphicalEngine = new GraphicalEngine(width, height, color);
        this.eventListener = new EventListener();
        this.graphicalEngine.addEventListener(this.eventListener);
        this.finalShapes = new ArrayList<>();
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
        for (FinalShape shape : finalShapes) {
            if (shape.getRectangle().isMoving()) {
                if(shape.getRectangleDrawing().getColor() == null)
                    this.graphicalEngine.drawImage(shape.getRectangleDrawing());
                else
                    this.graphicalEngine.drawColor(shape.getRectangleDrawing());
            }
                this.graphicalEngine.drawImage(shape.getRectangleDrawing());

        }
    }

    public void drawStaticEntities() {
        for (FinalShape shape : finalShapes) {
            if (!shape.getRectangle().isMoving())
                this.graphicalEngine.drawImage(shape.getRectangleDrawing());
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

    public void addEntity(double x, double y, double width, double height, Color color, boolean isMoving, double velocityX, double velocityY) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, color, width, height, isMoving, velocity);
        finalShape.addEntity(this.physicalEngine);
        this.finalShapes.add(finalShape);
    }


    public void addEntity(double x, double y, double width, double height, Image image, boolean isMoving, double velocityX, double velocityY) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, image, width, height, isMoving, velocity);
        finalShape.addEntity(this.physicalEngine);
        this.finalShapes.add(finalShape);
    }

}




