package redo.p0700_0799;

public class P713 {

    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int ans = 0, product = 1;
            for (int l = 0, r = 0; l < nums.length; ++l) {
                while (r < nums.length && product * nums[r] < k) {
                    product *= nums[r];
                    ++r;
                }
                ans += Math.max(0, r - l);
                if (r > l) {
                    product /= nums[l];
                } else {
                    r = l + 1;
                    product = 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P713().new Solution().numSubarrayProductLessThanK(new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22}, 18);
    }
}
