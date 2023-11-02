package engine.model.graphicalEngine;

import javafx.scene.canvas.GraphicsContext;

public interface Drawing {

    /**
     * Draw the object on the context
     * @param context
     */
    void draw(GraphicsContext context);
}
