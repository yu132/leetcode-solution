package redo.p2400_2499;

public class P2470 {

    class Solution {
        public int subarrayLCM(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                int g = nums[i];
                for (int j = i; j < nums.length; ++j) {
                    g = g * nums[j] / gcd(nums[j], g);
                    if (g == k) {
                        ++ans;
                    } else if (g > k) {
                        break;
                    }
                }
            }
            return ans;
        }

        public int gcd(int a, int b) {
            while (a != 0) {
                int tmp = b % a;
                b = a;
                a = tmp;
            }
            return b;
        }
    }

}
