package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;

import java.io.FileNotFoundException;

public interface Drawing {

    /**
     * Draw the object on the context
     * @param context
     */
    void drawColor(GraphicsContext context);
    void drawImage(GraphicsContext context);
}
