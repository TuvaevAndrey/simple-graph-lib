import java.util.Objects;

public class Edge<V> {

    private final V source;
    private final V target;

    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
    }

    public V getSource() {
        return source;
    }

    public V getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (!Objects.equals(source, edge.source)) return false;
        return Objects.equals(target, edge.target);
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (target != null ? target.hashCode() : 0);
        return result;
    }
}
