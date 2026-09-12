package de.bcxp.challenge;

import de.bcxp.challenge.io.CountryRowMapper;
import de.bcxp.challenge.io.CsvRecordReader;
import de.bcxp.challenge.io.RecordReader;
import de.bcxp.challenge.io.WeatherRowMapper;
import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.WeatherRecord;
import de.bcxp.challenge.service.ExtremumFinder;

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

        RecordReader<WeatherRecord> weatherReader = new CsvRecordReader<>(",", new WeatherRowMapper());
        List<WeatherRecord> weatherRecords = weatherReader.readAll(Path.of("src/main/resources/de/bcxp/challenge/weather.csv"));
        WeatherRecord smallestSpreadDay = ExtremumFinder.findMin(weatherRecords, WeatherRecord::getTemperatureSpread);
        System.out.printf("Day with smallest temperature spread: %d%n", smallestSpreadDay.getDay());

        RecordReader<Country> countryReader = new CsvRecordReader<>(";", new CountryRowMapper());
        List<Country> countries = countryReader.readAll(Path.of("src/main/resources/de/bcxp/challenge/countries.csv"));
        Country densestCountry = ExtremumFinder.findMax(countries, Country::getPopulationDensity);
        System.out.printf("Country with highest population density: %s%n", densestCountry.getName());
    }
}
