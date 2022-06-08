package redo.p2200_2299;

public class P2239 {

    class Solution {
        public int findClosestNumber(int[] nums) {

            int ans = Integer.MAX_VALUE;

            for (int num : nums) {
                if (Math.abs(num) < Math.abs(ans)) {
                    ans = num;
                } else if (Math.abs(num) == Math.abs(ans)) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }
    }

}
