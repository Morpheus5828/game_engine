package engine;

import engine.gamePlay.PacGum;
import engine.gamePlay.Pacman;
import engine.gamePlay.Wall;
import engine.model.Kernel;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GamePlay extends Application {
    int score = 0;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("GamePlay");
        double width = 1000;
        double height = 900;
        Kernel kernel = new Kernel(width, height, Color.BLACK);
        Pacman pacman = new Pacman(width/2, height/2,25,25 , kernel);
        PacGum pacgum = new PacGum(width/2, height/2 + 70, 25, 25, kernel);
        new Thread(() -> {
            while (true) {
                if (pacgum.getPosition() == pacman.getPosition()) {
                    System.out.println("Pacman eat PacGum");
                    score += 10;
                    System.out.println(score);
                }
            }
        }).start();


        new Wall(kernel, width, height);
        //kernel.addEntity(width/2, height/2 - 25, 25, 25, Color.PINK, false, 0, 0);
        //kernel.addEntity(width/2 + 50, height/2 - 25, 25, 25, Color.RED, false, 0, 0);
        //kernel.addEntity(width/2 - 50, height/2 - 25, 25, 25, Color.GREEN, false, 0, 0);
        //kernel.addEntity(width/2, height/2 + 40, 25, 25, Color.YELLOW, true, 10, 10);

        kernel.drawStaticEntities();
        kernel.drawMovingEntities();

        Scene scene = new Scene(kernel.getPlayGround(), width, height);
        stage.setScene(scene);
        stage.setResizable(false);
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
