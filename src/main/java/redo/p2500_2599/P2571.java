package redo.p2500_2599;

public class P2571 {

    class Solution {
        public int minOperations(int n) {
            int ans = 1;
            while ((n & (n - 1)) != 0) {
                int lowbit = n & -n;
                if ((n & (lowbit << 1)) != 0) {
                    n += lowbit;
                } else {
                    n -= lowbit;
                }
                ++ans;
            }
            return ans;
        }
    }

}
