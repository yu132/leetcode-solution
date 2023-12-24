package redo.p0000_0099;

import java.util.Arrays;
import java.util.HashMap;

public class P87 {

    class Solution {

        HashMap<String, Boolean> dp = new HashMap<>();

        public boolean isScramble(String s1, String s2) {
            String key = s1 + " " + s2;
            Boolean b = dp.get(key);
            if (b != null) {
                return b;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            if (s1.length() == 1) {
                return false;
            }
            IntFixedCounter s1L = new IntFixedCounter(0, 26);
            IntFixedCounter s2L = new IntFixedCounter(0, 26);
            IntFixedCounter s2R = new IntFixedCounter(0, 26);
            for (int i = 0; i < s1.length() - 1; ++i) {
                s1L.plus1(s1.charAt(i) - 'a');
                s2L.plus1(s2.charAt(i) - 'a');
                s2R.plus1(s2.charAt(s2.length() - i - 1) - 'a');
                if (s1L.equals(s2L)) {
                    boolean flag =
                            isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
                                    && isScramble(s1.substring(i + 1), s2.substring(i + 1));
                    if (flag) {
                        return true;
                    }
                }
                if (s1L.equals(s2R)) {
                    boolean flag =
                            isScramble(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1))
                                    && isScramble(s1.substring(i + 1), s2.substring(0, s2.length() - i - 1));
                    if (flag) {
                        dp.put(key, true);
                        return true;
                    }
                }
            }
            dp.put(key, false);
            return false;
        }

        class IntFixedCounter {

            int start, arr[];

            IntFixedCounter(int start, int end) {
                this.start = start;
                arr = new int[end - start];
            }

            void plus1(int val) {
                ++arr[val - start];
            }

            void minus1(int val) {
                --arr[val - start];
            }

            void add(int val, int count) {
                arr[val - start] += count;
            }

            int get(int val) {
                if (val - start < 0 || val - start >= arr.length) {
                    return 0;
                }
                return arr[val - start];
            }

            boolean equals(IntFixedCounter fixedCounter) {
                return Arrays.equals(arr, fixedCounter.arr);
            }
        }
    }

    public static void main(String[] args) {
        boolean ans = new P87().new Solution().isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd");
        System.out.println(ans);

    }


}
