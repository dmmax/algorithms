package me.dmmax.algorithms.examples;

import me.dmmax.algorithms.util.Collections;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void testSum(int sizeOfList) {
        var generatedList = Collections.generateRandomList(sizeOfList, 10, 30);
        var sumLoop = Sum.sumLoop(generatedList);
        var sumRecursive = Sum.sumRecursive(generatedList);
        assertThat(sumLoop).isEqualTo(sumRecursive);
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
}