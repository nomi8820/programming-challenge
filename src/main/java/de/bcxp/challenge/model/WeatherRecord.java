package de.bcxp.challenge.model;

/**
 * Represents a single day's weather measurements.
 */
public final class WeatherRecord {
    private final int day;
    private final int maxTemperature;
    private final int minTemperature;

    public WeatherRecord(int day, int maxTemperature, int minTemperature) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    public int getDay() { return day; }

    public int getTemperatureSpread() {
        return maxTemperature - minTemperature;
    }
}