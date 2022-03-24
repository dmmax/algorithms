package me.dmmax.algorithms.examples;

import java.util.List;

public class Sum {

    private Sum() {
        // Utility class
    }

    public static int sumLoop(List<Integer> integers) {
        var total = 0;
        for (var value : integers) {
            total += value;
        }
        return total;
    }

    public static int sumRecursive(List<Integer> integers) {
        if (integers.isEmpty()) {
            return 0;
        }
        var firstValue = integers.get(0);
        var sublist = integers.subList(1, integers.size());
        if (sublist.isEmpty()) {
            return firstValue;
        }
        return firstValue + sumRecursive(sublist);
    }
}
