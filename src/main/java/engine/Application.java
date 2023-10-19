package engine;

import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle(100,200,200,200);
        rectangle.setFill(Color.BLUE);

        Circle circle = new Circle(600,300,100);
        circle.setFill(Color.RED);

        Pane root = new Pane();
        root.getChildren().add(rectangle);
        root.getChildren().add(circle);

        Scene scene = new Scene(root, 1000, 700);
        scene.setFill(Color.BLACK);

        stage.setScene(scene);

        stage.show();
    }



  public static void main(String[] args) {
    launch();
  }
}
