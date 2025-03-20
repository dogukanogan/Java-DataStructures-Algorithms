public class Paths {

    private boolean[] visited;
    private int[] edgeTo;
    private Graph g;
    private int start;

    public Paths(Graph g, int start) {
        this.g = g;
        this.start = start;
        dfs(start);
    }

    private void dfs() {
        visited = new boolean[g.V];
        edgeTo = new int[g.V];
        visit(v);
    }

    
}
