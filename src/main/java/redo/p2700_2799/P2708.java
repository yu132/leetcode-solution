package redo.p2700_2799;

import java.util.Arrays;

public class P2708 {

    class Solution {
        public long maxStrength(int[] nums) {
            Arrays.sort(nums);
            int lastNeg = 0;
            long ans = 1;
            int count = 0;
            int count0 = 0;
            for (int num : nums) {
                if (num < 0) {
                    ans *= num;
                    lastNeg = num;
                    ++count;
                } else if (num > 0) {
                    ans *= num;
                    ++count;
                } else {
                    ++count0;
                }
            }
            if (ans < 0) {
                ans /= lastNeg;
                --count;
            }
            if (ans == 1 && count == 0) {
                if (count0 > 0) {
                    return 0;
                } else {
                    return lastNeg;
                }
            }
            return ans;
        }
    }

}
