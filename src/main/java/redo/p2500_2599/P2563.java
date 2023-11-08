package redo.p2500_2599;

import java.util.Arrays;

public class P2563 {

    class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long ans = 0;
            int left = nums.length - 1, right = nums.length - 1;

            for (int i = 0; i < nums.length; ++i) {
                while (left >= 0 && nums[i] + nums[left] >= lower) {
                    --left;
                }
                if (left != nums.length - 1) {
                    ++left;
                }
                while (right >= 0 && nums[i] + nums[right] > upper) {
                    --right;
                }
                ans += Math.max(right - left + 1, 0) - ((left <= i && i <= right) ? 1 : 0);
                if (left == right) {
                    if (nums[i] + nums[left] < lower || nums[i] + nums[left] > upper) {
                        ans -= 1;
                    }
                }
            }

            return ans / 2;
        }
    }

    public static void main(String[] args) {
        long a = new P2563().new Solution().countFairPairs(new int[]{-1, -1, 0, 0}, 1, 1);
        System.out.println(a);
    }
}
