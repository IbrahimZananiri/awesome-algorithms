public interface Graph<Vertex> extends Iterable<Vertex> {
    // Vertices methods
    int size();
    void addVertex(Vertex vertex);
    void removeVertex(Vertex vertex);

    // Edges Methods
    boolean containsEdge(Vertex source, Vertex destination);
    void addEdge(Vertex source, Vertex destination, int weight);
    void removeEdge(Vertex source, Vertex destination);

    // Edge Weight Methods
    Integer getEdgeWeight(Vertex source, Vertex destination);
    void setEgeWeight(Vertex source, Vertex destination, int weight);
}
