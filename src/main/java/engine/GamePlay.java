package engine;

import engine.gamePlay.HUD;
import engine.gamePlay.Pacman;
import engine.gamePlay.drawingMap.DrawMap;
import engine.gamePlay.drawingMap.XmlReader;
import engine.model.Kernel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class GamePlay extends Application {
    private double width = 800;
    private double height = 800;
    private Kernel kernel;
    private HUD HUD;

    public void initGame() throws Exception {
        kernel = new Kernel(width, height, Color.BLACK);

        Pacman pacman = new Pacman(10,10 , 20, 20, kernel);

        // Pacman pacman = new Pacman(32*12, 32*14+1, 30, 30, kernel);
        kernel.setMainShape(pacman.getPacman());

        new Pacman(400, 425, 20, 20, kernel);
        new Pacman(400, 375, 20, 20, kernel);
        new Pacman(375, 375, 20, 20, kernel);
        new Pacman(375, 425, 20, 20, kernel);
        new Pacman(350, 425, 20, 20, kernel);
        new Pacman(325, 425, 20, 20, kernel);
        new Pacman(325, 400, 20, 20, kernel);
        new Pacman(325, 375, 20, 20, kernel);
        new Pacman(325, 350, 20, 20, kernel);
        new Pacman(325, 325, 20, 20, kernel);
        new Pacman(350, 325, 20, 20, kernel);
        new Pacman(375, 325, 20, 20, kernel);
        new Pacman(400, 325, 20, 20, kernel);
        new Pacman(425, 325, 20, 20, kernel);
        new Pacman(450, 325, 20, 20, kernel);
        new Pacman(450, 350, 20, 20, kernel);
        new Pacman(450, 375, 20, 20, kernel);
        new Pacman(450, 400, 20, 20, kernel);
        new Pacman(450, 425, 20, 20, kernel);
        new Pacman(425, 425, 20, 20, kernel);

        // new DrawMap(new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23, 23),
        // kernel);

        kernel.drawStaticEntities();
        kernel.drawMovingEntities();

        HUD = new HUD(width, height);
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
        Text scoreField = (Text) root.lookup("#scoreField");
        scoreField.setText(String.valueOf(HUD.getScore()));
        Text livesField = (Text) root.lookup("#livesField");
        livesField.setText(String.valueOf(HUD.getLives()));
        Scene scene = new Scene(root);

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
