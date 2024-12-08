package redo.p2600_2699;

public class P2609 {

    class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int ans = 0;
            int c0 = 0;
            int c1 = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '0') {
                    if (c1 != 0) {
                        ans = Math.max(ans, Math.min(c0, c1));
                        c0 = 1;
                        c1 = 0;
                    } else {
                        ++c0;
                    }
                } else {
                    ++c1;
                }
            }
            ans = Math.max(ans, Math.min(c0, c1));
            return ans * 2;
        }
    }

}
