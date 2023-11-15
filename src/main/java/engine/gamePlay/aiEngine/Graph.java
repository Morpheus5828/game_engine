package engine.gamePlay.aiEngine;

import java.util.*;

public class Graph{
    private int vertices;
    private int matrix[][];
    private Map<Integer, List<Integer>> shortestPaths;

    public Graphe(int vertex) {
        this.vertices = vertex;
        this.matrix = new int[vertex][vertex];
        this.shortestPaths = new HashMap<>();
        for(int i = 0; i < vertex; i++)
            shortestPaths.put(i, new ArrayList<>(Arrays.asList(i)));

    }

    public void addEdge(int source, int destination, int weight) {
        this.matrix[source][destination]=weight;
        this.matrix[destination][source] = weight;
    }

    public void dijkstra() {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (this.matrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minVertex] + this.matrix[minVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                        List<Integer> newPath = new ArrayList<>(shortestPaths.get(minVertex));
                        newPath.add(j);
                        shortestPaths.put(j, newPath);
                    }
                }
            }
        }

        /*for (Map.Entry<Integer, List<Integer>> entry : shortestPaths.entrySet())
            System.out.println("Chemin le plus court vers " + entry.getKey() + ": " + entry.getValue());*/
    }

    public int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for(int i = 0; i < distance.length; i++) {
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex]))
                minVertex = i;
        }
        return minVertex;
    }

    public Map<Integer, List<Integer>> getShortestPaths() {
        return shortestPaths;
    }
}
