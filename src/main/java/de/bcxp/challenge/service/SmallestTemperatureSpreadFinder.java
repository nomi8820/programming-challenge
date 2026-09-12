package de.bcxp.challenge.service;

import de.bcxp.challenge.model.WeatherRecord;
import java.util.Comparator;
import java.util.List;

/**
 * Identifies the day whose maximum and minimum temperatures were closest together.
 */
public final class SmallestTemperatureSpreadFinder {

    public WeatherRecord findDayWithSmallestSpread(List<WeatherRecord> records) {
        return records.stream()
                .min(Comparator.comparingInt(WeatherRecord::getTemperatureSpread))
                .orElseThrow(() -> new IllegalArgumentException("No weather records provided"));
    }
}