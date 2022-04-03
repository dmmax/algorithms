package me.dmmax.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private QuickSort() {
        // Utility class
    }

    public static List<Integer> sort(List<Integer> inputList) {
        if (inputList.size() < 2) {
            return inputList;
        }
        // Start from middle
        var pivotIdx = inputList.size() / 2;
        var pivot = inputList.get(pivotIdx);
        var lower = new ArrayList<Integer>();
        var greaterOrEqual = new ArrayList<Integer>();
        for (int idx = 0; idx < inputList.size(); idx++) {
            if (idx == pivotIdx) {
                continue;
            }
            var value = inputList.get(idx);
            if (value < pivot) {
                lower.add(value);
            } else {
                greaterOrEqual.add(value);
            }
        }
        var result = new ArrayList<>(sort(lower));
        result.add(pivot);
        result.addAll(sort(greaterOrEqual));
        return result;
    }
}
