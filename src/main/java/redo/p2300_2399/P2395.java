package redo.p2300_2399;

import java.util.HashSet;

public class P2395 {

    class Solution {
        public boolean findSubarrays(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < nums.length; ++i) {
                if (set.contains(nums[i] + nums[i - 1])) {
                    return true;
                }
                set.add(nums[i] + nums[i - 1]);
            }
            return false;
        }
    }

}
