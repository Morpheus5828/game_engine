package engine.gamePlay.drawingMap;

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
                    case 3 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/horizontal.png")), false, 0, 0);
                    case 12 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/vertical.png")), false, 0, 0);
                    case 1 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/vertical_end_up.png")), false, 0, 0);
                    case 23 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/vertical_end_down.png")), false, 0, 0);
                    case 2 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/horizontal_end_left.png")), false, 0, 0);
                    case 4 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/horizontal_end_right.png")), false, 0, 0);
                    case 13 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/corner_left_up.png")), false, 0, 0);
                    case 24 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/corner_left_down.png")), false, 0, 0);
                    case 14 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/corner_right_up.png")), false, 0, 0);
                    case 25 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/corner_right_down.png")), false, 0, 0);
                    case 26 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/mix_down.png")), false, 0, 0);
                    case 16 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/mix_up.png")), false, 0, 0);
                    case 15 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/mix_left.png")), false, 0, 0);
                    case 27 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/mix_right.png")), false, 0, 0);
                    case 69 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/mini_pacgum.png")), false, 10, 10);
                    case 68 -> kernel.addEntity(32+j*32, 32+i*32, 32, 32, new Image(new FileInputStream("src/main/resources/engine/images/big_pacgum.png")), false, 10, 10);
                }



            }
        }
    }
}
