package org.example.auro.leetcode.medium.multiplyStrings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    private static final Logger LOGGER = LogManager.getLogger(MultiplyStrings.class);

    public String multiplyStrings(final String num1, final String num2) {
        LOGGER.info("Received Numbers: {} and {}", num1, num2);
        if (num1 == null || num2 == null || (num1.length() < 1 || num1.length() > 200) || (num2.length() < 1 || num2.length() > 200) || num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        List<Integer> finalList = null;
        final char[] smaller = num1.length() <= num2.length() ? num1.toCharArray() : num2.toCharArray();
        final char[] bigger = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        int power = 0;
        for (int i = smaller.length - 1; i >= 0; i--) {
            final int m = smaller[i] - '0';
            final List<Integer> tempList = new ArrayList<>();
            for (int t = 0; t < power; t++)  {
                tempList.add(0);
            }
            int carry = 0;
            for (int j = bigger.length - 1; j >= 0; j--) {
                final int n = bigger[j] - '0';
                final int prod = (m * n) + carry;
                final int res = prod % 10;
                carry = prod / 10;
                tempList.add(res);
            }
            if (carry > 0) {
                tempList.add(carry);
            }

            finalList = addList(finalList, tempList);
            LOGGER.info("Final List after iteration: {}", finalList);
            power++;
        }
        final var stringBuilder = new StringBuilder();
        if (finalList != null && finalList.size() > 0) {
            for (int i = finalList.size() - 1; i >= 0; i--) {
                stringBuilder.append(finalList.get(i));
            }
        }
        return stringBuilder.toString();
    }

    private List<Integer> addList(final List<Integer> finalList, final List<Integer> tempList) {
       LOGGER.info("Adding List: {} with List: {}", finalList, tempList);
       if (finalList == null) {
           return tempList;
       }
       final var smallerList = finalList.size() <= tempList.size() ? finalList : tempList;
       final var biggerList = finalList.size() > tempList.size() ? finalList : tempList;
       final var resultList = new ArrayList<Integer>();
       var carry = 0;
       for (int i = 0; i < smallerList.size(); i++) {
           final int a = smallerList.get(i);
           final int b = biggerList.get(i);
           final int result = a + b + carry;
           resultList.add((result) % 10);
           carry = result / 10;
       }
       if (resultList.size() < biggerList.size()) {
           final int index = resultList.size();
           for (int i = index; i < biggerList.size(); i++) {
               final int addition = biggerList.get(i) + carry;
               final int res = addition % 10;
               resultList.add(res);
               carry = addition / 10;
           }
       }

       if (carry > 0) {
           resultList.add(carry);
       }
       LOGGER.info("Result List before returning: {}", resultList);
       return resultList;
    }
}
