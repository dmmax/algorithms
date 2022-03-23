package me.dmmax.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    private SelectionSort() {
        // Utility class
    }

    public static List<Integer> sort(List<Integer> inputList) {
        List<Integer> sortedList = new ArrayList<>();
        while (!inputList.isEmpty()) {
            var smallestIndex = findSmallestIndex(inputList);
            sortedList.add(inputList.remove(smallestIndex));
        }
        return sortedList;
    }

    private static int findSmallestIndex(List<Integer> inputList) {
        var smallestIndex = 0;
        var smallestValue = inputList.get(0);
        // Skipping the index zero because it was handled before loop
        for (var idx = 1; idx < inputList.size(); idx++) {
            var value = inputList.get(idx);
            if (value < smallestValue) {
                smallestValue = value;
                smallestIndex = idx;
            }
        }
        return smallestIndex;
    }
}
