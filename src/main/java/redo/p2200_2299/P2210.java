package redo.p2200_2299;

public class P2210 {

    class Solution {
        public int countHillValley(int[] nums) {
            int state = 0, ans = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                } else if (nums[i] > nums[i - 1]) {
                    if (state == 0) {
                        state = 1;
                    } else if (state == 1) {
                        continue;
                    } else {//state == -1
                        state = 1;
                        ++ans;
                    }
                } else {//nums[i] < nums[i - 1]
                    if (state == 0) {
                        state = -1;
                    } else if (state == -1) {
                        continue;
                    } else {//state == 1
                        state = -1;
                        ++ans;
                    }
                }
            }
            return ans;
        }
    }

}
