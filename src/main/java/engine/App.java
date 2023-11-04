package engine;

import engine.model.Kernel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        double width = 600;
        double height = 600;
        Kernel kernel = new Kernel(width, height, Color.BLACK);
        kernel.addEntity(50, 50, Color.YELLOW, true, 10, 10);
        kernel.drawMovingEntities();

        Scene scene = new Scene(kernel.getPlayGround(), width, height);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
