package redo.p2400_2499;

public class P2427 {

    class Solution {
        public int commonFactors(int a, int b) {
            int ans = 0;
            for (int i = 1; i <= Math.min(a, b); ++i) {
                if (a % i == 0 && b % i == 0) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
