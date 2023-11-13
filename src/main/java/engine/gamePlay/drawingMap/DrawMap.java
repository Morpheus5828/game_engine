package engine.gamePlay.drawingMap;

import engine.gamePlay.PacGum;
import engine.gamePlay.SuperGum;
import engine.gamePlay.Wall;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawMap {
    private XmlReader xmlReader;
    private int[][] data;
    private Kernel kernel;
    private Map<Position, List<Position>> graph;
    private int[] wallValue = {3, 12, 1, 23, 2, 4, 13, 24, 14, 25, 26, 16, 15, 27};

    public DrawMap(XmlReader xmlReader, Kernel kernel) throws ParserConfigurationException, IOException, SAXException {
        this.xmlReader = xmlReader;
        this.xmlReader.convertStringToTab();
        this.data = this.xmlReader.getData();
        this.kernel = kernel;
        this.graph = new HashMap<>();
        createInstance();
    }

    public void createInstance() throws FileNotFoundException {

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
                        this.graph.put(new Position(i, j), new ArrayList<>());
                    }
                    case 69 -> {
                        new PacGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mini_pacgum.png")));
                        this.graph.put(new Position(i, j), new ArrayList<>());
                    }
                }

            }
        }
    }

    public void createGraph() {
        for(Position position : this.graph.keySet()) {
            try {
                var x = (int)position.getX();
                var y = (int)position.getY();
                for(int index : this.wallValue) {
                    if(x + 1 < this.xmlReader.getWidth()) {
                        if(this.data[x + 1][y] != index) {
                            if(!isAlreadyInGraph(position, x+1, y)) {
                                this.graph.get(position).add(new Position(x+1, y));
                            }
                        }
                    } if(x - 1 >= 0) {
                        if(this.data[x-1][y] != index) {
                            if(!isAlreadyInGraph(position, x-1, y)) {
                                this.graph.get(position).add(new Position(x-1, y));
                            }
                        }
                    } if(y + 1 < this.xmlReader.getHeight()) {
                        if(this.data[x][y+1] != index) {
                            if(!isAlreadyInGraph(position, x, y+1)) {
                                this.graph.get(position).add(new Position(x, y+1));
                            }
                        }
                    } if(y - 1 >= 0) {
                        if(this.data[x][y-1] != index) {
                            if(!isAlreadyInGraph(position, x, y-1)) {
                                this.graph.get(position).add(new Position(x, y-1));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAlreadyInGraph(Position key, double c, double d) {
        Position neighbor = new Position(c, d);
        for(int index = 0; index < this.graph.get(key).size(); index++) {
            if(this.graph.get(key).get(index).getX() == neighbor.getX() && this.graph.get(key).get(index).getY() == neighbor.getY())
                return true;
        }
    return false;
    }

    public Map<Position, List<Position>> getGraph() {
        return graph;
    }

    public void displayGraph() {
        for(Position position : this.graph.keySet()) {
            String neighborDisplay = "";
            for(Position neighbor : this.graph.get(position)) {
                neighborDisplay += "[" + neighbor.getX() + " ; " + neighbor.getY() + "] ";
            }


            System.out.println("Node: [" + position.getX() + " ; " + position.getY() + "] -->" + neighborDisplay );
        }
    }
}
