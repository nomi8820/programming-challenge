package de.bcxp.challenge.io;

import de.bcxp.challenge.model.WeatherRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads daily weather measurements from a CSV file into {@link WeatherRecord} objects.
 */
public final class WeatherCsvReader {

    public List<WeatherRecord> read(Path csvFile) throws IOException {
        List<String> lines = Files.readAllLines(csvFile);
        List<WeatherRecord> records = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(",");
            int day = Integer.parseInt(columns[0].trim());
            int maxTemp = Integer.parseInt(columns[1].trim());
            int minTemp = Integer.parseInt(columns[2].trim());
            records.add(new WeatherRecord(day, maxTemp, minTemp));
        }
        return records;
    }
}