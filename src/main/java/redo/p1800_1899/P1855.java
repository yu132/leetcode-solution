package redo.p1800_1899;

public class P1855 {

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int ans = 0;
            for (int i = 0, j = -1; i < nums1.length; ++i) {
                while (j < nums2.length - 1 && nums2[j + 1] >= nums1[i]) {
                    ++j;
                }
                ans = Math.max(ans, j - i);
            }
            return ans;
        }
    }

}
