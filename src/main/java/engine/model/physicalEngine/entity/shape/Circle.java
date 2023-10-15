package engine.model.physicalEngine.entity.shape;

import java.util.ArrayList;
import java.util.List;

import engine.model.physicalEngine.entity.temp.Position;

public class Circle extends AbstractShape {

    public Circle(double x, double y, double radius) {
        setCenter(new Position(x, y));
            if(radius<0){
                throw new IllegalArgumentException("le rayon ne peut pas etre negatif");
            }
            this.radius = radius;
    }

    @Override
    public List<Position> getApex() {
        List<Position> apex = new ArrayList<>();
        return apex;
    }
}
