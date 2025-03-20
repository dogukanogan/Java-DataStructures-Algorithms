import java.util.*;
                  // DFS --> depth first search
class Paths {
	private boolean[] visited; // Tracks visited vertices
	private int[] edgeTo; // Stores the parent of each vertex in the DFS tree
	private Graph g; // The graph being traversed
	private int start; // The starting vertex for the DFS traversal
	
    // Constructor
	public Paths(Graph g, int v) {
		this.g = g;
		this.start = v;
		dfs(v); // Perform DFS starting from vertex v
	}

	public Iterable<Integer> getPath(int w) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		for (int x = w; x != start; x = edgeTo[x]) {
			path.addFirst(x); 
		}
		path.addFirst(start);
		return path;
	}

	private void dfs(int v) {
		visited = new boolean[g.V]; // Initialize visited array
		edgeTo = new int[g.V]; // Initialize edgeTo array   
		visit(v); // Start DFS from vertex v
	}

	private void visit(int v) {
		visited[v] = true; // Mark the current vertex as visited
		for (int w : g.getNeighbors(v)) { // Iterate through all neighbors of v
			if (!visited[w]) { // If the neighbor hasn't been visited
				edgeTo[w] = v; // Record that we reached w from v
				visit(w); // Recursively visit w
			}
		}
	}

	private void dfsIterative(int v) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(v); // Push the starting vertex 
		visited = new boolean[g.V];
		while (!st.isEmpty()) {
			int w = st.pop(); // Pop a vertex from the stack
			if (!visited[w]) {
				visited[w] = true; // Mark it as visited
				System.out.println(w); // Process w 
				for (int ww : g.getNeighbors(w)) {
					if (!visited[ww]) {
						st.push(ww); // Push unvisited neighbors
					}
				}
			}
		}
	}


}