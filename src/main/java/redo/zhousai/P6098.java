package redo.zhousai;

public class P6098 {

    class Solution {
        public long countSubarrays(int[] nums, long k) {

            long ans = 0, sum = 0;

            for (int l = 0, r = 0; l < nums.length; ++l) {
                while (r < nums.length && (sum + nums[r]) * (r + 1 - l) < k) {
                    sum += nums[r];
                    ++r;
                }
                ans += r - l;
                sum -= nums[l];
            }

            return ans;
        }
    }

}
