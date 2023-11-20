package engine.model.gamePlayEngine.drawingMap;

import engine.gamePlay.aiEngine.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphTest {
    private Graph graph;

    @BeforeEach
    public void init() {
        this.graph = new Graph(5);
    }

    @Test
    public void testDijkstra() {
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 4, 8);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(4, 3, 6);
        graph.addEdge(3, 2, 4);
        graph.addEdge(4, 2, 9);
        graph.dijkstra();
        List<Map.Entry<Integer, List<Integer>>> entry = new ArrayList<>(graph.getShortestPaths().entrySet());
        assertEquals("0=[0]", entry.get(0).toString());
        assertEquals("1=[0, 1]", entry.get(1).toString());
        assertEquals("2=[0, 1, 3, 2]", entry.get(2).toString());
        assertEquals("3=[0, 1, 3]", entry.get(3).toString());
        assertEquals("4=[0, 1, 4]", entry.get(4).toString());

    }
}
