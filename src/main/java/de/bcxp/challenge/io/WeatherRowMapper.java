package de.bcxp.challenge.io;

import de.bcxp.challenge.model.WeatherRecord;

/**
 * Maps a weather CSV row into a {@link WeatherRecord}.
 */
public final class WeatherRowMapper implements RowMapper<WeatherRecord> {
    @Override
    public WeatherRecord map(String[] columns) {
        int day = Integer.parseInt(columns[0].trim());
        int maxTemp = Integer.parseInt(columns[1].trim());
        int minTemp = Integer.parseInt(columns[2].trim());
        return new WeatherRecord(day, maxTemp, minTemp);
    }
}