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

/**
 * This class is used to represent a kernel. The role of the kernel is to manage all the engines.
 *
 * @see PhysicalEngine
 * @see GraphicalEngine
 * @see EventListener
 */
public class Kernel {
    /**
     * An instance of PhysicalEngine.
     */
    private PhysicalEngine physicalEngine;

    /**
     * An instance of GraphicalEngine.
     */
    private GraphicalEngine graphicalEngine;

    /**
     * An instance of InputOutputEngine.
     */
    private EventListener eventListener;

    /**
     * A list of FinalShape.
     */
    private List<FinalShape> finalShapes;

    /**
     * The main shape. It is the shape that the user can move.
     */
    private FinalShape mainShape;

    /**
     * Constructor of Kernel. Create a kernel with a specific width, height and color.
     *
     * @param width
     * @param height
     * @param color
     */
    public Kernel(double width, double height, Color color) {
        this.physicalEngine = new PhysicalEngine(width, height);
        this.graphicalEngine = new GraphicalEngine(width, height, color);
        this.eventListener = new EventListener();
        this.graphicalEngine.addEventListener(this.eventListener);
        this.finalShapes = new ArrayList<>();
        startKeyListener();
    }

    /**
     * Starts a key listener thread that continuously moves the main shape.
     */
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

    /**
     * Moves the main shape according to the direction of the event listener.
     *
     * @throws InterruptedException
     */
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

    /**
     * Sets the main shape.
     *
     * @param shape
     */
    public void setMainShape(FinalShape shape) {
        for (FinalShape finalShape : finalShapes) {
            if (finalShape == shape) {
                this.mainShape = finalShape;
                return;
            }
        }
    }

    /**
     * Draws the moving entities on the screen. Iterates through the list of final shapes and checks if
     * the shape's rectangle is moving. If the rectangle is moving, it draws the rectangle using the
     * graphical engine. If the rectangle has a color, it draws the shape using the color. Otherwise, it
     * draws the shape using the image.
     */
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

    /**
     * Draws the static entities on the screen. Iterates through the list of final shapes and checks if
     * the shape's rectangle is moving. If the rectangle is not moving, it draws the rectangle using the
     * graphical engine. If the rectangle has a color, it draws the shape using the color. Otherwise, it
     * draws the shape using the image.
     */
    public void drawStaticEntities() {
        for (FinalShape shape : finalShapes) {
            if (!shape.getRectangle().isMoving())
                this.graphicalEngine.drawImage(shape.getRectangleDrawing());
        }
    }

    /**
     * Clears the moving entities on the screen. Iterates through the list of final shapes and checks if
     * the shape's rectangle is moving. If the rectangle is moving, it clears the rectangle using the
     * graphical engine.
     */
    public void clearShapesMoving() {
        for (FinalShape shape : finalShapes) {
            if (shape.getRectangle().isMoving()) {
                this.graphicalEngine.clearShape(shape.getRectangleDrawing().getX(), shape.getRectangleDrawing().getY(),
                        shape.getRectangleDrawing().getWidth(), shape.getRectangleDrawing().getHeight());
            }
        }
    }

    /**
     * Get the play ground of the graphical engine.
     *
     * @return Group
     */
    public Group getPlayGround() {
        return this.graphicalEngine.getPlayGround();
    }

    /**
     * Get the physical engine.
     *
     * @return PhgysicalEngine
     */
    public PhysicalEngine getPhysicalEngine() {
        return physicalEngine;
    }

    /**
     * Add a new entity to the list of final shapes. This method is used to add a new entity to the
     * game.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     * @param isMoving
     * @param velocityX
     * @param velocityY
     * @param isColliding
     * @return FinalShape
     */
    public FinalShape addEntity(double x, double y, double width, double height, Color color, boolean isMoving,
            double velocityX, double velocityY, boolean isColliding) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, color, width, height, isMoving, velocity, this.physicalEngine);
        finalShape.getRectangle().setColliding(isColliding);
        this.finalShapes.add(finalShape);
        return finalShape;
    }

    /**
     * Add a new entity to the list of final shapes. This method is used to add a new entity to the
     * game.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     * @param isMoving
     * @param velocityX
     * @param velocityY
     * @param isColliding
     * @return FinalShape
     */
    public FinalShape addEntity(double x, double y, double width, double height, Image image, boolean isMoving,
            double velocityX, double velocityY, boolean isColliding) {
        Velocity velocity = new Velocity(velocityX, velocityY);
        FinalShape finalShape = new FinalShape(x, y, image, width, height, isMoving, velocity, this.physicalEngine);
        finalShape.getRectangle().setColliding(isColliding);
        this.finalShapes.add(finalShape);
        return finalShape;
    }
}
