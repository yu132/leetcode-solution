package redo.p3000_3099;

public class P3038 {

    class Solution {
        public int maxOperations(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            int c = nums[0] + nums[1];
            int count = 1;
            for (int i = 2; i < nums.length - 1; i += 2) {
                if (nums[i] + nums[i + 1] == c) {
                    ++count;
                } else {
                    break;
                }
            }
            return count;
        }
    }

}
