package engine.model.physicalEngine.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.environment.Map;
import engine.model.physicalEngine.movement.*;

/**
 * The Rectangle class is a class that represent a rectangle. A rectangle is a shape that has a
 * Position, a length, a width, a Velocity, this rectangle can be moving or not and it can collide.
 * You can give a Direction to the rectangle to make it move where you want it to go. The rectangle
 * have a head, it's also a Position, the head will move according the direction.
 *
 * @see Position
 * @see Velocity
 * @see Direction
 */
public class Rectangle {
    /**
     * The position of the center of the rectangle.
     */
    private Position position;

    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * The height of the rectangle.
     */
    private double height;

    /**
     * True if the rectangle can move, false if not.
     */
    private boolean moving;

    /**
     * True if the rectangle can collide, false if not.
     */
    private boolean colliding;

    /**
     * The velocity of the rectangle.
     */
    private Velocity Velocity;

    /**
     * The direction of the rectangle.
     */
    private Direction direction;

    /**
     * The head of the rectangle.
     */
    private Position head;

    /**
     * Rectangle constructor. Create an object rectangle which has a Position, a length, a width, a
     * Velocity, this rectangle can be moving or not and it can collide by default. You can give a
     * Direction to the rectangle to make it move where you want it to go. The rectangle have a head,
     * it's also a Position, the head will move according the direction.
     *
     * @param position - the position of the center of the rectangle
     * @param width    - the width of the rectangle
     * @param height   - the height of the rectangle
     * @param moving   - true if the rectangle can move, false if not
     * @param velocity - the velocity of the rectangle
     */
    public Rectangle(Position position, double width, double height, boolean moving, Velocity velocity) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.moving = moving;
        this.colliding = true;
        this.Velocity = velocity;
        this.direction = Direction.NONE;
        this.head = new Position(position.getX() + height / 2, position.getY());
    }

    /**
     * Rectangle constructor. Create an object rectangle which has a Position, a length, a width, a
     * Velocity, this rectangle can be moving or not and it can collide. You can give a Direction to the
     * rectangle to make it move where you want it to go. The rectangle have a head, it's also a
     * Position, the head will move according the direction.
     *
     * @param position    - the position of the center of the rectangle
     * @param width       - the width of the rectangle
     * @param height      - the height of the rectangle
     * @param moving      - true if the rectangle can move, false if not
     * @param velocity    - the velocity of the rectangle
     * @param isColliding - true if the rectangle can collide, false if not
     */
    public Rectangle(Position position, double width, double height, boolean moving, Velocity velocity,
            boolean isColliding) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.moving = moving;
        this.colliding = isColliding;
        this.Velocity = velocity;
        this.direction = Direction.NONE;
        this.head = new Position(position.getX() + height / 2, position.getY());
    }

    /**
     * Check if the @Rectangle is out of @Map
     *
     * @param map : the @Map
     *
     * @return true if this @Rectangle touches another @Rectangle
     */
    public boolean outOfMap(Map map){
        return ( getY() < 0 || getY() > map.getHeight() || getX() < 0 || getX() > map.getWidth());
    }

    /**
     * Check if this @Rectangle touches another @Rectangle
     *
     * @param r2 : the other @Rectangle
     *
     * @return true if this @Rectangle touches another @Rectangle
     */
    public boolean isTouching(Rectangle r2){
        List<Position> apex1 = this.getApex();
        List<Position> apex2 = r2.getApex();
        if (apex1.get(2).getY() <= apex2.get(1).getY()
                    && apex1.get(2).getX() > apex2.get(1).getX()
                    && apex1.get(0).getX() < apex2.get(3).getX()
                    && apex1.get(2).getY() >= apex2.get(1).getY()) return true;
        else if(apex1.get(1).getY() >= apex2.get(0).getY()
                && apex1.get(3).getX() > apex2.get(0).getX()
                && apex1.get(1).getX() < apex2.get(2).getX()
                && apex1.get(1).getY() <= apex2.get(0).getY()) return true;
        else if(apex1.get(2).getX() >= apex2.get(0).getX()
                && apex1.get(3).getY() > apex2.get(0).getY()
                && apex1.get(2).getY() < apex2.get(1).getY()
                && apex1.get(2).getX() <= apex2.get(0).getX()) return true;
        else return apex1.get(1).getX() <= apex2.get(2).getX()
                    && apex1.get(1).getY() > apex2.get(0).getY()
                    && apex1.get(0).getY() < apex2.get(1).getY()
                    && apex1.get(1).getX() >= apex2.get(2).getX();
    }

    /**
     * Return the width of the rectangle.
     * 
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Set the width of the rectangle.
     * 
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return the height of the rectangle.
     * 
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Set the height of the rectangle.
     * 
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Create the 4 apexes of the rectangle and put them in a list. The apexes are the 4 corners of the
     * rectangle. When a rectangle is created, only the center of the rectangle is added to the Map but
     * we virtually create the other apex.
     *
     * @return a list of the Position of the 4 apexes of the rectangle
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
     * @return the Position of the head of the rectangle
     */
    public Position getHead() {
        return this.head;
    }

    /**
     * Set the head of the rectangle.
     *
     * @param position
     */
    public void setHead(Position position) {
        this.head = position;
    }

    /**
     * Give us the Position of the rectangle.
     *
     * @return the position of the rectangle
     */

    public Position getPosition() {
        return this.position;
    }

    /**
     * Change the Position of the rectangle by another Position.
     *
     * @param point
     */

    public void setPosition(Position point) {
        this.position = point;
    }

    /**
     * Set the X and/or the Y of the Position of the rectangle.
     *
     * @param x
     * @param y
     */
    public void setPosition(double x, double y) {
        this.position.setPosition(x, y);
    }

    /**
     * Return the X of the Position of the rectangle.
     *
     * @return the X of the Position of the rectangle
     */
    public double getX() {
        return this.position.getX();
    }

    /**
     * Return the Y of the Position of the rectangle.
     *
     * @return the Y of the Position of the rectangle
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
     * Return the Velocity of the rectangle.
     *
     * @return the Velocity of the rectangle
     */

    public Velocity getVelocity() {
        return this.Velocity;
    }

    /**
     * Set the Velocity of the rectangle with a new Velocity.
     *
     * @param velocity
     */

    public void setVelocity(Velocity velocity) {
        this.Velocity = velocity;
    }

    /**
     * Return the Direction of the rectangle.
     *
     * @return the Direction of the rectangle
     */

    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Set the Direction of the rectangle with a new Direction.
     *
     * @param direction
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
