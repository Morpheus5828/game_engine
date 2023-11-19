package engine.gamePlay.drawingMap;

import engine.gamePlay.PacGum;
import engine.gamePlay.SuperGum;
import engine.gamePlay.Wall;
import engine.model.Kernel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class DrawMap {
    private XmlReader xmlReader;
    private int[][] data;
    private Kernel kernel;

    public DrawMap(XmlReader xmlReader, Kernel kernel) throws ParserConfigurationException, IOException, SAXException {
        this.xmlReader = xmlReader;
        this.xmlReader.convertStringToTab();
        this.data = this.xmlReader.getData();
        this.kernel = kernel;
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
                    case 68 -> new SuperGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/big_pacgum.png")));
                    case 69 -> new PacGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(new FileInputStream("src/main/resources/engine/images/mini_pacgum.png")));
                }

            }
        }
    }
}
