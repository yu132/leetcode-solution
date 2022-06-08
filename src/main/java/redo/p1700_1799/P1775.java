package redo.p1700_1799;

import java.util.Arrays;

public class P1775 {

    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int sum1 = sum(nums1), sum2 = sum(nums2);

            int ans = 0, diff = sum1 - sum2;

            if (diff == 0) {
                return 0;
            } else if (diff > 0) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            } else {
                diff = -diff;
            }

            for (int i = 0, j = nums2.length - 1, count = 0; i < nums1.length || j >= 0; ) {
                if (i < nums1.length && 6 - nums1[i] >= nums2[j] - 1) {
                    diff -= 6 - nums1[i];
                    ++i;
                } else {
                    diff -= nums2[j] - 1;
                    --j;
                }
                ++count;
                if (diff <= 0) {
                    return count;
                }
            }

            return -1;
        }

        int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

}
