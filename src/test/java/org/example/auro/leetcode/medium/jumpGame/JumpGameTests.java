package org.example.auro.leetcode.medium.jumpGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpGameTests {

    private final JumpGame jumpGame = new JumpGame();

    @Test
    void test_CorrectOutput() {
        final int[] jumpArray = {2, 3, 1, 1, 4};
        Assertions.assertTrue(jumpGame.canJump(jumpArray));
    }
}
