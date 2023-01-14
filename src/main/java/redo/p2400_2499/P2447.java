package redo.p2400_2499;

public class P2447 {

    class Solution {
        public int subarrayGCD(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                int g = 0;
                for (int j = i; j < nums.length; ++j) {
                    g = gcd(nums[j], g);
                    if (g % k != 0) {
                        break;
                    }
                    if (g == k) {
                        ++ans;
                    }
                }
            }
            return ans;
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
