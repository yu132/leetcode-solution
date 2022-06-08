package redo.p1800_1899;

import java.util.TreeSet;

public class P1818 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

            int n = nums1.length;

            long sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += Math.abs(nums1[i] - nums2[i]);
            }

            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums1) {
                set.add(num);
            }

            long ans = sum;

            for (int i = 0; i < n; ++i) {
                Integer next = set.ceiling(nums2[i]),
                        prev = set.floor(nums2[i]);
                int diff = Math.min(diff(next, nums2[i]), diff(prev, nums2[i]));
                ans = Math.min(ans, sum - Math.abs(nums1[i] - nums2[i]) + diff);
            }

            return (int) (ans % MOD);
        }

        public int diff(Integer x, int val) {
            if (x == null) {
                return Integer.MAX_VALUE;
            }
            return Math.abs(x - val);
        }
    }

}
