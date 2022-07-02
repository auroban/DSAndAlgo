package org.example.auro.leetcode.hard.medianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

class ArrayUtils {

    static double findMedianOfSortedArrays(final int[] arr1, final int[] arr2) {
        int i = 0;
        int j = 0;
        final int[] newArr = new int[arr1.length + arr2.length];
        int k = 0;
        while (k < newArr.length && i < arr1.length && j < arr2.length) {
            final int n1 = arr1[i];
            final int n2 = arr2[j];

            if (n1 < n2) {
                newArr[k++] = n1;
                i++;
            } else if (n1 > n2) {
                newArr[k++] = n2;
                j++;
            } else {
                newArr[k++] = n1;
                newArr[k++] = n2;
                i++; j++;
            }
        }

        if (!(i < arr1.length)) {
            while (k < newArr.length) {
                newArr[k++] = arr2[j++];
            }
        }

        if (!(j < arr2.length)) {
            while (k < newArr.length) {
                newArr[k++] = arr1[i++];
            }
        }

        System.out.println(readArray(newArr));

        final boolean isEven = ((newArr.length % 2) == 0);
        final int mid = (newArr.length - 1) / 2;

        if (isEven) {
            final int med1 = newArr[mid];
            final int med2 = newArr[mid+1];
            final double res = med1 + med2;
            return (res / 2);
        } else {
            return newArr[mid];
        }
    }

    private static String readArray(final int[] arr) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            if (!(i == (arr.length - 1))) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
