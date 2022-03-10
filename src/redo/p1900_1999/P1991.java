package redo.p1900_1999;

public class P1991 {

    class Solution {
        public int findMiddleIndex(int[] nums) {
            int sum = sum(nums), left = 0;
            if (sum - nums[0] == 0) {
                return 0;
            }
            for (int i = 1; i < nums.length; ++i) {
                left += nums[i - 1];
                if (sum - left - nums[i] == left) {
                    return i;
                }
            }
            return -1;
        }

        int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

}
