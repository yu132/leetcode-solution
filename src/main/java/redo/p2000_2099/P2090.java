package redo.p2000_2099;

import java.util.Arrays;

public class P2090 {

    class Solution {
        public int[] getAverages(int[] nums, int k) {

            int n = nums.length;
            int[] ans = new int[n];

            if (2 * k >= nums.length) {
                Arrays.fill(ans, -1);
                return ans;
            }

            int count = 2 * k + 1;

            long sum = sum(nums, 0, count);
            ans[k] = (int) (sum / count);
            for (int i = 0; i < k; ++i) {
                ans[i] = ans[n - i - 1] = -1;
            }

            for (int i = k + 1; i < n - k; ++i) {
                sum += nums[i + k] - nums[i - k - 1];
                ans[i] = (int) (sum / count);
            }

            return ans;
        }

        long sum(int[] nums, int start, int end) {
            long sum = 0;
            for (int i = start; i < end; ++i) {
                sum += nums[i];
            }
            return sum;
        }
    }

}
