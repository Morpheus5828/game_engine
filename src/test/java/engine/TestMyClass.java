package engine;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import engine.model.physicalEngine.entity.PhysicalObject;
import engine.model.physicalEngine.entity.shape.Shape;
import engine.model.physicalEngine.entity.temp.Position;

import engine.model.physicalEngine.entity.shape.AbstractShape;
import engine.model.physicalEngine.entity.shape.Circle;
import engine.model.physicalEngine.entity.shape.Polygon;
import engine.model.physicalEngine.entity.temp.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * A template class for testing with assertJ.
 */
class TestMyClass {

  private Circle circle1=new Circle(10,10,5);
  private Circle circle2=new Circle(-10,-10,5);
  private Position pos1=new Position(10,10);
  private Position pos2=new Position(-10,-10);
  @Test
  void testCircle(){
    //test si la liste des positons des sommets est bien vide
    assertThat(circle1.getApex()).isEmpty();
    //test si les coordonnées sont correctes (positives)
    assertThat(circle1.getCenter().getX()).isEqualTo(pos1.getX());
    assertThat(circle1.getCenter().getY()).isEqualTo(pos1.getY());
    //test si les coordonnées sont correctes (negatives)
    assertThat(circle2.getCenter().getX()).isEqualTo(pos2.getX());
    assertThat(circle2.getCenter().getY()).isEqualTo(pos2.getY());
    //test si le rayon est exact
    assertThat(circle2.getRadius()).isEqualTo(5);
  }

  private Polygon poly1=new Polygon(5,5,10,3);
  private List<Position> apex1=new ArrayList<>();
  @Test
  void testPolygon() {
    //initialisation de la list apex1
    apex1.add(new Position(15.0, 5.0));
    apex1.add(new Position(1.7763568394002505E-15, 13.660254037844387));
    apex1.add(new Position(-4.440892098500626E-15, -3.6602540378443837));
    //test si les sommets du polygomes sont les bons
    for (int i = 0; i < 3; i++) {
      assertThat(poly1.getApex().get(i).getX()).isEqualTo(apex1.get(i).getX());
      assertThat(poly1.getApex().get(i).getY()).isEqualTo(apex1.get(i).getY());
    }
  }
  private Position posChar1=new Position(2,2);
  private Circle shape1=new Circle(1,1,1);

  private PhysicalObject physic1=new PhysicalObject(posChar1,100,50,true,shape1);
  @Test
  void TestGet(){
    //test de la position de l'objet physique
    assertThat(physic1.getPosition().getX()).isEqualTo(2);
    assertThat(physic1.getPosition().getY()).isEqualTo(2);
    //test la vitesse de l'objet
    assertThat(physic1.getSpeed()).isEqualTo(100);
    //test la masse de l'objet
    assertThat(physic1.getMass()).isEqualTo(50);
    //test de la forme de l'objet
    PhysicalObject physictest=new PhysicalObject(posChar1,100,50,true,shape1);
    assertThat(physic1.getShape()).isEqualTo(physictest.getShape());
    //test de collision (true)
    assertThat(physic1.isCollisionOn()).isTrue();
  }
  @Test
  void TestSet(){
    //test de set la position
    Position postest=new Position(15,15);
    physic1.setPosition(postest);
    assertThat(physic1.getPosition().getX()).isEqualTo(15);
    assertThat(physic1.getPosition().getY()).isEqualTo(15);
    //test de set la vitesse
    physic1.setSpeed(1500);
    assertThat(physic1.getSpeed()).isEqualTo(1500);
    //test de set la masse
    physic1.setMass(1);
    assertThat(physic1.getMass()).isEqualTo(1);
    //test de set la forme
    Circle shapetest=new Circle(25,26,5);
    physic1.setShape(shapetest);
    assertThat(physic1.getShape()).isEqualTo(shapetest);
    //test de set la collision
    physic1.setCollisionOn(false);
    assertThat(physic1.isCollisionOn()).isFalse();
  }
  //pour les tests de Character ce sont exactement les mêmes tests pour l'instant
}
