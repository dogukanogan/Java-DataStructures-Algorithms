import java.util.LinkedList;

public class Graph {


    int V;
    LinkedList<Integer>[] neighbors;

    public Graph( int V ) {
        this.V = V;
        this.neighbors = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            neighbors[i] = new LinkedList<>();
        }
    } 

    public void addEdge(int v, int w) {
        neighbors[v].add(w);
        neighbors[w].add(v);
    }

    public LinkedList<Integer> getNeighbors(int v) {
        return neighbors[v];
    }

    public void printGraph() {
        for(int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for(Integer neighbor : neighbors[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)  {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 1);

        graph.printGraph();
    }



}
