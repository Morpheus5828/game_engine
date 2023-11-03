package engine.model;

import engine.Application;
import engine.model.physicalEngine.shape.Type;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KernelTest extends Application {
    @Override
    public void start(Stage stage) {
        Kernel kernel = new Kernel();

        kernel.drawEntity();
        kernel.getPhysicalEngine().addEntity(Type.PACMAN);
        kernel.drawEntity();


        Scene scene = new Scene(kernel.getPlayGround(), 1000, 700);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

}