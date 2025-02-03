package redo.p2900_2999;

import redo.testUtil.Arrs;

public class P2962 {

    class Solution {
        public long countSubarrays(int[] nums, int k) {

            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }

            int countMax = 0;

            long ans = 0;

            outer:
            for (int left = 0, right = 0; ; ++left) {
                while (countMax < k) {
                    if (right == nums.length) {
                        break outer;
                    }
                    if (nums[right] == max) {
                        ++countMax;
                    }
                    ++right;
                }
                ans += nums.length - right + 1;
                if (nums[left] == max) {
                    --countMax;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2962().new Solution().countSubarrays(Arrs.build("[1,3,2,3,3]"), 2);
    }
}
