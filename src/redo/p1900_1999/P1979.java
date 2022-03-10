package redo.p1900_1999;

public class P1979 {

    class Solution {
        public int findGCD(int[] nums) {
            int[] minAndMax = findMinAndMax(nums);
            return gcd(minAndMax[0], minAndMax[1]);
        }

        public int[] findMinAndMax(int... nums) {
            int max = nums[0], min = nums[0];

            for (int num : nums) {
                if (num < min) {
                    min = num;
                } else if (num > max) {
                    max = num;
                }
            }
            return new int[]{min, max};
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }
    }

}
