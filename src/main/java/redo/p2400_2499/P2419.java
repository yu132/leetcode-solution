package redo.p2400_2499;

public class P2419 {

    class Solution {
        public int longestSubarray(int[] nums) {
            int count = 0, max = 0, ans = 0;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                    ans = count = 1;
                } else if (num == max) {
                    ans = Math.max(ans, ++count);
                } else {
                    count = 0;
                }
            }
            return ans;
        }
    }

}
