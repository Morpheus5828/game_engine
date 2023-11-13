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
    private FinalShape mainShape;

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
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void moveMainShape() throws InterruptedException {
        if (this.graphicalEngine.isKeyIsPressed()) {
            switch (this.eventListener.getCurrentDirection()) {
                case UP -> {
                    clearShapesMoving();
                    mainShape.moveEntity(Direction.UP);
                    drawMovingEntities();
                }
                case DOWN -> {
                    clearShapesMoving();
                    mainShape.moveEntity(Direction.DOWN);
                    drawMovingEntities();
                }
                case RIGHT -> {
                    clearShapesMoving();
                    mainShape.moveEntity(Direction.RIGHT);
                    drawMovingEntities();
                }
                case LEFT -> {
                    clearShapesMoving();
                    mainShape.moveEntity(Direction.LEFT);
                    drawMovingEntities();
                }
                default -> {
                    break;
                }
            }
        }
    }

    public void setMainShape(Rectangle shape) {
        for (FinalShape finalShape : finalShapes) {
            if (finalShape.getRectangle() == shape) {
                this.mainShape = finalShape;
                return;
            }
        }
    }

    public void drawMovingEntities() {
        for (FinalShape shape : finalShapes) {
            if (shape.getRectangle().isMoving()) {
                if (shape.getRectangleDrawing().getColor() == null)
                    this.graphicalEngine.drawImage(shape.getRectangleDrawing());
                else {
                    this.graphicalEngine.drawColor(shape.getRectangleDrawing());
                }
            }
        }
    }

    public void drawStaticEntities() {
        for (FinalShape shape : finalShapes) {
            if (!shape.getRectangle().isMoving())
                this.graphicalEngine.drawImage(shape.getRectangleDrawing());
        }
    }

    public void clearShapesMoving() {
        for (FinalShape shape : finalShapes) {
            if (shape.getRectangle().isMoving()) {
                this.graphicalEngine.clearShape(
                        shape.getRectangleDrawing().getX(),
                        shape.getRectangleDrawing().getY(),
                        shape.getRectangleDrawing().getWidth(),
                        shape.getRectangleDrawing().getHeight()
                );
            }
        }
    }

    public Group getPlayGround() {
        return this.graphicalEngine.getPlayGround();
    }

    public PhysicalEngine getPhysicalEngine() {
        return physicalEngine;
    }

    public Rectangle addEntity(double x, double y, double width, double height, Color color, boolean isMoving,
            double velocityX, double velocityY) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, color, width, height, isMoving, velocity, this.physicalEngine);
        this.finalShapes.add(finalShape);
        return finalShape.getRectangle();
    }

    public Rectangle addEntity(double x, double y, double width, double height, Image image, boolean isMoving,
            double velocityX, double velocityY) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, image, width, height, isMoving, velocity, this.physicalEngine);
        this.finalShapes.add(finalShape);
        return finalShape.getRectangle();
    }

}
