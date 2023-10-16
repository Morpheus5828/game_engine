package engine.model.physicalEngine.shape.temp;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y){
    this.x=x;
    this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        return "X= "+x+" Y= "+y;
    }

}
