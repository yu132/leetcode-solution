package redo.p1900_1999;

public class P1941 {

    class Solution {
        public boolean areOccurrencesEqual(String s) {
            int[] counter = new int[26];

            for (char ch : s.toCharArray()) {
                ++counter[ch - 'a'];
            }

            int value = 0;

            for (int val : counter) {
                if (val == 0) {
                    continue;
                }
                if (value == 0) {
                    value = val;
                }
                if (value != val) {
                    return false;
                }
            }

            return true;
        }
    }

}
