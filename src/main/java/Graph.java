import java.util.List;

public interface Graph<V> {

    void addVertex(V vertex);

    void addEdge(V source, V target);

    List<Edge<V>> getPath(V source, V target);
}
