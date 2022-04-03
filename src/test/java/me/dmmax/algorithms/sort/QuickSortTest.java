package me.dmmax.algorithms.sort;

import me.dmmax.algorithms.util.Collections;
import me.dmmax.algorithms.util.StopwatchUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    @ParameterizedTest(name = "Quick sort with size of list = {0}")
    @MethodSource("testCases")
    void testMultipleOptions(int sizeOfList) {
        var generatedList = Collections.generateRandomList(sizeOfList);
        var expectedList = sortedList(generatedList);
        var actualList = StopwatchUtil.trackExecutionTime(
                () -> QuickSort.sort(generatedList),
                "Using quick sort for size of list %d...", sizeOfList);
        assertThat(actualList).isEqualTo(expectedList);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(5),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(1000),
                Arguments.of(10000));
    }

    private static List<Integer> sortedList(List<Integer> inputList) {
        return inputList.stream()
                .sorted(Integer::compare)
                .collect(Collectors.toList());
    }
}