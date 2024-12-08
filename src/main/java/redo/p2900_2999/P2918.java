package redo.p2900_2999;

public class P2918 {

    class Solution {
        public long minSum(int[] nums1, int[] nums2) {
            long sum1 = 0;
            int zero1 = 0;
            long sum2 = 0;
            int zero2 = 0;
            for (int num1 : nums1) {
                if (0 == num1) {
                    ++zero1;
                } else {
                    sum1 += num1;
                }
            }
            for (int num2 : nums2) {
                if (0 == num2) {
                    ++zero2;
                } else {
                    sum2 += num2;
                }
            }
            if (zero1 == 0 && sum1 < sum2 + zero2
                    || zero2 == 0 && sum2 < sum1 + zero1) {
                return -1;
            }
            return Math.max(sum1 + zero1, sum2 + zero2);
        }
    }

}
