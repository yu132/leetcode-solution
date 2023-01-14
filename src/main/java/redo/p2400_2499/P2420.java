package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.List;

public class P2420 {

    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int n = nums.length;
            int[] left = new int[nums.length], right = new int[nums.length];
            right[n - 1] = n - 1;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] <= nums[i - 1]) {
                    left[i] = left[i - 1];
                } else {
                    left[i] = i;
                }
                if (nums[n - i - 1] <= nums[n - i]) {
                    right[n - i - 1] = right[n - i];
                } else {
                    right[n - i - 1] = n - i - 1;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = k; i < n - k; ++i) {
                if (left[i - 1] <= i - k && right[i + 1] >= i + k) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2420().new Solution().goodIndices(Arrs.build("[2,1,1,1,3,4,1]"), 2);
    }
}
