package me.dmmax.algorithms.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    private static final List<Integer> TEST_LIST = List.of(1, 2, 3, 4, 5);

    @ParameterizedTest
    @MethodSource("testCases")
    void testMultipleOptions(List<Integer> sortedList, int valueToFind, int expectedValue) {
        assertThat(BinarySearch.search(sortedList, valueToFind)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(TEST_LIST, 1, 0),
                Arguments.of(TEST_LIST, 2, 1),
                Arguments.of(TEST_LIST, 3, 2),
                Arguments.of(TEST_LIST, 4, 3),
                Arguments.of(TEST_LIST, 5, 4),
                Arguments.of(TEST_LIST, 6, -1),
                Arguments.of(List.of(), 7, -1));
    }
}
