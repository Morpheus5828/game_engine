package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.movement.*;

public class Rectangle {
    private Position position;
    private double width;
    private double height;
    private boolean moving;
    private boolean colliding;
    private Velocity Velocity;
    private Direction direction;
    private Position head;
    
    /**
     * Rectangle constructor.
     * Create an object rectangle which has a @Position, a length, a width, a @Velocity, this rectangle can be moving or not and if it can collide or not.
     * You can give a @Direction to the rectangle to make it move where you want it to go.
     * The rectangle have a head, it's also a @Position, the head will move according the direction so if we go right first, and then we go to the left
     * the rectangle is going to flip.
     *
     * @param position
     * @param width
     * @param height
     * @param moving
     * @param velocity
     *
     * @see Position
     * @see Velocity
     * @see Direction
     */

    public Rectangle(Position position, double width, double height, boolean moving, Velocity velocity, boolean colliding) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.moving = moving;
        this.colliding = colliding;
        this.Velocity = velocity;
        this.direction = Direction.NONE;
        this.head = new Position(position.getX() + height / 2, position.getY());
    }

    /**
     * Return the width of the rectangle.
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Set the width of the rectangle.
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return the height of the rectangle.
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Set the height of the rectangle.
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Create the 4 apexes of the rectangle and put them in a list.
     * The apexes are the 4 corners of the rectangle.
     * When a rectangle is created, only the center of the rectangle is added to the @Map but we virtually create the other apex.
     *
     *
     * @return a list of the @Position of the 4 apexes of the rectangle
     * @see Position
     */
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        apex.add(new Position(this.position.getX() - this.width / 2, this.position.getY() - this.height / 2));
        apex.add(new Position(this.position.getX() - this.width / 2, this.position.getY() + this.height / 2));
        apex.add(new Position(this.position.getX() + this.width / 2, this.position.getY() - this.height / 2));
        apex.add(new Position(this.position.getX() + this.width / 2, this.position.getY() + this.height / 2));
        return apex;
    }

    /**
     * Return the head of the rectangle.
     *
     * @return the @Position of the head of the rectangle
     * @see Position
     */
    public Position getHead() {
        return this.head;
    }

    /**
     * Set the head of the rectangle.
     *
     * @param position
     * @see Position
     */
    public void setHead(Position position) {
        this.head = position;
    }

    /**
     * Give us the @Position of the rectangle.
     *
     * @return the position of the rectangle
     * @see Position
     */

    public Position getPosition() {
        return this.position;
    }

    /**
     * Change the @Position of the rectangle by another @Position.
     *
     * @param point
     * @see Position
     */

    public void setPosition(Position point) {
        this.position = point;
    }

    /**
     * Set the X and/or the Y of the @Position of the rectangle.
     *
     * @param x
     * @param y
     * @see Position
     */
    public void setPosition(double x, double y) {
        this.position.setPosition(x, y);
    }

    /**
     * Return the X of the @Position of the rectangle.
     *
     * @return the X of the @Position of the rectangle
     * @see Position
     */
    public double getX() {
        return this.position.getX();
    }

    /**
     * Return the Y of the @Position of the rectangle.
     *
     * @return the Y of the @Position of the rectangle
     * @see Position
     */

    public double getY() {
        return this.position.getY();
    }

    /**
     * Tell you if the rectangle is moving or not.
     *
     * @return true if the rectangle is moving, false if not
     */
    public boolean isMoving() {
        return this.moving;
    }

    /**
     * Set the rectangle to moving or not.
     *
     * @param moving
     */

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * Tell you if the rectangle can collide or not.
     *
     * @return true if the rectangle can collide, false if not
     */

    public boolean isColliding() {
        return this.colliding;
    }

    /**
     * Set the rectangle to colliding or not.
     *
     * @param colliding
     */

    public void setColliding(boolean colliding) {
        this.colliding = colliding;
    }

    /**
     * Return the @Velocity of the rectangle.
     *
     * @return the @Velocity of the rectangle
     * @see Velocity
     */

    public Velocity getVelocity() {
        return this.Velocity;
    }

    /**
     * Set the @Velocity of the rectangle with a new @Velocity.
     *
     * @param velocity
     * @see Velocity
     */

    public void setVelocity(Velocity velocity) {
        this.Velocity = velocity;
    }

    /**
     * Return the @Direction of the rectangle.
     *
     * @return the @Direction of the rectangle
     * @see Direction
     */

    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Set the @Direction of the rectangle with a new @Direction.
     *
     * @param direction
     * @see Direction
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
