package redo.p2500_2599;

public class P2533 {

    class Solution {
        public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
            int[] dp1 = new int[maxLength + 1];
            int[] dp0 = new int[maxLength + 1];
            int[] sum1 = new int[zeroGroup];
            int[] sum0 = new int[oneGroup];
            dp1[0] = 1;
            dp0[0] = 1;
            sum1[0] = 1;
            sum0[0] = 1;
            for (int i = 1; i <= maxLength; ++i) {

                dp1[i] = sum0[i % oneGroup];
                dp0[i] = sum1[i % zeroGroup];
                sum1[i % zeroGroup] = add(sum1[i % zeroGroup], dp1[i], MOD);
                sum0[i % oneGroup] = add(sum0[i % oneGroup], dp0[i], MOD);

            }

            int ans = 0;

            for (int i = minLength; i <= maxLength; ++i) {
                ans = add(ans, dp0[i], MOD);
                ans = add(ans, dp1[i], MOD);
            }

            return ans;
        }

        public final static int MOD = 1_000_000_007;

        int add(long a, long b, int mod) {
            return (int) ((a % mod + b % mod) % mod);
        }

        int minus(long a, long b, int mod) {// a > b
            return (int) ((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
        }

        int multiply(long a, long b, int mod) {
            return (int) (((a % mod) * (b % mod)) % mod);
        }
    }

    public static void main(String[] args) {
        new P2533().new Solution().goodBinaryStrings(2, 3, 1, 2);
    }

}
