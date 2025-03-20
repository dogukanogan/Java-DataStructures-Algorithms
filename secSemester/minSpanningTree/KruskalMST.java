import java.util.*;

public class KruskalMST {
    LinkedList<Edge> mst = new LinkedList<Edge>();
    int V;

    // (vertices - 1) equals MST(Minimum Spanning Tree)

    int componentIds[]; // each index represents a vertex in the graph
    // componentIds[v] represents the parent or root of the component that vertex v belongs to

    public KruskalMST(WeightedGraph g) {
        this.V = g.V;
        componentIds = new int[V]; // V is the number of vertices
        for (int i = 0; i < V; i++) componentIds[i] = i; // each vertex is its own parent initially
        LinkedList<Edge> edges = g.allEdges;
        Collections.sort(edges); // nlogn

        for (Edge e: edges) {
            int v = e.v, w = e.w;
            if (componentIds[v] != componentIds[w]) {
                union(v,w);
                mst.add(e);
            }
            if (mst.size() == V-1) break;
        }
    }

    private void union(int v, int w) {
        // int idv = componentIds[v];
        // int idw = componentIds[w];
        // for( int i=0; i<V; i++ ){
        //    if(componentIds[i] == idw) componentIds[i] = idv;
        // }
        int vroot = findRoot(v);
        int wroot = findRoot(w);
        componentIds[vroot] = wroot;
    }

    // !!! dont understand the 01234 example -> 44444

    private int findRoot(int v) {
        while (v != componentIds[v]) v = componentIds[v];
        return v;
    }

    public Iterable<Edge> getEdges() {
        return mst;
    }
}
