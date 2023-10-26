package redo.contest.lccup;

import java.util.Arrays;

public class ZP01 {

    class Solution {
        public int runeReserve(int[] runes) {
            Arrays.sort(runes);
            int last = -2;
            int length = 0;
            int max = 0;
            for (int rune : runes) {
                if (Math.abs(rune - last) <= 1) {
                    ++length;
                    last = rune;
                } else {
                    max = Math.max(max, length);
                    last = rune;
                    length = 1;
                }
            }
            return Math.max(max, length);
        }
    }

}
