package de.bcxp.challenge.io;

import de.bcxp.challenge.model.Country;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Maps a country CSV row into a {@link Country}, tolerating European-formatted numbers.
 */
public final class CountryRowMapper implements RowMapper<Country> {

    private static final NumberFormat GERMAN_NUMBER_FORMAT = NumberFormat.getInstance(Locale.GERMANY);

    @Override
    public Country map(String[] columns) {
        String name = columns[0].trim();
        long population = parseNumber(columns[3]);
        double area = parseNumber(columns[4]);
        return new Country(name, population, area);
    }

    private long parseNumber(String raw) {
        try {
            return GERMAN_NUMBER_FORMAT.parse(raw.trim()).longValue();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid numeric value: " + raw, e);
        }
    }
}
