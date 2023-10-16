package engine.model.physicalEngine.movement;

public class Velocity {
    private float velocityX;
    private float velocityY;

    public Velocity(float velocityX, float velocityY){
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }
    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocity(float velocityX, float velocityY){
        setVelocityX(velocityX);
        setVelocityY(velocityY);
    }

    public void addVelocity(float velocityX, float velocityY){
        setVelocityX(getVelocityX() + velocityX);
        setVelocityY(getVelocityY() + velocityY);
    }
}
