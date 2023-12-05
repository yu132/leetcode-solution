package redo.p2700_2799;

import java.util.HashSet;
import java.util.Set;

public class P2767 {
    static
            //

    class Solution {

        static Set<Integer> table = new HashSet<>();

        static {
            int[] temp = new int[]{1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125};
            for (int num : temp) {
                table.add(num);
            }
        }

        public int minimumBeautifulSubstrings(String s) {
            return backtrack(0, 0, s);
        }

        int backtrack(int num, int index, String s) {
            if (index == s.length()) {
                if (table.contains(num)) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (num == 0 && s.charAt(index) == '0') {
                return -1;
            }
            int val = backtrack(num * 2 + s.charAt(index) - '0', index + 1, s);
            if (val != -1) {
                return val;
            }
            if (table.contains(num) && s.charAt(index) != '0') {
                val = backtrack(s.charAt(index) - '0', index + 1, s);
                if (val != -1) {
                    return val + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        new Solution().minimumBeautifulSubstrings("101011");
    }

}
