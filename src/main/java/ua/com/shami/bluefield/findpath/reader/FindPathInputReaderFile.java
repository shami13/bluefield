package ua.com.shami.bluefield.findpath.reader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {

    List<String> lines;

    public FindPathInputReaderFile(String filePath) throws IOException {
        File file = new File(filePath);
        lines = FileUtils.readLines(file);
    }

    @Override
    String readLine() {
        if (lines.size() <= getLineCounter()) {
            return null;
        }
        return lines.get(getLineCounter());
    }
}
