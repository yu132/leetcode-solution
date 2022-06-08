package redo.p1800_1899;

public class P1864 {

    class Solution {
        public int minSwaps(String s) {
            if (s.length() % 2 == 1) {
                int c1 = 0;
                for (int i = 0; i < s.length(); ++i) {
                    c1 += s.charAt(i) - '0';
                }
                int match;
                if (c1 == s.length() - c1 - 1) {
                    match = 0;
                } else if (c1 == s.length() - c1 + 1) {
                    match = 1;
                } else {
                    return -1;
                }
                int count = 0;
                for (int i = 0; i < s.length(); ++i, match ^= 1) {
                    if (s.charAt(i) - '0' != match) {
                        ++count;
                    }
                }
                return count / 2;
            } else {
                int count = 0;
                int c1 = 0;
                for (int i = 0; i < s.length(); ++i) {
                    c1 += s.charAt(i) - '0';
                    if (s.charAt(i) - '0' != i % 2) {
                        ++count;
                    }
                }
                if (c1 != s.length() - c1) {
                    return -1;
                }
                return Math.min(count, s.length() - count) / 2;
            }
        }
    }

}
