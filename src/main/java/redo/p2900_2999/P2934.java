package redo.p2900_2999;

import redo.testUtil.Arrs;

public class P2934 {

    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int ans1 = 0, ans2 = 1;
            int m1 = nums1[n - 1], m2 = nums2[n - 1];
            boolean no = false;
            for (int i = n - 2; i >= 0; --i) {
                if (nums1[i] <= m1 && nums2[i] <= m2) {
                    continue;
                }
                if (nums1[i] <= m2 && nums2[i] <= m1) {
                    ++ans1;
                    continue;
                }
                no = true;
                break;
            }
            if (no) {
                return -1;
            }
            m2 = nums1[n - 1];
            m1 = nums2[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                if (nums1[i] <= m1 && nums2[i] <= m2) {
                    continue;
                }
                if (nums1[i] <= m2 && nums2[i] <= m1) {
                    ++ans2;
                    continue;
                }
                break;
            }
            return Math.min(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        new P2934().new Solution().minOperations(Arrs.build("[14,28,68,68,65,67,68]"), Arrs.build("[68,68,49,64,68,67,67]"));
    }
}
