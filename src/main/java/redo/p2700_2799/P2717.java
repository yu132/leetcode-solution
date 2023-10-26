package redo.p2700_2799;

public class P2717 {

    class Solution {
        public int semiOrderedPermutation(int[] nums) {
            int index1 = -1, index2 = -1;

            for (int i = 0; i < nums.length; ++i) {
                if (1 == nums[i]) {
                    index1 = i;
                } else if (nums.length == nums[i]) {
                    index2 = i;
                }
            }

            int ans = index1 + nums.length - index2 - 1;

            if (ans >= nums.length) {
                return ans - 1;
            } else {
                return ans;
            }
        }
    }

}
