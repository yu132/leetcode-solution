package redo.p2900_2999;

import java.util.HashSet;

public class P2996 {

    class Solution {
        public int missingInteger(int[] nums) {
            int base = nums[0];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == nums[i - 1] + 1) {
                    base += nums[i];
                } else {
                    break;
                }
            }
            for (int num : nums) {
                set.add(num);
            }
            for (int i = base; ; ++i) {
                if (!set.contains(i)) {
                    return i;
                }
            }
        }
    }

}
