package ua.com.shami.bluefield.findpath.graph;

import org.junit.Test;
import ua.com.shami.bluefield.findpath.reader.FindPathInputReaderFile;
import ua.com.shami.bluefield.findpath.reader.FindPathInputReaderStdIn;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void solveSimpleRightCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(new String[]{"SX"});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("r", solver.solve());
    }

    @Test
    public void solveSimpleLeftCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(new String[]{"XS"});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("l", solver.solve());
    }

    @Test
    public void solveSimpleUpCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(new String[]{"X", "S"});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("u", solver.solve());
    }

    @Test
    public void solveSimpleDownCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(new String[]{"S", "X"});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("d", solver.solve());
    }

    @Test
    public void solveSimpleRightWithProblemCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(
                new String[]{"S.", "#.", "X."});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("r,d,d,l", solver.solve());
    }

    @Test
    public void solveSimpleLeftWithProblemCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(
                new String[]{".S", ".#", ".X"});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("l,d,d,r", solver.solve());
    }

    @Test
    public void solveSimpleUpWithProblemCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(new String[]{"...", "S#X"});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("u,r,r,d", solver.solve());
    }

    @Test
    public void solveSimpleDownWithProblemCase() {
        FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn(new String[]{"S#X", "..."});
        Solver solver = findPathInputReaderStdIn.parseInputToSolver();
        assertEquals("d,r,r,u", solver.solve());
    }

    @Test
    public void testTask() throws IOException {
        URL resource = this.getClass().getResource("test.in");

        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile(resource.getPath());
        Solver solver = findPathInputReaderFile.parseInputToSolver();

        assertEquals("r,r,d,r,d,r,r,r,r,r,r,r,r,r,r,r,r,d,r,r,r,r,r,d,d,r,d,d,r,r,d,d,d,r", solver.solve());
    }
}
