package de.bcxp.challenge.io;

/**
 * Turns one row of a file into an object (Country or WeatherRecord).
 */
public interface RowMapper<T> {
    T map(String[] columns);
}
