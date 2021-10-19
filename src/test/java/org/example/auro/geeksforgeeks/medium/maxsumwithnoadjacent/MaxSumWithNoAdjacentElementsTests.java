package org.example.auro.geeksforgeeks.medium.maxsumwithnoadjacent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSumWithNoAdjacentElementsTests {

    private final MaxSumWithNoAdjacentElements maxSumWithNoAdjacentElements = new MaxSumWithNoAdjacentElements();

    @Test
    void test_CorrectOutput() {
        final int[] array = { 5, 5, 10, 100, 10, 5, 5 };
        Assertions.assertEquals(110, maxSumWithNoAdjacentElements.findMax(array));
    }

    @Test
    void test_CorrectOutput_UsingDP() {
        final int[] array = { 5, 5, 10, 100, 10, 5, 5 };
        Assertions.assertEquals(110, maxSumWithNoAdjacentElements.findMaxUsingDP(array));
    }
}
