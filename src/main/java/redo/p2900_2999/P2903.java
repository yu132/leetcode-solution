package redo.p2900_2999;

public class P2903 {

    class Solution {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            for (int i = 0; i < nums.length - indexDifference; ++i) {
                for (int j = i + indexDifference; j < nums.length; ++j) {
                    if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }

}
