package redo.p2700_2799;

public class P2730 {

    class Solution {
        public int longestSemiRepetitiveSubstring(String s) {
            int l = 0, r = 1, mid;
            while (r < s.length() && s.charAt(r) != s.charAt(r - 1)) {
                ++r;
            }
            mid = r;
            if (r != s.length()) {
                ++r;
            }
            int ans = 0;
            for (; r < s.length(); ) {
                while (r < s.length() && s.charAt(r) != s.charAt(r - 1)) {
                    ++r;
                }
                if (r == s.length()) {
                    break;
                }
                ans = Math.max(ans, r - l);
                l = mid;
                mid = r;
                ++r;
            }
            ans = Math.max(ans, r - l);
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2730().new Solution().longestSemiRepetitiveSubstring("123");
    }

}
