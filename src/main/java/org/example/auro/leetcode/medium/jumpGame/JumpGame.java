package org.example.auro.leetcode.medium.jumpGame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Problem Statement: https://leetcode.com/problems/jump-game/
 * Explanation: https://www.youtube.com/watch?v=Zb4eRjuPHbM&ab_channel=NickWhite
 */
public class JumpGame {

    private static final Logger LOGGER = LogManager.getLogger(JumpGame.class);

    public boolean canJump(final int[] jumpArray) {
        if (jumpArray.length < 1 || jumpArray.length > 10000) {
            return false;
        }
//        return canJumpRecursive(jumpArray, 0);
        return canJumpLinear(jumpArray);
    }

    private boolean canJumpRecursive(final int[] jumpArray, final int index) {
        LOGGER.info("Received Array: {} and Index: {}", toString(jumpArray), index);
        if (index == jumpArray.length - 1) {
            return true;
        }
        final int maxJumps = jumpArray[index];
        for (int i = 1; i <= maxJumps; i++) {
            if (canJumpRecursive(jumpArray, index + i)) {
                return true;
            }
        }
        return false;
    }

    private boolean canJumpLinear(final int[] jumpArray) {
        int lastGoodIndex = jumpArray.length - 1;
        for (int i = jumpArray.length - 1; i >= 0; i--) {
            if (i + jumpArray[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }

    private String toString(final int[] integers) {
        final var strBuilder = new StringBuilder("{");
        for (int i = 0; i < integers.length; i++) {
            strBuilder.append(" ").append(integers[i]);
            if (i != integers.length - 1) {
                strBuilder.append(", ");
            }
        }
        strBuilder.append(" }");
        return strBuilder.toString();
    }
}
