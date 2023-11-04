package engine;

import engine.model.Kernel;
import engine.model.physicalEngine.shape.Type;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws InterruptedException {
        Kernel kernel = new Kernel();
        kernel.getPhysicalEngine().addEntity(Type.PACMAN);
        kernel.drawEntity();
        Thread monThread = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    while(true) {
                        kernel.addMovement();
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Scene scene = new Scene(kernel.getPlayGround(), 1000, 700);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        monThread.start();
        stage.show();
    }



  public static void main(String[] args) {
    launch();
  }
}
