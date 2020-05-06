import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

public class UndirectedGraphTest {

    @Test
    void undirectedGraphStraightDirection() {
        var v1 = "vertex1";
        var v2 = "vertex2";
        var v3 = "vertex3";

        Graph<String> graph = new UndirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);

        Assertions.assertThat(graph.getPath(v1, v3))
                .extracting(Edge::getSource, Edge::getTarget)
                .containsExactly(Tuple.tuple("vertex1", "vertex2"), Tuple.tuple("vertex2", "vertex3"));
    }

    @Test
    void undirectedGraphStraightDirectionDifferentOrder() {
        var v1 = "vertex1";
        var v2 = "vertex2";
        var v3 = "vertex3";

        Graph<String> graph = new UndirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2);
        graph.addEdge(v3, v2);

        Assertions.assertThat(graph.getPath(v1, v3))
                .extracting(Edge::getSource, Edge::getTarget)
                .containsExactly(Tuple.tuple("vertex1", "vertex2"), Tuple.tuple("vertex2", "vertex3"));
    }

    @Test
    void undirectedGraphReverseDirection() {
        var v1 = "vertex1";
        var v2 = "vertex2";
        var v3 = "vertex3";

        Graph<String> graph = new UndirectedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v2, v1);
        graph.addEdge(v3, v2);

        Assertions.assertThat(graph.getPath(v1, v3))
                .extracting(Edge::getSource, Edge::getTarget)
                .containsExactly(Tuple.tuple("vertex1", "vertex2"), Tuple.tuple("vertex2", "vertex3"));
    }
}