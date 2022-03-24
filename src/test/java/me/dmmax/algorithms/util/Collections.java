package me.dmmax.algorithms.util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collections {

    public static List<Integer> generateRandomList(int sizeOfList) {
        return generateRandomList(sizeOfList, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static List<Integer> generateRandomList(int sizeOfList, int minValue, int maxValue) {
        return IntStream.range(0, sizeOfList)
                .mapToObj(it -> ThreadLocalRandom.current().nextInt(minValue, maxValue))
                .collect(Collectors.toList());
    }
}
