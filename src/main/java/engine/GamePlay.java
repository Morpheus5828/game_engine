package engine;

import engine.gamePlay.Wall;
import engine.gamePlay.aiEngine.Ghost;
import engine.model.Kernel;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GamePlay extends Application {
    private Kernel kernel;
    private engine.model.physicalEngine.shape.Rectangle yellowEntity;
    private engine.model.physicalEngine.shape.Rectangle pinkEntity;
    private final double pinkSpeed = 1.0;

    @Override
    public void start(Stage stage) {
        double width = 1000;
        double height = 900;

        kernel = new Kernel(width, height, Color.BLACK);
        yellowEntity = kernel.addEntity(width / 2, height / 2 + 40, 25, 25, Color.YELLOW, true, 10, 10);
        pinkEntity = kernel.addEntity(width / 2, height / 2 - 25, 25, 25, Color.PINK, false, 0, 0);

        new Wall(kernel, width, height);

        kernel.drawStaticEntities();
        kernel.drawMovingEntities();

        Scene scene = new Scene(kernel.getPlayGround(), width, height);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });


        startGameLoop();
    }

    private void startGameLoop() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Ghost.movePinkEntity(pinkEntity, yellowEntity, pinkSpeed);
                kernel.drawMovingEntities();
            }
        };
        timer.start();
    }



    public static void main(String[] args) {
        launch();
    }
}
