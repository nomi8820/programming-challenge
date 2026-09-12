package de.bcxp.challenge.model;

/**
 * A country's identifying data and geography, used to compute population density.
 */
public final class Country {
    private final String name;
    private final long population;
    private final double area;

    public Country(String name, long population, double area) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Country name must not be blank");
        }
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be positive, was: " + area);
        }
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() { return name; }

    public double getPopulationDensity() {
        return population / area;
    }
}