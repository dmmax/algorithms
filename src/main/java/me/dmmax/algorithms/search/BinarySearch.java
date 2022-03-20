package me.dmmax.algorithms.search;

import java.util.List;

public class BinarySearch {

    private BinarySearch() {
        // Utility class
    }

    public static int search(List<Integer> sortedIntegers, int valueToFind) {
        var low = 0;
        var high = sortedIntegers.size() - 1;
        while (low <= high) {
            var mid = (low + high) / 2;
            var value = sortedIntegers.get(mid);
            if (value == valueToFind) {
                return mid;
            } else if (value > valueToFind) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
