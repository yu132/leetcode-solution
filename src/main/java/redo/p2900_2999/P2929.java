package redo.p2900_2999;

public class P2929 {

    class Solution {
        public long distributeCandies(int n, int limit) {
            long ans = 0;
            if (n > limit * 3) {
                return 0;
            }
            for (int i = Math.max(0, n - 2 * limit); i <= Math.min(n, limit); ++i) {
                int sum2 = n - i;
                ans += Math.min(sum2, limit) - Math.max(0, sum2 - limit) + 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2929().new Solution().distributeCandies(1, 3);
    }

}
