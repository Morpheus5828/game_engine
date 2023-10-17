package engine.model.graphicalEngine;

import engine.model.graphicalEngine.map.FactoryMap;
import engine.model.graphicalEngine.shape.FactoryShape;

import java.util.List;

public class Drawing {
    private List<FactoryShape> factoryShapeList;
    private FactoryShape shape;
    private FactoryMap map;


    public Drawing() {}

    public List<FactoryShape> getFactoryShapeList() {
        return factoryShapeList;
    }

    public void setFactoryShapeList(List<FactoryShape> factoryShapeList) {
        this.factoryShapeList = factoryShapeList;
    }

    public FactoryShape getShape() {
        return shape;
    }

    public void setShape(FactoryShape shape) {
        this.shape = shape;
    }

    public FactoryMap getMap() {
        return map;
    }

    public void setMap(FactoryMap map) {
        this.map = map;
    }
}
