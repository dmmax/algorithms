package me.dmmax.algorithms.examples;

import java.util.List;

public class RecursiveExamples {

    private RecursiveExamples() {
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

    public static int sizeOfListRecursive(List<Integer> integers) {
        if (integers.isEmpty()) {
            return 0;
        }
        int sizeOfList = 1;
        var sublist = integers.subList(1, integers.size());
        if (sublist.isEmpty()) {
            return sizeOfList;
        }
        return sizeOfList + sizeOfListRecursive(sublist);
    }

    public static int findMaxNumberRecursive(List<Integer> integers) {
        if (integers.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        var firstValue = integers.get(0);
        var sublist = integers.subList(1, integers.size());
        if (sublist.isEmpty()) {
            return firstValue;
        }
        var nextValue = findMaxNumberRecursive(sublist);
        return firstValue >= nextValue ? firstValue : nextValue;
    }

    public static int binarySearchRecursive(List<Integer> sortedIntegers, int valueToFind) {
        var low = 0;
        var high = sortedIntegers.size() - 1;
        return binarySearchRecursive(sortedIntegers, valueToFind, low, high);
    }

    private static int binarySearchRecursive(List<Integer> sortedIntegers, int valueToFind, int low, int high) {
        if (low <= high) {
            var mid = (low + high) / 2;
            var value = sortedIntegers.get(mid);
            if (value == valueToFind) {
                return mid;
            }
            if (value > valueToFind) {
                high = mid - 1;
                return binarySearchRecursive(sortedIntegers, valueToFind, low, high);
            }
            low = mid + 1;
            return binarySearchRecursive(sortedIntegers, valueToFind, low, high);
        }
        return -1;
    }
}
