package engine.model.gamePlayEngine.drawingMap;

import engine.gamePlay.drawingMap.XmlReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import static org.junit.jupiter.api.Assertions.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlReaderTest {
    private XmlReader xmlReader;

    @BeforeEach
    public void init() throws ParserConfigurationException, IOException, SAXException {
        this.xmlReader = new XmlReader(new File("src/main/resources/engine/map/levelOne.tmx"), 23, 23);
    }

    @Test
    public void testExtractData() throws ParserConfigurationException, IOException, SAXException {
        assertEquals("\n13,3,3,3,16,3,3,3,3,3,3,3,3,3,3,3,3,3,16,3,3,3,14,\n" +
                "12,69,69,69,12,69,67,69,69,69,69,69,69,69,69,69,69,69,12,0,0,0,12,\n" +
                "12,69,68,69,23,69,2,3,16,3,4,69,2,3,16,3,4,69,23,0,68,0,12,\n" +
                "12,69,69,69,69,69,69,69,12,69,69,69,69,69,12,69,0,69,0,0,0,0,12,\n" +
                "15,3,4,69,1,69,1,69,12,69,13,3,14,69,12,69,1,69,1,0,2,3,27,\n" +
                "12,69,69,69,12,69,12,69,12,69,12,0,12,69,12,69,12,69,12,0,0,0,12,\n" +
                "12,69,68,69,12,69,12,69,23,69,24,3,25,69,23,69,12,69,12,0,68,0,12,\n" +
                "12,69,69,69,12,69,12,69,69,69,69,69,69,69,69,69,12,69,12,0,0,0,12,\n" +
                "15,3,3,3,25,69,12,69,2,3,3,3,3,3,4,69,12,69,24,3,3,3,27,\n" +
                "12,69,69,69,69,69,12,69,69,69,69,69,69,69,69,69,12,69,69,69,69,69,12,\n" +
                "23,69,2,3,3,3,25,69,13,3,4,0,2,3,14,69,24,3,3,3,4,69,23,\n" +
                "69,69,69,69,69,69,69,69,12,0,0,0,0,0,12,69,69,69,69,69,69,69,69,\n" +
                "1,69,2,3,3,3,14,69,24,3,3,3,3,3,25,69,13,3,3,3,4,69,1,\n" +
                "12,69,69,69,69,69,12,69,69,69,69,0,69,69,69,67,12,69,69,69,69,69,12,\n" +
                "15,3,3,3,14,69,12,69,2,3,3,3,3,3,4,69,12,69,13,3,3,3,27,\n" +
                "12,69,69,69,12,69,12,69,69,69,69,69,69,69,69,69,12,69,12,69,69,69,12,\n" +
                "12,69,68,69,12,69,12,69,1,69,13,3,14,69,1,69,12,69,12,69,68,69,12,\n" +
                "12,69,69,69,12,69,12,69,12,69,12,0,12,69,12,69,12,69,12,69,69,69,12,\n" +
                "12,3,4,69,23,69,23,69,12,69,24,3,25,69,12,69,23,69,23,69,2,3,27,\n" +
                "12,69,69,69,69,69,0,69,12,69,69,69,69,69,12,69,69,69,69,69,69,69,12,\n" +
                "12,69,68,69,1,69,2,3,26,3,4,69,2,3,26,3,4,69,1,69,68,69,12,\n" +
                "12,69,69,69,12,69,69,69,67,69,69,69,69,69,69,69,69,69,12,69,69,69,12,\n" +
                "24,3,3,3,26,3,3,3,3,3,3,3,3,3,3,3,3,3,26,3,3,3,25\n",
                this.xmlReader.extractData());
    }

    @Test
    public void testConvertStringToTab() throws ParserConfigurationException, IOException, SAXException {
        String dataString = this.xmlReader.extractData();
        //this.xmlReader.convertStringToTab(dataString);
        //TODO a finir
    }


}
