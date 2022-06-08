package redo.p2000_2099;

public class P2017 {

    class Solution {
        public long gridGame(int[][] grid) {

            int n = grid[0].length;

            long[] prefix1 = prefix(grid[0]), prefix2 = prefix(grid[1]);

            long ans = Long.MAX_VALUE;

            for (int i = 0; i < n; ++i) {
                ans = Math.min(ans, Math.max(
                        sumRange(prefix1, i + 1, n), sumRange(prefix2, 0, i)));
            }

            return ans;
        }

        long sumRange(long[] prefix, int from, int to) {
            return prefix[to] - prefix[from];
        }

        // 前缀和 sum(0 to i)=prefix[i+1];
        long[] prefix(int[] nums) {
            long[] prefix = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }
    }

}
