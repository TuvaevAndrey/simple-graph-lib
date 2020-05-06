import java.util.*;

public class UndirectedGraph<V> implements Graph<V> {

    private final Map<V, Set<Edge<V>>> vertexMap = new HashMap<>();

    @Override
    public void addVertex(V vertex) {
        //TODO: check vertex notnull
        vertexMap.put(vertex, new HashSet<>());
    }

    @Override
    public void addEdge(V source, V target) {
        //TODO: check vertexes notnull & exist
        vertexMap.get(source).add(new Edge<>(source, target));
        vertexMap.get(target).add(new Edge<>(target, source));
    }

    @Override
    public List<Edge<V>> getPath(V source, V target) {
        //TODO: check vertexes notnull & exist
        return path(source, target, null);
    }

    private List<Edge<V>> path(V source, V target, V prev) {
        for (Edge<V> e : vertexMap.get(source)) {
            if (e.getSource().equals(prev)) {
                continue;
            }

            var res = new ArrayList<Edge<V>>();
            res.add(e);

            var edgeTarget = e.getTarget();

            if (!edgeTarget.equals(target)) {
                res.addAll(path(edgeTarget, target, source));
            }
            return res;
        }
        return null;
    }
}
