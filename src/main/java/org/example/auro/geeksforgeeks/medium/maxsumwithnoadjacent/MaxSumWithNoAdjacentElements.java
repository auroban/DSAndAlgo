package org.example.auro.geeksforgeeks.medium.maxsumwithnoadjacent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxSumWithNoAdjacentElements {

    private static final Logger LOGGER = LogManager.getLogger(MaxSumWithNoAdjacentElements.class);


    public Integer findMax(final int[] array) {
        LOGGER.info("Received Array: {}", array);
        if (array == null || array.length == 0) {
            return null;
        }
        return findMax(array, 0, array.length - 1);
    }

    public Integer findMaxUsingDP(final int[] array) {
        if (array == null || array.length == 0 || array.length == 2) {
            return null;
        }
        if (array.length == 1) {
            return array[0];
        }
        final int[] dpArray = new int[array.length];
        dpArray[0] = array[0];
        dpArray[1] = array[1];
        for (int i = 2; i < array.length; i++) {
            dpArray[i] = Math.max(dpArray[i-1], dpArray[i-2] + array[i]);
        }
        return dpArray[array.length - 1];
    }

    private Integer findMax(final int[] array, final int low, final int high) {
        if (low == high) {
            return array[low];
        }
        int max = array[low];
        for (int i = low; i <= high; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (i + 2 <= high) {
                final int val = array[i] + findMax(array, i+2, high);
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }
}
