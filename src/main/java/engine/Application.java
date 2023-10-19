package engine;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        // Add object element
        Rectangle rectangle = new Rectangle(150, 75, 300, 150);
        rectangle.setFill(Color.BLUE);
        Circle circle = new Circle(10, 2, 5);
        Group group = new Group(rectangle, circle);
        Scene scene = new Scene(group, 800, 800);
        stage.setScene(scene);
        stage.show();

    }



  public static void main(String[] args) {
    launch();
  }
}
