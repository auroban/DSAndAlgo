package org.example.auro.leetcode.medium.countAndSay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Problem Statement: https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    private static final Logger LOGGER = LogManager.getLogger(CountAndSay.class);
    private static final Integer LOWER_LIMIT = 1;
    private static final Integer UPPER_LIMIT = 30;

    public String countAndSay(final Integer number) {
        if (number < LOWER_LIMIT || number > UPPER_LIMIT) {
            LOGGER.warn("Number {} is not with the ranger {} - {}", number, LOWER_LIMIT, UPPER_LIMIT);
            return null;
        }
        LOGGER.info("Received Number: {}", number);
        final Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= number; i++) {
            if (i == 1) {
                map.put(i, "1");
            } else {
                map.put(i, processNumber(map.get(i-1)));
            }
        }
        LOGGER.info("Map: {}", map);
        return map.get(number);
    }

    private String processNumber(final String numberString) {
        LOGGER.info("Received Number String: {}", numberString);
        final var stringBuilder = new StringBuilder("");
        if (numberString != null && numberString.length() > 0) {
            final char[] chars = numberString.toCharArray();
            int key = chars[0] - '0';
            int rep = 1;
            for (int i = 1; i < chars.length; i++) {
                final int n = chars[i] - '0';
                LOGGER.info("Current Key: {}", key);
                LOGGER.info("Current Repetition: {}", rep);
                LOGGER.info("Current Digit: {}", n);
                if (n == key) {
                    rep++;
                } else {
                    LOGGER.info("Found a different Key");
                    stringBuilder.append(rep).append(key);
                    key = n;
                    rep = 1;
                }
            }
            stringBuilder.append(rep).append(key);
        }
        LOGGER.info("String: {}", stringBuilder);
        return stringBuilder.toString();
    }
}
