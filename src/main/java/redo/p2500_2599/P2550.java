package redo.p2500_2599;

public class P2550 {

    class Solution {
        public int monkeyMove(int n) {
            return minus(pow(2, n, MOD), 2, MOD);
        }

        public final static int MOD = 1_000_000_007;

        int minus(long a, long b, int mod) {// a > b
            return (int) ((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
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
