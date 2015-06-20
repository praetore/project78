package mcconverter.exporter;

import mcconverter.coordinates.Coordinate;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by darryl on 20-6-15.
 */
abstract class BaseExporter {
    protected final Path exportPath;
    protected final String importPath;

    public BaseExporter(Path exportPath, String importPath) {
        this.exportPath = exportPath;
        this.importPath = importPath;
    }

    public void exportData(List<Coordinate> coordinates) {
        File output = exportPath.toFile();
        try {
            FileOutputStream fos = new FileOutputStream(output);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (Coordinate coordinate : coordinates) {
                bw.write(coordinate.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}