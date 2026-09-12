package de.bcxp.challenge;

import de.bcxp.challenge.model.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryTest {

    @Test
    void getPopulationDensity_computesPopulationOverArea() {
        Country country = new Country("Testland", 100L, 4.0);
        assertEquals(25.0, country.getPopulationDensity(), 0.001);
    }

    @Test
    void constructor_throwsWhenAreaIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Country("Zeroland", 1000L, 0.0));
    }

    @Test
    void constructor_throwsWhenAreaIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Country("Negativeland", 1000L, -50.0));
    }

    @Test
    void constructor_throwsWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Country(null, 1000L, 50.0));
    }

    @Test
    void constructor_throwsWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class,
                () -> new Country("   ", 1000L, 50.0));
    }
}
