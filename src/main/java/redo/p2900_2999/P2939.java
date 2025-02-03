package redo.p2900_2999;

public class P2939 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int maximumXorProduct(long a, long b, int n) {
            for (int i = n - 1; i >= 0; --i) {
                if ((a & (1L << i)) == 0 && (b & (1L << i)) == 0) {
                    a |= 1L << i;
                    b |= 1L << i;
                } else if ((a & (1L << i)) != 0 && (b & (1L << i)) != 0) {
                } else {
                    if (a < b) {
                        long temp = a;
                        a = b;
                        b = temp;
                    }
                    long ta = a ^ 1L << i;
                    long tb = b ^ 1L << i;
                    if (ta > b && tb > b && ta < a && tb < a) {
                        a ^= 1L << i;
                        b ^= 1L << i;
                    }
//                    if (a > b && (a & (1L << i)) == 1) {
//                        a ^= 1L << i;
//                        b |= 1L << i;
//                    } else if (a < b && (b & (1L << i)) != 0) {
//                        a |= 1L << i;
//                        b ^= 1L << i;
//                    }
                }
            }
            return multiply(a, b);
        }

        int multiply(long a, long b) {
            return (int) (((a % MOD) * (b % MOD)) % MOD);
        }
    }

    public static void main(String[] args) {
        new P2939().new Solution().maximumXorProduct(2, 4, 4);
    }

}
