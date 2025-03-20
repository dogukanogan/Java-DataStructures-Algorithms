import java.util.LinkedList;

public class Graph {
    
    public int V;
    private LinkedList<Integer>[] neighbors;
    public int[] distTo; // stores the shortest distance from a source vertex
    boolean[] visited; 
    public int id[];
    public int currentId;
    
    public Graph(int V) {
        this.V = V;
        this.neighbors = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            neighbors[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        neighbors[v].add(w);
        neighbors[w].add(v);
    }

    public LinkedList<Integer> getNeighbors(int v) {
        return neighbors[v];
    }

    public int degree(int v) {
        return neighbors[v].size();
    }

    public int maxDegree() {
        int maxDegree = degree(0);
        int maxDegreeVertex = 0;
        for (int i = 0; i < V; i++) {
            if (degree(i) > maxDegree) {
                maxDegree = degree(i);
                maxDegreeVertex = i;
            }
        }
        return maxDegreeVertex;
    }

    public int getNumberOfSelfLoops() {
        int counter = 0;
        for (int v = 0; v < V; v++) {
            for(int w : neighbors[v]) {
                if (w == v) counter++;
            }
        }
        return counter / 2; // undirected graph, edges are stored twice in the adjacency list
    }

    public void bfs(int s) {
        int[] edgeTo = new int[V]; // store the previous node in the shortest path
        distTo = new int[V]; // store the distance from the start node
        LinkedList<Integer> q = new LinkedList<Integer>(); // use a queue for bfs
        q.add(s); // start with node 's'

        visited[s] = true;
        id[s] = currentId;

        while (!q.isEmpty()) { // process the queue until it's empty
            int v = q.remove(); // dequeue a node

            for (int w : neighbors[v]) { // visit all neighbors
                if (!visited[w]) {
                    visited[w] = true;
                    id[w] = currentId;
                    edgeTo[w] = v; 
                    distTo[w] = distTo[v] + 1;
                    q.add(w);
                }
            }
        }
    }

    public void connectedComponents() {
        visited = new boolean[V];
        id = new int[V];
        currentId = 0;
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                bfs(v);
                currentId++;
            }
        }
    }

    public boolean hasCycle(){
        // EXERCISE: fix this method, currently not working

        /* 
        boolean[] visited = new boolean[V];
        boolean cycleFound = false;
        for(int v=0; v<V; v++){
           if(!visited[v]) {
              visited[v] = true;
              cycleFound = visit(v, -1, visited);
              if(cycleFound) return true;
           }
        }
        return false;
        */

        boolean[] visited = new boolean[V]; // track visited nodes

        for (int v = 0; v < V; v++) {
            if (!visited[v]) { // if a node is unvisited, start DFS
                if (visit(v, -1, visited)) { // start dfs from v with no parent(-1)
                    return true; // cycle detected
                }
            }
        }
        return false; // no cycle found
     }

     private boolean visit(int v, int from, boolean[] visited){
        visited[v] = true;

        for(int w:neighbors[v]){
           if(visited[w] && w != from) return true;

           if(!visited[w]) {
            if(visit(w, v, visited)) return true;
           }
        }
        return false;
     }


    
    public static void main(String[] args) {

        Graph g = new Graph(10);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(3,1);
		g.addEdge(2,4);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.addEdge(6,7);
		g.addEdge(8,9);
        System.out.println(g.hasCycle());
    }


}
