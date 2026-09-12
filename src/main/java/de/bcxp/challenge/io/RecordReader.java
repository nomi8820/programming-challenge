package de.bcxp.challenge.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Reads a data source into a list of typed records.
 */
public interface RecordReader<T> {
    List<T> readAll(Path source) throws IOException;
}
