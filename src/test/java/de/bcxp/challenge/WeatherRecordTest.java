package de.bcxp.challenge;

import de.bcxp.challenge.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherRecordTest {

    @Test
    void getTemperatureSpread_computesMaxMinusMin() {
        WeatherRecord record = new WeatherRecord(1, 80, 50);
        assertEquals(30, record.getTemperatureSpread());
    }

    @Test
    void getTemperatureSpread_isZeroWhenMaxEqualsMin() {
        WeatherRecord record = new WeatherRecord(1, 60, 60);
        assertEquals(0, record.getTemperatureSpread());
    }

    @Test
    void getTemperatureSpread_handlesNegativeTemperatures() {
        WeatherRecord record = new WeatherRecord(1, -5, -20);
        assertEquals(15, record.getTemperatureSpread());
    }
}