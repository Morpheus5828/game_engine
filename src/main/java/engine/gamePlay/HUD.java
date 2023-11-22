package engine.gamePlay;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HUD {
    private final double windowWidth;
    private final double windowHeight;
    private int score;
    private int lives;

    public HUD(double windowWidth, double windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.score = 0;
        this.lives = 3;
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

    public void updateScore(Parent root) {
        Text scoreField = (Text) root.lookup("#scoreField");
        scoreField.setText(String.valueOf(getScore()));
    }

    public void updateLives(Parent root) {
        Text livesField = (Text) root.lookup("#livesField");
        livesField.setText(String.valueOf(getLives()));
    }
}
