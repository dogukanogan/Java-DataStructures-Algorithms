import java.util.*;

public class WeightedGraph {
    public int V; // number of vertices in the graph
    private LinkedList<Edge>[] neighbors; 
    public LinkedList<Edge> allEdges;

    public WeightedGraph(int V) {
        this.V = V;
        this.neighbors = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            neighbors[i] = new LinkedList<Edge>();
        }
        allEdges = new LinkedList<Edge>(); // initializes an empty linked list
    }

    public void addEdge(Edge e) {
        neighbors[e.v].add(e);
        neighbors[e.w].add(e);
        allEdges.add(e);
    }

    public LinkedList<Edge> getNeighbors(int v) {
        return neighbors[v];
    }

    public static void main(String[] args) {

        WeightedGraph g = new WeightedGraph(8);
        
		g.addEdge(new Edge(1,2,0.36));
		g.addEdge(new Edge(1,3,0.29));
		g.addEdge(new Edge(1,5,0.32));
		g.addEdge(new Edge(1,7,0.19));
		g.addEdge(new Edge(2,3,0.17));
		g.addEdge(new Edge(2,0,0.26));
		g.addEdge(new Edge(2,6,0.40));
		g.addEdge(new Edge(2,7,0.34));
		g.addEdge(new Edge(3,6,0.52));
		g.addEdge(new Edge(4,0,0.38));
		g.addEdge(new Edge(4,5,0.35));
		g.addEdge(new Edge(4,6,0.93));
		g.addEdge(new Edge(4,7,0.37));
		g.addEdge(new Edge(5,7,0.28));
		g.addEdge(new Edge(6,0,0.58));
		g.addEdge(new Edge(7,0,0.16));
    }
}
