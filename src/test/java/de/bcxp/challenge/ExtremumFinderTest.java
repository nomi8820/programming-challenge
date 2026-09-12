package de.bcxp.challenge;

import de.bcxp.challenge.service.ExtremumFinder;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExtremumFinderTest {

    @Test
    void findMin_returnsSmallestElement() {
        List<Integer> numbers = List.of(4, 8, 10, 1, 6);

        Integer result = ExtremumFinder.findMin(numbers, n -> n);

        assertEquals(1, result);
    }

    @Test
    void findMax_returnsLargestElement() {
        List<Integer> numbers = List.of(5, 2, 9, 1, 7);

        Integer result = ExtremumFinder.findMax(numbers, n -> n);

        assertEquals(9, result);
    }

    @Test
    void findMin_throwsOnEmptyList() {
        assertThrows(IllegalArgumentException.class,
                () -> ExtremumFinder.findMin(List.of(), (Integer n) -> n));
    }

    @Test
    void findMax_throwsOnEmptyList() {
        assertThrows(IllegalArgumentException.class,
                () -> ExtremumFinder.findMax(List.of(), (Integer n) -> n));
    }
}
