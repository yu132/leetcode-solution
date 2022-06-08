package redo.p2000_2099;

public class P2091 {

    class Solution {
        public int minimumDeletions(int[] nums) {
            int n = nums.length;
            int[] indexes = minMaxIndex(nums, 0, n);
            int low = Math.min(indexes[0], indexes[1]), high = Math.max(indexes[0], indexes[1]);
            return Math.min(n - low, Math.min(high + 1, n - high + low + 1));
        }

        int[] minMaxIndex(int[] nums, int start, int end) {
            int max = nums[start], maxIndex = start;
            int min = nums[start], minIndex = start;
            for (int i = start + 1; i < end; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                } else if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            return new int[]{minIndex, maxIndex};
        }
    }

}
