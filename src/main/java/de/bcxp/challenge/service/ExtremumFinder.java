package de.bcxp.challenge.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Finds the element in a list with the smallest or largest value of some derived measure.
 */
public final class ExtremumFinder {

    public static <T, R extends Comparable<R>> T findMin(List<T> items, Function<T, R> keyExtractor) {
        return items.stream()
                .min(Comparator.comparing(keyExtractor))
                .orElseThrow(() -> new IllegalArgumentException("No items provided"));
    }

    public static <T, R extends Comparable<R>> T findMax(List<T> items, Function<T, R> keyExtractor) {
        return items.stream()
                .max(Comparator.comparing(keyExtractor))
                .orElseThrow(() -> new IllegalArgumentException("No items provided"));
    }
}