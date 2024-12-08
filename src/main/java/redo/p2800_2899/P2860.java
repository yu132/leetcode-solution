package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.Collections;
import java.util.List;

public class P2860 {

    class Solution {
        public int countWays(List<Integer> nums) {
            Collections.sort(nums);
            int ans = 0;
            if (nums.get(0) > 0) {
                ++ans;
            }
            for (int i = 0; i < nums.size(); ++i) {
                if (nums.get(i) >= i + 1) {
                    continue;
                }
                if (i != nums.size() - 1 && nums.get(i + 1) <= i + 1) {
                    continue;
                }
                ++ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2860().new Solution().countWays(Arrs.buildL("[1,1]"));
    }
}
