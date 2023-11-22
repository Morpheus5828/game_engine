package engine.model.gamePlayEngine.drawingMap;

import engine.gamePlay.Category;
import engine.gamePlay.aiEngine.Graph;
import engine.gamePlay.drawingMap.DrawMap;
import engine.gamePlay.drawingMap.XmlReader;
import engine.model.FinalShape;
import engine.model.Kernel;
import engine.model.physicalEngine.PhysicalEngine;
import engine.model.physicalEngine.movement.Velocity;
import engine.model.physicalEngine.shape.Rectangle;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphTest {
    private Graph graph;


    @Test
    public void testDijkstra() {
        this.graph = new Graph(5);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(4, 3, 6);
        graph.addEdge(3, 2, 4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(4, 2, 9);
        graph.addEdge(0, 4, 8);
        graph.dijkstra();
        List<Map.Entry<Integer, List<Integer>>> entry = new ArrayList<>(graph.getShortestPaths().entrySet());
        assertEquals("0=[0]", entry.get(0).toString());
        assertEquals("1=[0, 1]", entry.get(1).toString());
        assertEquals("2=[0, 1, 3, 2]", entry.get(2).toString());
        assertEquals("3=[0, 1, 3]", entry.get(3).toString());
        assertEquals("4=[0, 1, 4]", entry.get(4).toString());
    }

    @Test
    public void testDijkstraFinalShape() {
        this.graph = new Graph(7);
        FinalShape src = new FinalShape(32 * 16, 32 * 16, Color.PINK, 32, 32, false, Category.PACMAN, new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape one = new FinalShape(32 * 16, 32 * 15, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape two = new FinalShape(32 * 17, 32 * 15, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape three = new FinalShape(32 * 18, 32 * 15, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape four = new FinalShape(33 * 19, 32 * 15, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape five = new FinalShape(33 * 20, 32 * 15, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape six = new FinalShape(33 * 20, 32 * 14, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));
        FinalShape dest = new FinalShape(33 * 20, 32 * 16, Color.PINK, 32, 32, false, Category.PACMAN,new Velocity(0, 0), new PhysicalEngine(32*23, 32*23));

        List<FinalShape> nodes = new ArrayList<>();
        nodes.add(src);
        nodes.add(one);
        nodes.add(two);
        nodes.add(three);
        nodes.add(four);
        nodes.add(five);
        nodes.add(six);
        nodes.add(dest);

        for(int i = 0; i < 9; i++) {
            if(i != 6)
                graph.addEdge(i, i+1, 1);
            else
                break;
        }

        graph.dijkstra();
        List<Map.Entry<Integer, List<Integer>>> entry = new ArrayList<>(graph.getShortestPaths().entrySet());

        assertEquals(0, entry.get(5).getValue().get(0));
        assertEquals(1, entry.get(5).getValue().get(1));
        assertEquals(2, entry.get(5).getValue().get(2));
        assertEquals(3, entry.get(5).getValue().get(3));
        assertEquals(4, entry.get(5).getValue().get(4));
        assertEquals(5, entry.get(5).getValue().get(5));
    }

    /*@Test
    public void testGetFinalShape() throws ParserConfigurationException, IOException, SAXException {
        Kernel kernel = new Kernel(800, 800, Color.BLUE);
        new DrawMap(new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23, 23), kernel);

        this.graph = new Graph(530);
        this.graph.createAutomatically(
                kernel.getFinalShapes(),
                kernel.getPinkGhost()
        );

        assertNotEquals(null, this.graph.getFinalShape(32,32).toString());
       // assertNull(this.graph.getFinalShape(-32, 32));

    }
*/
    @Test
    public void testCreateAutomatically() throws ParserConfigurationException, IOException, SAXException {
        Kernel kernel = new Kernel(800, 800, Color.BLUE);
        new DrawMap(new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23, 23), kernel);

        this.graph = new Graph(530);
        this.graph.createAutomatically(
                kernel.getFinalShapes(),
                kernel.getPinkGhost()
        );
        this.graph.dijkstra();

        List<Map.Entry<Integer, List<Integer>>> entry = new ArrayList<>(graph.getShortestPaths().entrySet());

        /*assertEquals(0, entry.get(5).getValue().get(0));
        assertEquals(1, entry.get(5).getValue().get(1));
        assertEquals(2, entry.get(5).getValue().get(2));
        assertEquals(3, entry.get(5).getValue().get(3));
        assertEquals(4, entry.get(5).getValue().get(4));
        assertEquals(5, entry.get(5).getValue().get(5));*/
    }


}
