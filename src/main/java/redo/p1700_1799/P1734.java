package redo.p1700_1799;

public class P1734 {

    class Solution {
        public int[] decode(int[] encoded) {

            int n = encoded.length + 1;

            int val = 0;

            for (int i = 1; i <= n; ++i) {
                val ^= i;
            }

            for (int i = encoded.length - 1; i >= 0; i -= 2) {
                val ^= encoded[i];
            }

            int[] ans = new int[n];
            ans[0] = val;

            for (int i = 1; i < n; ++i) {
                ans[i] = ans[i - 1] ^ encoded[i - 1];
            }

            return ans;
        }
    }

}
