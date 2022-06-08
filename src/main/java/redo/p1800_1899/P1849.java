package redo.p1800_1899;

public class P1849 {

    class Solution {
        public boolean splitString(String s) {
            return helper(s, 0, 0, 0, 0);
        }

        public boolean helper(String s, int start, int p1, long p2, int level) {
            if (start == s.length()) {
                return level != 1;
            }
            if (p2 < 0) {
                return false;
            }
            for (int i = start + 1; i <= s.length(); ++i) {
                long val = val(s, start, i);
                if (val * p1 == p2 && helper(s, i, 1, val - 1, level + 1)) {
                    return true;
                }
            }
            return false;
        }

        public long val(String s, int start, int i) {
            try {
                return Long.parseLong(s.substring(start, i));
            } catch (Exception e) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new P1849().new Solution().splitString("005040003"));
        System.out.println(Long.MAX_VALUE);
    }
}
