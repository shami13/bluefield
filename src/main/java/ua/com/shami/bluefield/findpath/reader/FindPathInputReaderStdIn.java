package ua.com.shami.bluefield.findpath.reader;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {
    private String[] lines;

    public FindPathInputReaderStdIn(String[] lines) {
        this.lines = lines;
    }

    @Override
    String readLine() {
        if (lines.length <= getLineCounter()) {
            return null;
        }

        return lines[getLineCounter()];
    }
}
