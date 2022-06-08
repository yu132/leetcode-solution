package redo.p1900_1999;

public class P1969 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int minNonZeroProduct(int p) {

            /*
             * _1 : 2^(p-1)
             * _2 : 2^p = _1 * 2
             * _3 : 2^p - 1 = _2 - 1
             * _4 : 2^p - 2 = _2 - 2
             * _5 : 2^(p-1) - 1 = _1 - 1
             * _6 : (2^p - 2) ^ (2^(p-1) - 1) = _4 ^ _5
             * _7 : (2^p - 1) * 2^p - 2) ^ (2^(p-1) - 1) = _3 * _6
             */

            long _1 = (long) Math.pow(2, p - 1);
            int _2 = multiply(_1, 2, MOD);
            int _3 = minus(_2, 1, MOD), _4 = minus(_2, 2, MOD);
            long _5 = _1 - 1;
            int _6 = pow(_4, _5, MOD);
            int _7 = multiply(_3, _6, MOD);
            return _7;
        }

        int minus(long a, long b, int mod) {// a > b
            return (int) ((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
        }

        int multiply(long a, long b, int mod) {
            return (int) (((a % mod) * (b % mod)) % mod);
        }

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
