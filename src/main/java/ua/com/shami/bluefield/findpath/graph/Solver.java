package ua.com.shami.bluefield.findpath.graph;

import es.usc.citius.hipster.algorithm.Algorithm;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Solver {
    private HipsterGraph<Vertex, Integer> graph;
    private Vertex start;
    private Vertex finish;

    public Solver(HipsterGraph<Vertex, Integer> graph, Vertex start, Vertex finish) {
        this.graph = graph;
        this.start = start;
        this.finish = finish;
    }

    public String solve() {
        SearchProblem p = GraphSearchProblem
                .startingFrom(start)
                .in(graph)
                .takeCostsFromEdges()
                .build();

        Algorithm.SearchResult searchResult = Hipster.createDijkstra(p).search(finish);
        List<List<Object>> optimalPaths = searchResult.getOptimalPaths();
        if (optimalPaths.isEmpty()) {
            return StringUtils.EMPTY;
        }
        else {
            return directsString(optimalPaths.get(0));
        }
    }

    private String directsString(List<Object> vertexList) {
        Character[] actions = new Character[vertexList.size() - 1];
        for (int i = 1; i < vertexList.size(); i++) {
            Vertex from = (Vertex) vertexList.get(i - 1);
            Vertex to = (Vertex) vertexList.get(i);
            actions[i - 1] = getDirection(from, to);
        }

        return StringUtils.join(actions, ',');
    }

    private Character getDirection(Vertex from, Vertex to) {
        if (from.getY() > to.getY()) {
            return 'u';
        }
        else if (from.getY() < to.getY()) {
            return 'd';
        }
        else if (from.getX() > to.getX()) {
            return 'l';
        }
        else if (from.getX() < to.getX()) {
            return 'r';
        }
        else {
            return null;
        }
    }
}
