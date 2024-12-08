package redo.p2600_2699;

public class P2614 {

    class Solution {
        public int diagonalPrime(int[][] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (isPrime(nums[i][i])) {
                    ans = Math.max(ans, nums[i][i]);
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                if (isPrime(nums[i][nums.length - i - 1])) {
                    ans = Math.max(ans, nums[i][nums.length - i - 1]);
                }
            }
            return ans;
        }

        public boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int i = 2; i * i <= n; ++i) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
