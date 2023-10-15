package engine.model.physicalEngine.movement;

public abstract class movement {

    protected Position position;
    protected float velocityX;
    protected float velocityY;


    public void Movement(float x, float y, float baseVelocity) {
        position = new Position(x, y);
        velocityX = baseVelocity;
        velocityY = baseVelocity;

    }

    public abstract void applyForce(float forceX, float forceY);

    public abstract void update(float deltaTime);
}
