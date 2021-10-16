package org.example.auro.leetcode.medium.countAndSay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountAndSayTests {

    private final CountAndSay countAndSay = new CountAndSay();

    @Test
    void test_CorrectOutput() {
        final String expectedOutput = "111221";
        Assertions.assertEquals(expectedOutput, countAndSay.countAndSay(5));
    }

    @Test
    void test_NullString_ForNumberNotInRange() {
        Assertions.assertNull(countAndSay.countAndSay(33));
    }
}
