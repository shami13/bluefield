package ua.com.shami.bluefield.findpath.reader;

import es.usc.citius.hipster.graph.GraphBuilder;
import org.apache.commons.lang3.StringUtils;
import ua.com.shami.bluefield.findpath.graph.Solver;
import ua.com.shami.bluefield.findpath.graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFindPathInputReader {

    private static final int DEFAULT_WEIGHT_OF_EDGE = 1;
    private GraphBuilder<Vertex, Integer> graphBuilder = GraphBuilder.<Vertex, Integer>create();
    private Vertex start;
    private Vertex finish;
    private List<Vertex> previousLine = null;
    private Integer lineCounter = 0;

    protected Integer getLineCounter() {
        return lineCounter;
    }

    private void parseLine(String line) {
        List<Vertex> currentLine = new ArrayList<>(line.length());
        for (int i = 0; i < line.length(); i++) {
            char label = line.charAt(i);
            if (label == '#') {
                currentLine.add(null);
                continue;
            }

            Vertex vertex = new Vertex(i, lineCounter, label);
            currentLine.add(vertex);

            if (start == null && label == 'S') {
                start = vertex;
            }

            if (finish == null && label == 'X') {
                finish = vertex;
            }

            if (i != 0 && Objects.nonNull(currentLine.get(i - 1))) {
                graphBuilder.connect(currentLine.get(i - 1)).to(vertex).withEdge(DEFAULT_WEIGHT_OF_EDGE);
            }

            if (Objects.nonNull(previousLine) && Objects.nonNull(previousLine.get(i))) {
                graphBuilder.connect(previousLine.get(i)).to(vertex).withEdge(1);
            }
        }

        lineCounter++;
        previousLine = currentLine;
    }

    public Solver parseInputToSolver() {
        String line = readLine();
        while (StringUtils.isNotBlank(line)) {
            parseLine(line);
            line = readLine();
        }

        Solver solver = new Solver(graphBuilder.createUndirectedGraph(), start, finish);
        return solver;
    }

    abstract String readLine();
}
