class Edge implements Comparable<Edge> {
    public int v, w; // two vertices connected by the edge
    public double weight; // the weight of the edge

    // constructor
    public Edge(int v, int w, double weight) { 
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        if (this.weight < other.weight) return -1;
        if (this.weight > other.weight) return 1;
        return 0;
    }

    public int end2(int v) {
        if (v == this.v) return w;
        return v;
    }
}
