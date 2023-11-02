package engine.model.physicalEngine.movement;

public class Velocity {
    private double velocityX;
    private double velocityY;

    /**
     * Constructor of Velocity.
     * The velocity is basically the speed of an entity.
     * The velocity is composed of two components: velocityX and velocityY.
     * The velocityX is the speed of the entity on the x-axis.
     * The velocityY is the speed of the entity on the y-axis.
     *
     * @param velocityX
     * @param velocityY
     */

    public Velocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    /**
     * Return the velocity on the x-axis.
     * @return velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * Return the velocity on the y-axis.
     * @return velocityY
     */

    public double getVelocityY() {
        return velocityY;
    }

    /**
     * Set the velocity on the x-axis.
     * @param velocityX
     */

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * Set the velocity on the y-axis.
     * @param velocityY
     */

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * Set the velocity on the x-axis and the y-axis.
     * @param velocityX
     * @param velocityY
     */
    public void setVelocity(float velocityX, float velocityY) {
        setVelocityX(velocityX);
        setVelocityY(velocityY);
    }

    /**
     * Add a bonus to the velocity on the x-axis and the y-axis.
     * @param bonusX
     * @param bonusY
     */

    public void addVelocity(double bonusX, double bonusY) {
        setVelocityX(getVelocityX() + bonusX);
        setVelocityY(getVelocityY() + bonusY);
    }
}
