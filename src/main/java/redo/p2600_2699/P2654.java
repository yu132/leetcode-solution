package redo.p2600_2699;

public class P2654 {

    class Solution {
        public int minOperations(int[] nums) {
            int count = 0;
            for (int num : nums) {
                if (num == 1) {
                    ++count;
                }
            }
            if (count > 0) {
                return nums.length - count;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                int x = nums[i];
                for (int j = i + 1; j < nums.length; ++j) {
                    x = gcd(x, nums[j]);
                    if (x == 1) {
                        ans = Math.min(ans, j - i + nums.length - 1);
                        break;
                    }
                }
            }
            if (ans == Integer.MAX_VALUE) {
                return -1;
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
