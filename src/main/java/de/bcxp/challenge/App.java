package de.bcxp.challenge;

import de.bcxp.challenge.io.WeatherCsvReader;
import de.bcxp.challenge.model.WeatherRecord;
import de.bcxp.challenge.service.SmallestTemperatureSpreadFinder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws IOException {

        Path weatherFile = Path.of("src/main/resources/de/bcxp/challenge/weather.csv");

        WeatherCsvReader reader = new WeatherCsvReader();
        List<WeatherRecord> records = reader.read(weatherFile);

        SmallestTemperatureSpreadFinder finder = new SmallestTemperatureSpreadFinder();
        WeatherRecord result = finder.findDayWithSmallestSpread(records);

        System.out.printf("Day with smallest temperature spread: %d%n", result.getDay());

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
