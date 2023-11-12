package engine.gamePlay;

import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HUD {
    private final double windowWidth;
    private final double windowHeight;
    private int score;
    private int lives;
    private Group group;

    public HUD(double windowWidth, double windowHeight) {
        group = new Group();
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.score = 0;
        this.lives = 3;
        displayScore();

    }

    public void addScore(int score) {
        this.score += score;
    }

    public void removeLife() {
        this.lives--;
    }

    public int getScore() {
        return this.score;
    }

    public int getLives() {
        return this.lives;
    }

    public void reset() {
        this.score = 0;
        this.lives = 3;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Group getScene() {
        return this.group;
    }

    // public void displayScore

    public void displayScore() {
        Text scoreText = new Text("Score: " + this.score);
        Text livesText = new Text("Lives: " + this.lives);
        livesText.setLayoutX(windowWidth - 50);
        // HBox hbox = new HBox(scoreText, livesText);
        // hbox.setLayoutY(windowHeight);
        // group.getChildren().add(hbox);
        group.getChildren().addAll(scoreText, livesText);
    }
}
