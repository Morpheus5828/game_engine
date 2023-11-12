package engine;

import engine.gamePlay.drawingMap.DrawMap;
import engine.gamePlay.drawingMap.XmlReader;
import engine.model.Kernel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileInputStream;

public class GamePlay extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        double width = 800;
        double height = 800;
        Kernel kernel = new Kernel(width, height, Color.BLACK);

        kernel.addEntity(32*12, 32*14, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/pacman.png")), true, 10, 10);
        new DrawMap(new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23,23), kernel);

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
