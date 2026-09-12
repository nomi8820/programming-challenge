package de.bcxp.challenge.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads a delimited text file (like CSV) and uses a RowMapper to turn each row into an object.
 */
public final class CsvRecordReader<T> implements RecordReader<T> {

    private final String delimiter;
    private final RowMapper<T> rowMapper;

    public CsvRecordReader(String delimiter, RowMapper<T> rowMapper) {
        this.delimiter = delimiter;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<T> readAll(Path source) throws IOException {
        List<String> lines = Files.readAllLines(source, StandardCharsets.UTF_8);
        List<T> records = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(delimiter);
            records.add(rowMapper.map(columns));
        }
        return records;
    }
}
