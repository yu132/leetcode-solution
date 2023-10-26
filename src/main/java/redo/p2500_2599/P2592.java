package redo.p2500_2599;

import java.util.Arrays;

public class P2592 {

    class Solution {
        public int maximizeGreatness(int[] nums) {
            Arrays.sort(nums);
            int l = 0, r = 1, ans = 0;
            for (; ; ) {
                while (r < nums.length && nums[l] == nums[r]) {
                    ++r;
                }
                if (r == nums.length) {
                    break;
                }
                ++r;
                ++l;
                ++ans;
            }
            return ans;
        }
    }

}
