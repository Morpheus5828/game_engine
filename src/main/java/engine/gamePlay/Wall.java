package engine.gamePlay;

import engine.model.Kernel;
import javafx.scene.paint.Color;

public class Wall {
    private Kernel kernel;
    private double width;
    private double height;

    public Wall(Kernel kernel, double width, double height) {
        this.kernel = kernel;
        this.width = width;
        this.height = height;
        drawAroundWall();
        drawCentralWall();
        drawForm();
        drawCornerSquare();
        drawElbow();
        drawSquare();
        //drawLines();
        drawT();
    }

    public void drawAroundWall() {
        this.kernel.addEntity(this.width/2, 25, this.width-50, 25, Color.BLUE, false, 0, 0); // up
        this.kernel.addEntity(this.width/2, this.height-25, this.width-50, 25, Color.BLUE, false, 0, 0); // down
        this.kernel.addEntity(25, this.height/2, 25, this.height-25, Color.BLUE, false, 0, 0); // left
        this.kernel.addEntity(this.width-25, this.height/2, 25, this.height-25, Color.BLUE, false, 0, 0); // right
    }

    public void drawCentralWall() {
        this.kernel.addEntity(this.width/2, this.height/2, 150, 25, Color.BLUE, false, 0, 0); // down
        this.kernel.addEntity(this.width/2, this.height/2-99, 150, 25, Color.WHITE, false, 0, 0); // up
        this.kernel.addEntity(this.width/2 + 75, this.height/2 - 50, 25, 125, Color.BLUE, false, 0, 0); // left
        this.kernel.addEntity(this.width/2 - 75, this.height/2 - 50, 25, 125, Color.BLUE, false, 0, 0); // right
    }

    public void drawForm() {
        this.kernel.addEntity(75, this.height - 175, 75, 25, Color.BLUE, false, 0, 0);  // left down
        this.kernel.addEntity(150, this.height - 75, 25, 100, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(75, 175, 75, 25, Color.BLUE, false, 0, 0);  // left up
        this.kernel.addEntity(150, 75, 25, 100, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width - 75, this.height - 175, 75, 25, Color.BLUE, false, 0, 0);  // right down
        this.kernel.addEntity(this.width - 150, this.height - 75, 25, 100, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width - 75, 175, 75, 25, Color.BLUE, false, 0, 0);  // right up
        this.kernel.addEntity(this.width - 150, 75, 25, 100, Color.BLUE, false, 0, 0);
    }


    public void drawCornerSquare() {
        this.kernel.addEntity(75, this.height / 2 + 150, 125, 25, Color.BLUE, false, 0, 0);  // left down
        this.kernel.addEntity(150, this.height / 2 + 180, 25, 85, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(75, this.height / 2 - 150, 125, 25, Color.BLUE, false, 0, 0);  // left up
        this.kernel.addEntity(150, this.height / 2 - 175, 25, 75, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width - 75, this.height / 2 + 150, 125, 25, Color.BLUE, false, 0, 0);  // right down
        this.kernel.addEntity(this.width - 150, this.height / 2 + 175, 25, 75, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width - 75, this.height / 2 - 150, 125, 25, Color.BLUE, false, 0, 0);  // right up
        this.kernel.addEntity(this.width - 150, this.height / 2 - 175, 25, 75, Color.BLUE, false, 0, 0);

    }

    public void drawElbow() {
        this.kernel.addEntity(145, this.height / 2 + 90, 125, 25, Color.BLUE, false, 0, 0);  // left down
        this.kernel.addEntity(215, this.height / 2 + 150, 25, 145, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(145, this.height / 2 - 90, 125, 25, Color.BLUE, false, 0, 0);  // left up
        this.kernel.addEntity(215, this.height / 2 - 150, 25, 135, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width - 145, this.height / 2 - 90, 125, 25, Color.BLUE, false, 0, 0);  // right up
        this.kernel.addEntity(this.width - 215, this.height / 2 - 145, 25, 135, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width - 145, this.height / 2 + 90, 125, 25, Color.BLUE, false, 0, 0);  // right down
        this.kernel.addEntity(this.width - 215, this.height / 2 + 145, 25, 135, Color.BLUE, false, 0, 0);
    }


    public void drawSquare() {
        this.kernel.addEntity(this.width/2 + 125, this.height/2 + 125, 25, 100, Color.RED, false, 0, 0);


    }

    public void drawLines() {
        /*
        for(int i = 0; i < 225; i+=25)
            this.kernel.addEntity(this.width/2 -100 +i, this.height/2 - 175, Color.BLUE, false, 0, 0);
        for(int i = 0; i < 225; i+=25)
            this.kernel.addEntity(this.width/2 -100 +i, this.height/2 + 75, Color.BLUE, false, 0, 0);
        for(int i = 0; i < 75; i+=25)
            this.kernel.addEntity(this.width/2, this.height - i -25, Color.BLUE, false, 0, 0);

         */
    }

    public void drawT() {
        this.kernel.addEntity(this.width/2 - 215, this.height/2 + 175, 25, 180, Color.BLUE, false, 0, 0); // left down
        this.kernel.addEntity(this.width/2 - 215, this.height/2 + 275, 175, 25, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width/2 - 215, this.height/2 - 175, 25, 180, Color.BLUE, false, 0, 0); // left up
        this.kernel.addEntity(this.width/2 - 215, this.height/2 - 275, 175, 25, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width/2 + 215, this.height/2 + 175, 25, 180, Color.BLUE, false, 0, 0); // right down
        this.kernel.addEntity(this.width/2 + 215, this.height/2 + 275, 175, 25, Color.BLUE, false, 0, 0);

        this.kernel.addEntity(this.width/2 + 215, this.height/2 - 175, 25, 180, Color.BLUE, false, 0, 0); // right up
        this.kernel.addEntity(this.width/2 + 215, this.height/2 - 275, 175, 25, Color.BLUE, false, 0, 0);

    }

}

