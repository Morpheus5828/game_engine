package engine.model.physicalEngine.movement;

public class Velocity {
    private double velocityX;
    private double velocityY;

    public Velocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocity(float velocityX, float velocityY) {
        setVelocityX(velocityX);
        setVelocityY(velocityY);
    }

    public void addVelocity(double bonusX, double bonusY) {
        setVelocityX(getVelocityX() + bonusX);
        setVelocityY(getVelocityY() + bonusY);
    }
}
