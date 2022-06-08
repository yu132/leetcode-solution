package redo.p1800_1899;

import java.util.Arrays;

public class P1838 {

    class Solution {
        public int maxFrequency(int[] nums, int k) {

            int n = nums.length;

            Arrays.sort(nums);
            int prevIndex = n - 1;
            while (prevIndex > 0 && nums[n - 1] - nums[prevIndex - 1] <= k) {
                k -= nums[n - 1] - nums[prevIndex - 1];
                --prevIndex;
            }
            int ans = n - prevIndex;
            for (int i = n - 2; i >= 0 && prevIndex > 0; --i) {
                k += (nums[i + 1] - nums[i]) * (i + 1 - prevIndex);
                while (prevIndex > 0 && nums[i] - nums[prevIndex - 1] <= k) {
                    k -= nums[i] - nums[prevIndex - 1];
                    --prevIndex;
                }
                ans = Math.max(ans, i + 1 - prevIndex);
            }
            return ans;
        }
    }

}
