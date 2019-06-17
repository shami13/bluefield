package ua.com.shami.bluefield.findpath;

import ua.com.shami.bluefield.findpath.graph.Solver;
import ua.com.shami.bluefield.findpath.reader.AbstractFindPathInputReader;
import ua.com.shami.bluefield.findpath.reader.FindPathInputReaderFile;
import ua.com.shami.bluefield.findpath.reader.FindPathInputReaderStdIn;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        if (Objects.nonNull(args) && args.length > 0) {

            AbstractFindPathInputReader findPathInputReader;

            if (checkIsFilePath(args[0])) {
                findPathInputReader = new FindPathInputReaderFile(args[0]);
            }
            else {
                findPathInputReader = new FindPathInputReaderStdIn(args);
            }

            Solver solver = findPathInputReader.parseInputToSolver();

            System.out.println(solver.solve());
        }
    }

    private static boolean checkIsFilePath(String arg) {
        File file = new File(arg);
        return file.exists();
    }
}
