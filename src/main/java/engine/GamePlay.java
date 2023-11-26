package engine;

import engine.gamePlay.HUD;
import engine.gamePlay.drawingMap.DrawMap;
import engine.gamePlay.drawingMap.XmlReader;
import engine.gamePlay.entity.PacGum;
import engine.gamePlay.entity.Pacman;
import engine.gamePlay.entity.ghost.Ghost;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;

/**
 * This class is used to represent the game.
 *
 * @see Application
 */
public class GamePlay extends Application {
    /**
     * The width of the window.
     */
    private double width = 800;

    /**
     * The height of the window.
     */
    private double height = 800;

    /**
     * The kernel of the game.
     */
    private Kernel kernel;

    /**
     * The HUD of the game.
     */
    private HUD HUD;
    private List<Ghost> ghostsList;
    private Pacman pacman;
    private List<PacGum> pacGumsList;
    private int scorehandler = 0;

    /**
     * Initialize the game.
     *
     * @throws Exception
     */
    public void initGame() throws Exception {
        kernel = new Kernel(width, height, Color.BLACK);

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("engine/map/levelOne.tmx");
        BufferedReader file = new BufferedReader(new InputStreamReader(inputStream));
        DrawMap map = new DrawMap(new XmlReader(file, 23, 23), kernel);
        pacGumsList = map.getPacGumsList();
        scorehandler = pacGumsList.size();
        System.out.println(scorehandler);
        ghostsList = map.getGhostsList();
        pacman = map.getPacman();
        kernel.drawStaticEntities();
        kernel.drawMovingEntities();

        HUD = new HUD();
    }

    /**
     * Update the HUD.
     *
     * @param root
     */
    public void updateHUD(Parent root) {
        int actual = scorehandler - pacGumsList.size();
        HUD.addScore(actual * 100);
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
        Text scoreField = (Text) root.lookup("#scoreField");
        scoreField.setText(String.valueOf(HUD.getScore()));
        Text livesField = (Text) root.lookup("#livesField");
        livesField.setText(String.valueOf(HUD.getLives()));
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

        new Thread(() -> {
            while (true) {
                try {
                    for (PacGum pacGum : pacGumsList) {
                          if(pacGum.getRectangle().shapeTouching(pacman.getPacman())) {
                              pacGumsList.remove(pacGum);
                              updateHUD(root);
                          }
                    }
                    if (ghostsList.get(0).getRectangle().shapeTouching(pacman.getPacman())) {
                        HUD.removeLife();
                        updateHUD(root);
                        if (HUD.getLives() > 0) {
                            pacman.reinitPacman();
                            ghostsList.get(0).reinit();
                        } else {
                            try {
                                initGame();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}
