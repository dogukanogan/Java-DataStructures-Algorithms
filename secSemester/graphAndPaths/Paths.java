import java.util.*;

public class Paths {

    private boolean[] visited;
    private int edgeTo[];
    private Graph g;
    private int start;

    public Paths(Graph g, int v) {
        this.g = g;
        this.start = v;
        dfs(v);
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
        visited = new boolean[g.V];
        edgeTo = new int[g.V];
        visit(v);
    }

    private void visit(int v) {
        visited[v] = true;
        for (int w : g.getNeighbors(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                visit(w);
            }
        }
    }

    private void dfsIterative(int v) {
        Stack<Integer> st = new Stack<Integer>(); // create a stack
        st.push(v); // push the starting node
        visited = new boolean[g.V]; // initialize visited array
        while (!st.isEmpty()) { // continue while stack is not empty
            int w = st.pop(); // pop the top node

            if(!visited[w]) { // if the node is not visited
                visited[w] = true; // mark it as visited
                System.out.println(w); // process the node

                for (int ww : g.getNeighbors(w)) { // loop through neighbors
                    if (!visited[ww]) {
                        st.push(ww); // push unvisited neighbors to the stack
                    }
                }
            }
        }
    }

}
