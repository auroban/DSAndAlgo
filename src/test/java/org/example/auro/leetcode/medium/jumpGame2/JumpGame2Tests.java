package org.example.auro.leetcode.medium.jumpGame2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpGame2Tests {

    private final JumpGame2 jumpGame2 = new JumpGame2();

    @Test
    void test_CorrectOutput() {
        final int[] jumpArray = { 2, 3, 1 };
        Assertions.assertEquals(1, jumpGame2.maxJumps(jumpArray));
    }

}
