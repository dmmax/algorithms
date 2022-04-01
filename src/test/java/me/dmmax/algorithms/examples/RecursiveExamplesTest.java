package me.dmmax.algorithms.examples;

import me.dmmax.algorithms.util.Collections;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveExamplesTest {

    private static final List<Integer> TEST_LIST = List.of(1, 2, 3, 4, 5);

    @ParameterizedTest
    @MethodSource("testCases")
    void testSum(int sizeOfList) {
        var generatedList = Collections.generateRandomList(sizeOfList, 10, 30);
        var sumLoop = RecursiveExamples.sumLoop(generatedList);
        var sumRecursive = RecursiveExamples.sumRecursive(generatedList);
        assertThat(sumLoop).isEqualTo(sumRecursive);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testSizeOfListRecursive(int sizeOfList) {
        var generatedList = Collections.generateRandomList(sizeOfList, 10, 30);
        assertThat(RecursiveExamples.sizeOfListRecursive(generatedList)).isEqualTo(sizeOfList);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindMaxNumberRecursive(int sizeOfList) {
        var generatedList = Collections.generateRandomList(sizeOfList, 10, 30);
        var maxValue = generatedList.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        assertThat(RecursiveExamples.findMaxNumberRecursive(generatedList)).isEqualTo(maxValue);
    }

    @ParameterizedTest
    @MethodSource("binarySearchTestCases")
    void testBinarySearchRecursive(List<Integer> sortedIntegers, int valueToFind, int expectedValue) {
        assertThat(RecursiveExamples.binarySearchRecursive(sortedIntegers, valueToFind)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(5),
                Arguments.of(10),
                Arguments.of(50),
                Arguments.of(100));
    }

    private static Stream<Arguments> binarySearchTestCases() {
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