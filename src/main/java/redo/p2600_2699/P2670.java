package redo.p2600_2699;

import java.util.HashSet;

public class P2670 {

    class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; ++i) {
                set.add(nums[i]);
                left[i] = set.size();
            }
            set.clear();
            for (int i = nums.length - 1; i >= 0; --i) {
                set.add(nums[i]);
                right[i] = set.size();
            }
            int[] ans = new int[nums.length];
            ans[nums.length - 1] = left[nums.length - 1];
            for (int i = 0; i < nums.length - 1; ++i) {
                ans[i] = left[i] - right[i + 1];
            }
            return ans;
        }
    }
}
