package de.bcxp.challenge;

import de.bcxp.challenge.io.CountryRowMapper;
import de.bcxp.challenge.model.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryRowMapperTest {

    private final CountryRowMapper mapper = new CountryRowMapper();

    @Test
    void map_parsesPlainNumberCorrectly() {
        String[] row = {"Austria", "Vienna", "1995", "8926000", "83855", "447718", "0.922", "19"};

        Country country = mapper.map(row);

        assertEquals("Austria", country.getName());
        assertEquals(8926000L / 83855.0, country.getPopulationDensity(), 0.001);
    }

    @Test
    void map_parsesGermanFormattedPopulation() {
        // Croatia's population is written "4.036.355,00" in a German-locale number formatting
        String[] row = {"Croatia", "Zagreb", "2013", "4.036.355,00", "56594", "60702", "0.851", "12"};

        Country country = mapper.map(row);

        assertEquals("Croatia", country.getName());
        assertEquals(4036355L / 56594.0, country.getPopulationDensity(), 0.001);
    }

    @Test
    void map_throwsOnInvalidPopulationValue() {
        String[] row = {"Testland", "Testcity", "2000", "not-a-number", "100", "500", "0.9", "5"};
        assertThrows(IllegalArgumentException.class, () -> mapper.map(row));
    }

    @Test
    void map_trimsWhitespaceAroundCountryName() {
        String[] row = {" France ", "Paris", "Founder", "67439614", "632833", "2707074", "0.901", "79"};
        Country country = mapper.map(row);
        assertEquals("France", country.getName());
    }
}
