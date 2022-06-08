package redo.p1900_1999;

public class P1922 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int countGoodNumbers(long n) {
            final int even = 5, prime = 4;

            long evenPos = (n + 1) / 2, oddPos = n / 2;

            return multiply(pow(even, evenPos, MOD), pow(prime, oddPos, MOD), MOD);
        }

        int multiply(long a, long b, int mod) {
            return (int) (((a % mod) * (b % mod)) % mod);
        }


        //模数不能求模，如果需要，要先求欧拉函数，再对欧拉函数的结果求模，见上eulerFastPow，还需要mod是一个质数
        int pow(long base, long exp, int mod) {
            long ans = 1;
            base %= mod;
            while (exp > 0) {
                if (exp % 2 != 0) {
                    ans = (ans * base) % mod;
                }
                exp >>= 1;
                base = (base * base) % mod;
            }
            return (int) ans;
        }
    }

}
