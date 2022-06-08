package redo.p1800_1899;

public class P1888 {

    class Solution {
        public int minFlips(String s) {
            int n = s.length();
            s = s + s;
            int count = 0;
            for (int i = 0; i < n; ++i) {
                if ((s.charAt(i) - '0') % 2 != i % 2) {
                    ++count;
                }
            }
            int ans = Math.min(count, n - count);
            for (int i = 0; i < n; ++i) {
                if ((s.charAt(i) - '0') % 2 != i % 2) {
                    --count;
                }
                if ((s.charAt(i + n) - '0') % 2 != (i + n) % 2) {
                    ++count;
                }
                ans = Math.min(ans, Math.min(count, n - count));
            }
            return ans;
        }
    }

}
