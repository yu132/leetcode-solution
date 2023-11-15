package redo.p2500_2599;

import java.util.Arrays;

public class P2541 {

    class Solution {
        public long minOperations(int[] nums1, int[] nums2, int k) {
            if (k == 0) {
                return Arrays.equals(nums1, nums2) ? 0 : -1;
            }
            long add = 0, minus = 0;
            for (int i = 0; i < nums1.length; ++i) {
                if (nums1[i] % k != nums2[i] % k) {
                    return -1;
                }
                if (nums1[i] - nums2[i] > 0) {
                    minus += (nums1[i] - nums2[i]) / k;
                } else {
                    add += (nums2[i] - nums1[i]) / k;
                }
            }
            if (minus != add) {
                return -1;
            }
            return minus;
        }
    }

    public static void main(String[] args) {
        new P2541().new Solution().minOperations(new int[]{4, 3, 1, 4}, new int[]{1, 3, 7, 1}, 3);
    }

}
