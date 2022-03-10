package redo.p2000_2099;

public class P2078 {

    class Solution {
        public int maxDistance(int[] colors) {

            int n = colors.length;

            if (colors[0] != colors[n - 1]) {
                return n - 1;
            }

            int ans = 0;

            for (int i = 1; i < n - 1; ++i) {
                if (colors[i] != colors[0]) {
                    ans = Math.max(Math.max(n - 1 - i, i), ans);
                }
            }

            return ans;
        }
    }

}
