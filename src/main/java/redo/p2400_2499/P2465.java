package redo.p2400_2499;

import java.util.Arrays;

public class P2465 {
    class Solution {
        public int distinctAverages(int[] nums) {
            boolean[] arr = new boolean[201];
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length / 2; ++i) {
                if (!arr[nums[i] + nums[nums.length - i - 1]]) {
                    ++ans;
                    arr[nums[i] + nums[nums.length - i - 1]] = true;
                }
            }
            return ans;
        }


    }

}
