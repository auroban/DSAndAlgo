package org.example.auro.leetcode.medium.jumpGame2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class JumpGame2 {

    private static final Logger LOGGER = LogManager.getLogger(JumpGame2.class);

    public int maxJumps(final int[] jumpArray) {
        int lastGoodIndex = jumpArray.length - 1;
        final List<Integer> indexList = new ArrayList<>();
        int optimalMaxCoverage = 0;
        int optimalIndex = lastGoodIndex;
        while (lastGoodIndex > 0) {
            for (int i = lastGoodIndex - 1; i >= 0; i--) {
                if (i + jumpArray[i] >= lastGoodIndex) {
                   final int currentMaxCoverage = lastGoodIndex - i;
                   if (currentMaxCoverage >= optimalMaxCoverage) {
                       optimalMaxCoverage = currentMaxCoverage;
                       optimalIndex = i;
                   }
                }
            }
            indexList.add(optimalIndex);
            lastGoodIndex = optimalIndex;
            optimalMaxCoverage = 0;
        }
        return indexList.size();
    }
}
