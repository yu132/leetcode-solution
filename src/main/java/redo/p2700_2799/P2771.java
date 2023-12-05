package redo.p2700_2799;

import redo.testUtil.Arrs;

public class P2771 {

    class Solution {
        public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
            int min = 1, max = 1, minL = 0, maxL = 0, ans = 1;

            for (int i = 0; i < nums1.length; ++i) {
                int mmin = Math.min(nums1[i], nums2[i]);
                int mmax = Math.max(nums1[i], nums2[i]);

                int tempMinL = minL, tempMaxL = maxL;

                if (mmin < min) {
                    minL = 1;
                } else if (mmin < max) {
                    minL = tempMinL + 1;
                    ans = Math.max(ans, minL);
                } else {
                    minL = Math.max(tempMinL, tempMaxL) + 1;
                }

                if (mmax < min) {
                    max = mmin;
                    maxL = 1;
                } else if (mmax < max) {
                    max = mmax;
                    maxL = tempMinL + 1;
                    ans = Math.max(ans, maxL);
                } else {
                    max = mmax;
                    maxL = Math.max(tempMinL, tempMaxL) + 1;
                    ans = Math.max(ans, maxL);
                }
                min = mmin;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P2771().new Solution().maxNonDecreasingLength(Arrs.build("[2,3,1]"), Arrs.build("[1,2,1]")));
    }

}
