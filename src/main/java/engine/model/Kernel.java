package engine.model;

import java.util.ArrayList;
import java.util.List;

import engine.gamePlay.Category;
import engine.gamePlay.aiEngine.Graph;
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
    private FinalShape pacman;
    private FinalShape pinkGhost;
    private Graph graph;
    private double width;
    private double height;

    public Kernel(double width, double height, Color color) {
        this.width = width;
        this.height = height;
        this.physicalEngine = new PhysicalEngine(this.height, this.width);
        this.graphicalEngine = new GraphicalEngine(width, height, color);
        this.eventListener = new EventListener();
        this.graphicalEngine.addEventListener(this.eventListener);
        this.finalShapes = new ArrayList<>();
    }

    public void startKeyListener() {
        Thread pacManThread = new Thread(()-> {
            while (true) {
                try {
                    moveMainShape();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread pinkGhostThread = new Thread(()-> {
            this.graph = new Graph(550);

            //while(true) {
                try {
                    movePinkGhost();
                    //Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
           // }
        });
        pinkGhostThread.start();
        //pacManThread.start();


    }

    private void movePinkGhost() throws InterruptedException {
        this.graph.createAutomatically(
                this.finalShapes,
                this.pinkGhost
        );
        this.graph.dijkstra();
        List<FinalShape> neighbors = this.graph.getWayToGoTo(256, 32);
        for(FinalShape shape : neighbors) {
            System.out.println("step");
            if(shape.getRectangle().getX() <= this.pinkGhost.getRectangle().getX()) {
                clearShapesMoving();
                pinkGhost.moveEntity(Direction.LEFT);
                drawMovingEntities();
            }

            if(shape.getRectangle().getX() >= this.pinkGhost.getRectangle().getX()) {
                clearShapesMoving();
                pinkGhost.moveEntity(Direction.RIGHT);
                drawMovingEntities();
            }

            if(shape.getRectangle().getY() <= this.pinkGhost.getRectangle().getY()) {
                clearShapesMoving();
                pinkGhost.moveEntity(Direction.UP);
                drawMovingEntities();
            }

            if(shape.getRectangle().getY() >= this.pinkGhost.getRectangle().getY()) {
                clearShapesMoving();
                pinkGhost.moveEntity(Direction.DOWN);
                drawMovingEntities();
            }


            Thread.sleep(1000);
        }
    }

    private void moveMainShape() throws InterruptedException {
        if (this.graphicalEngine.isKeyIsPressed()) {
            switch (this.eventListener.getCurrentDirection()) {
                case UP -> {
                    clearShapesMoving();
                    pacman.moveEntity(Direction.UP);
                    drawMovingEntities();
                }
                case DOWN -> {
                    clearShapesMoving();
                    pacman.moveEntity(Direction.DOWN);
                    drawMovingEntities();
                }
                case RIGHT -> {
                    clearShapesMoving();
                    pacman.moveEntity(Direction.RIGHT);
                    drawMovingEntities();
                }
                case LEFT -> {
                    clearShapesMoving();
                    pacman.moveEntity(Direction.LEFT);
                    drawMovingEntities();
                }
                default -> {
                    break;
                }
            }
        }
    }

    public void setPacman(Rectangle shape) {
        for (FinalShape finalShape : finalShapes) {
            if (finalShape.getRectangle() == shape) {
                this.pacman = finalShape;
                return;
            }
        }
    }

    public void setPinkGhost(Rectangle shape) {
        for (FinalShape finalShape : finalShapes) {
            if (finalShape.getRectangle() == shape) {
                this.pinkGhost = finalShape;
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
        Category type, double velocityX, double velocityY) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, color, width, height, isMoving, type, velocity, this.physicalEngine);
        this.finalShapes.add(finalShape);
        return finalShape.getRectangle();
    }

    public Rectangle addEntity(double x, double y, double width, double height, Image image, boolean isMoving,
        Category type, double velocityX, double velocityY) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, image, width, height, isMoving, type, velocity, this.physicalEngine);
        this.finalShapes.add(finalShape);
        return finalShape.getRectangle();
    }

    public List<FinalShape> getFinalShapes() {
        return finalShapes;
    }

    public FinalShape getPinkGhost() {
        return pinkGhost;
    }
}
