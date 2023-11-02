package engine.model.physicalEngine.movement;

public class Position {
    private double x;
    private double y;

    /**
     * Constructor of Position
     * Create an object position with x and y coordinates.
     * That can be easily used to represent a point in a 2D space.
     *
     * @param x
     * @param y
     */

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the x coordinate of the position
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * return the y coordinate of the position
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * set the x coordinate of the position
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * set the y coordinate of the position
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * set the x and y coordinates of the position
     * @param x
     * @param y
     */
    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }
}
