package de.bcxp.challenge;

import de.bcxp.challenge.io.WeatherRowMapper;
import de.bcxp.challenge.model.WeatherRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherRowMapperTest {

    private final WeatherRowMapper mapper = new WeatherRowMapper();

    @Test
    void map_parsesRowCorrectly() {
        String[] row = {"1", "88", "59", "74", "53.8", "0", "280", "9.6", "270", "17", "1.6", "93", "23", "1004.5"};

        WeatherRecord record = mapper.map(row);

        assertEquals(1, record.getDay());
        assertEquals(29, record.getTemperatureSpread());
    }

    @Test
    void map_throwsOnNonNumericTemperature() {
        String[] row = {"1", "abc", "59"};
        assertThrows(NumberFormatException.class, () -> mapper.map(row));
    }
}
