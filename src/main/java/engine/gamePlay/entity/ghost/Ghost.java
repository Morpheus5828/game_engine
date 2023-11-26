package engine.gamePlay.entity.ghost;

import engine.model.FinalShape;


public abstract class Ghost {

    private double x;
    private double y;
    protected FinalShape rectangle;
    protected double initPositionX;
    protected double initPositionY;


    public FinalShape getRectangle() {
        return rectangle;
    }

    public void reinit(){
        rectangle.reinit(initPositionX, initPositionY);
    }

}
