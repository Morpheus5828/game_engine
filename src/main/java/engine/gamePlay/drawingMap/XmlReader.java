package engine.gamePlay.drawingMap;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.IOException;
import java.io.BufferedReader;
import org.xml.sax.InputSource;

/**
 * The XmlReader class is responsible for reading the XML file and converting it into a two-dimensional array.
 */
public class XmlReader {
    private int[][] data;
    private int width;
    private int height;
    private BufferedReader file;

    public XmlReader(BufferedReader file, int width, int height) {
        this.file = file;
        this.width = width;
        this.height = height;
        this.data = new int[this.width][this.height];
    }

    public String extractData() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(file));
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("data");
        return nodeList.item(1).getTextContent();
    }

    public void convertStringToTab() throws ParserConfigurationException, IOException, SAXException {

        String[] dataTab = extractData().split(",");
        // erase space
        for (int i = 0; i < dataTab.length; i++)
            dataTab[i] = dataTab[i].trim();

        var index = 0;
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.height; j++) {
                this.data[i][j] = Integer.parseInt(dataTab[index]);
                index++;
            }
        }
    }

    public int[][] getData() {
        return data;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
