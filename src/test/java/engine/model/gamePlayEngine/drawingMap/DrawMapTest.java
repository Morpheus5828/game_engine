package engine.model.gamePlayEngine.drawingMap;

import engine.gamePlay.drawingMap.DrawMap;
import engine.gamePlay.drawingMap.XmlReader;
import engine.model.Kernel;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DrawMapTest {
    private XmlReader xmlReader;
    private Kernel kernel;
    private DrawMap drawMap;

    @BeforeEach
    public void init() throws ParserConfigurationException, IOException, SAXException {
        this.xmlReader = new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23, 23);
        this.kernel = new Kernel(600, 600, Color.BLACK);
        this.drawMap = new DrawMap(this.xmlReader, this.kernel);
    }

    @Test
    public void testCreateInstance() {}

}
