package org.example.auro.leetcode.medium.multiplyStrings;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiplyStringsTests {

    private final MultiplyStrings multiplyStrings = new MultiplyStrings();

    @Test
    void test_CorrectOutput() {
        final String expectedOutput = "56088";
        final String num1 = "123";
        final String num2 = "456";
        Assertions.assertEquals(expectedOutput, multiplyStrings.multiplyStrings(num1, num2));
    }

}
