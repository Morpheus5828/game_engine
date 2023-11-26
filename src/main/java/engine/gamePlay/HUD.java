package engine.gamePlay;

import javafx.scene.Parent;
import javafx.scene.text.Text;

/**
 * This class is used to represent the HUD of the game.
 */
public class HUD {
    /**
     * The score of the game.
     */
    private int score;

    /**
     * The number of lives of the player.
     */
    private int lives;

    /**
     * Constructor of HUD.
     */
    public HUD() {
        this.score = 0;
        this.lives = 3;
    }

    /**
     * Add a score to the current score.
     * 
     * @param score
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * Remove a life to the current number of lives. If the number of lives is less than 0, the game is reset.
     */
    public void removeLife() {
        this.lives--;
        if (this.lives < 0)
            reset();
    }

    /**
     * Return the current score.
     * 
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Return the current number of lives.
     * 
     * @return lives
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Reset the score and the number of lives.
     */
    public void reset() {
        this.score = 0;
        this.lives = 3;
    }

    /**
     * Set the score.
     * 
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Set the number of lives.
     * 
     * @param lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Update the score on the screen.
     * 
     * @param root
     */
    public void updateScore(Parent root) {
        Text scoreField = (Text) root.lookup("#scoreField");
        scoreField.setText(String.valueOf(getScore()));
    }

    /**
     * Update the number of lives on the screen.
     * 
     * @param root
     */
    public void updateLives(Parent root) {
        Text livesField = (Text) root.lookup("#livesField");
        livesField.setText(String.valueOf(getLives()));
    }
}
