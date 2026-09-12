package de.bcxp.challenge;

import de.bcxp.challenge.io.CsvRecordReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvRecordReaderTest {

    @Test
    void readAll_skipsHeaderAndAppliesDelimiter(@TempDir Path tempDir) throws IOException {
        Path csvFile = tempDir.resolve("test.csv");
        Files.writeString(csvFile, "header1;header2\nfoo;bar\nbaz;qux\n");

        CsvRecordReader<String> reader = new CsvRecordReader<>(";", columns -> columns[0] + "-" + columns[1]);
        List<String> result = reader.readAll(csvFile);

        assertEquals(List.of("foo-bar", "baz-qux"), result);
    }

    @Test
    void readAll_returnsEmptyListWhenOnlyHeaderPresent(@TempDir Path tempDir) throws IOException {
        Path csvFile = tempDir.resolve("test.csv");
        Files.writeString(csvFile, "header1;header2\n");

        CsvRecordReader<String> reader = new CsvRecordReader<>(";", columns -> columns[0]);
        List<String> result = reader.readAll(csvFile);

        assertEquals(List.of(), result);
    }
}
