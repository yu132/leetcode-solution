package redo.p2600_2699;

import java.util.Arrays;

public class P2679 {

    class Solution {
        public int matrixSum(int[][] nums) {
            int m = nums.length, n = nums[0].length;
            for (int i = 0; i < m; ++i) {
                Arrays.sort(nums[i]);
            }
            int ans = 0;
            for (int j = 0; j < n; ++j) {
                int max = 0;
                for (int i = 0; i < m; ++i) {
                    max = Math.max(max, nums[i][j]);
                }
                ans += max;
            }
            return ans;
        }
    }

}
