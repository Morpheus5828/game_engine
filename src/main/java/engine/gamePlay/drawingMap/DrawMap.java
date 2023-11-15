package engine.gamePlay.drawingMap;

import engine.gamePlay.PacGum;
import engine.gamePlay.SuperGum;
import engine.gamePlay.Wall;
import engine.gamePlay.aiEngine.Graphe;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DrawMap {
    private XmlReader xmlReader;
    private int[][] data;
    private Kernel kernel;
    private Graphe graphe;
    private Map<Integer, Position> entities;
    private int[] wallValue = {3, 12, 1, 23, 2, 4, 13, 24, 14, 25, 26, 16, 15, 27};

    public DrawMap(XmlReader xmlReader, Kernel kernel) throws ParserConfigurationException, IOException, SAXException {
        this.xmlReader = xmlReader;
        this.xmlReader.convertStringToTab();
        this.data = this.xmlReader.getData();
        this.kernel = kernel;
        this.entities = new HashMap<>();
        createInstance();
    }

    public void createInstance() throws FileNotFoundException {
        var counter = 0;
        for(int i = 0; i < this.xmlReader.getWidth(); i++) {
            for(int j = 0; j < this.xmlReader.getHeight(); j++) {
                switch (this.data[i][j]) {
                    case 3 ->  new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/horizontal.png")));
                    case 12 ->  new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/vertical.png")));
                    case 1 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/vertical_end_up.png")));
                    case 23 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/vertical_end_down.png")));
                    case 2 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/horizontal_end_left.png")));
                    case 4 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/horizontal_end_right.png")));
                    case 13 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/corner_left_up.png")));
                    case 24 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/corner_left_down.png")));
                    case 14 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/corner_right_up.png")));
                    case 25 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/corner_right_down.png")));
                    case 26 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mix_down.png")));
                    case 16 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mix_up.png")));
                    case 15 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mix_left.png")));
                    case 27 -> new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mix_right.png")));
                    case 68 -> {
                        new SuperGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/big_pacgum.png")));
                        this.entities.put(counter, new Position(i, j));
                    }
                    case 69 -> {
                        new PacGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mini_pacgum.png")));
                        this.entities.put(counter, new Position(i, j));
                    }
                }

            }
        }
    }

    public void createGraph() {
        this.graphe = new Graphe(this.entities.keySet().size());
        for(Integer source : this.entities.keySet()) {
            for(Integer destination : this.entities.keySet()) {
                if(!Objects.equals(source, destination)) {
                    if(isNeighbor(source, destination)) {
                        this.graphe.addEdge(source, destination, 1);
                    }
                }
            }
        }
    }

    public boolean isNeighbor(Integer source, Integer destination) {
        var x_source = this.entities.get(source).getX();
        var y_source = this.entities.get(source).getY();
        var x_dest = this.entities.get(destination).getX();
        var y_dest = this.entities.get(destination).getY();

        if (x_source + 1 == x_dest && y_source == y_dest)
            return true;
        else if (x_source - 1 == x_dest && y_source == y_dest)
            return true;
        else if (x_source == x_dest && y_source + 1 == y_dest)
            return true;
        else if (x_source == x_dest && y_source - 1 == y_dest)
            return true;
        else return false;

    }

    



}
