package engine.model.graphicalEngine.drawing;

import javafx.scene.canvas.GraphicsContext;

/**
 * This interface is used to represent a drawing
 */
public interface Drawing {

    /**
     * Draw the object on the context with the color.
     * 
     * @param context
     */
    void drawColor(GraphicsContext context);

    /**
     * Draw the object on the context with the image.
     * 
     * @param context
     */
    void drawImage(GraphicsContext context);
}
