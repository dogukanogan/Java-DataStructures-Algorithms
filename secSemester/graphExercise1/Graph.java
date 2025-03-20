import java.util.*;

public class Graph {
	
	public int V;
	public LinkedList<Integer>[] neighbors;

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
		int max = 0;
		for (int v = 0; v < V; v++) {
			int currentDegree = degree(v);
			if (currentDegree > max) max = currentDegree;
		}
		return max;
	}

	public int getNumberOfSelfLoops() {
		int count = 0;
		for (int v = 0; v < V; v++) {
			if (neighbors[v].contains(v)) {
				count++;
			}
		}
		return count;
	}

	/*

	public int getNumberOfSelfLoops() {
		int count = 0;
		for (int v = 0; v < V; v++) {
			if (neighbors[v].contains(v)) {
				count++;
			}
		}
		return count;
	}
	
	*/

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(3,1);
		// g.addEdge(0, 0); (Self Loop)
		//for( int w : g.getNeighbors(1) ){
		//    System.out.print(w + " ");
		//}
		Paths paths = new Paths(g, 0);
		for( int v : paths.getPath(3) ) {
			System.out.print(v + " ");
		}
		System.out.println();

		System.out.println(g.getNumberOfSelfLoops());
	}
}
