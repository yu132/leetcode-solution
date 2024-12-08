package redo.p2600_2699;

public class P2605 {

    class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
            int ans = Integer.MAX_VALUE;
            for (int num : nums1) {
                for (int num2 : nums2) {
                    if (num == num2) {
                        ans = Math.min(ans, num);
                    } else {
                        ans = Math.min(ans, Math.min(num * 10 + num2, num2 * 10 + num));
                    }
                }
            }
            return ans;
        }
    }

}
