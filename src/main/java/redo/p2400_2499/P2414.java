package redo.p2400_2499;

public class P2414 {

    class Solution {
        public int longestContinuousSubstring(String s) {
            int ans = 1;
            int cur = 1;
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == s.charAt(i - 1) + 1) {
                    ++cur;
                    ans = Math.max(ans, cur);
                } else {
                    cur = 1;
                }
            }
            return ans;
        }
    }

}
