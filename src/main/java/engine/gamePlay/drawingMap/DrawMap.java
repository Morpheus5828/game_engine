package engine.gamePlay.drawingMap;

import engine.gamePlay.*;
import engine.gamePlay.entity.PacGum;
import engine.gamePlay.entity.Pacman;
import engine.gamePlay.entity.SuperPacGum;
import engine.gamePlay.entity.Wall;
import engine.gamePlay.entity.ghost.Ghost;
import engine.gamePlay.entity.ghost.PinkGhost;
import engine.model.Kernel;
import engine.model.physicalEngine.movement.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class DrawMap {
    private XmlReader xmlReader;
    private int[][] data;
    private Kernel kernel;
    private List<Wall> wallList = new ArrayList<>();
    private List<SuperPacGum> superGumsList = new ArrayList<>();
    private List<PacGum> pacGumsList = new ArrayList<>();
    private List<Ghost> ghostsList = new ArrayList<>();
    private Pacman pacman;
    private Position initPositionPacman;
    private Position initPositionGhost;


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
                    case 3 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/horizontal.png"))));
                    case 12 ->  this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/vertical.png"))));
                    case 1 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/vertical_end_up.png"))));
                    case 23 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/vertical_end_down.png"))));
                    case 2 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/horizontal_end_left.png"))));
                    case 4 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/horizontal_end_right.png"))));
                    case 13 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/corner_left_up.png"))));
                    case 24 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/corner_left_down.png"))));
                    case 14 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/corner_right_up.png"))));
                    case 25 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/corner_right_down.png"))));
                    case 26 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/mix_down.png"))));
                    case 16 ->this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/mix_up.png"))));
                    case 15 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/mix_left.png"))));
                    case 27 -> this.wallList.add(new Wall(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/mix_right.png"))));
                    case 68 -> this.superGumsList.add(new SuperPacGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/big_pacgum.png"))));
                    case 69 -> this.pacGumsList.add(new PacGum(32+j*32, 32+i*32, 32, 32, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/mini_pacgum.png"))));
                     case 70 -> {
                        pacman = new Pacman(32+j*32, 32+i*32 + 1, 30, 30, kernel, new Image(getClass().getClassLoader().getResourceAsStream("engine/images/pacman.png")));
                        kernel.setMainShape(pacman.getPacman());
                        initPositionPacman = new Position(32+j*32, 32+i*32 + 1);
                    }
                    case 71 -> {
                        this.ghostsList.add(new PinkGhost(32+j*32, 32+i*32, 32, 32, kernel, Color.PINK));
                        initPositionGhost = new Position(32+j*32, 32+i*32);
                    }
                }

            }
        }
    }

    public List<Wall> getWallList() {
        return wallList;
    }

    public List<SuperPacGum> getSuperGumsList() {
        return superGumsList;
    }

    public List<PacGum> getPacGumsList() {
        return pacGumsList;
    }

    public List<Ghost> getGhostsList() {
        return ghostsList;
    }

    public Position getInitPositionPacman() {
        return initPositionPacman;
    }

    public Position getInitPositionGhost() {
        return initPositionGhost;
    }
}
