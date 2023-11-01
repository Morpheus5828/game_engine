package engine;

import engine.model.Kernel;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        Kernel kernel = new Kernel();
        Scene scene = new Scene(kernel.getPlayGround(), 1000, 700);
        scene.setFill(Color.BLACK);

        stage.setScene(scene);

        stage.show();
    }



  public static void main(String[] args) {
    launch();
  }
}
