package engine;

import engine.gamePlay.HUD;
import engine.gamePlay.drawingMap.DrawMap;
import engine.gamePlay.drawingMap.XmlReader;
import engine.model.Kernel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class GamePlay extends Application {
    private static double width = 800;
    private static double height = 800;
    private static Kernel kernel;
    private static HUD HUD;

    public void initGame() throws Exception {
        kernel = new Kernel(width, height, Color.BLACK);

        new DrawMap(new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23, 23), kernel);

        kernel.drawStaticEntities();
        kernel.drawMovingEntities();

        HUD = new HUD(width, height);
    }

    public void updateHUD(Parent root) {
        HUD.updateScore(root);
        HUD.updateLives(root);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initGame();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("engine/engine.fxml"));
        root.getStylesheets().add(getClass().getClassLoader().getResource("engine/engine.css").toExternalForm());
        VBox mainVBox = (VBox) root.lookup("#mainVBox");
        mainVBox.prefWidth(width);
        mainVBox.prefHeight(height);
        AnchorPane playGround = (AnchorPane) root.lookup("#playGround");
        playGround.getChildren().add(kernel.getPlayGround());
        Scene scene = new Scene(root);

        updateHUD(root);

        stage.setTitle("Pacman");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
