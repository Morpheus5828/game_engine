package engine.model.physicalEngine.movement;

public class Velocity {
    private double speedValue;
    private double step;
    private double distance;

    public Velocity(double step, double speedValue) {
        this.speedValue = speedValue;
        this.step = step;
    }


    public double getSpeedValue() {
        return speedValue;
    }

    public void setSpeedValue(float speedValue) {
        this.speedValue = speedValue;
    }

    public double getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
