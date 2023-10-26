package redo.p2500_2599;

public class P2539 {

    class Solution {
        public int countGoodSubsequences(String s) {

            int[] count = countLowercaseLetters(s);

            int max = max(count);

            int ans = 0;

            for (int i = 1; i <= max; ++i) {
                int temp = 1;
                for (int j = 0; j < 26; ++j) {
                    if (count[j] >= i) {
                        temp = multiply(temp, add(1, C_Fermat(count[j], i, MOD), MOD), MOD);
                    }
                }
                ans = minus(add(ans, temp, MOD), 1, MOD);
            }

            return ans;
        }

        // 利用费马小定理求C(n, m)
        public int C_Fermat(int n, int m, int p) {
            // C(n, m) = a / b
            long a = multiMod(n, n - m + 1, p);
            long b = multiMod(m, 1, p);
            // a / b = a * b^(p-2) [mod p]
            return (int) (a * powMod(b, p - 2, p) % p);
        }

        // = n * (n-1) * (n-2) * ... * m
        private long multiMod(int n, int m, int p) {
            long r = 1;
            for (int i = m; i <= n; i++) {
                r = r * i;
                if (r > p)
                    r %= p;
            }
            return r;
        }

        // 快速幂算法
        // a^(2x) = (a^2)^x
        private long powMod(long a, int pow, int p) { // a^pow % p 快速幂算法
            long r = 1;
            while (pow > 0) {
                if ((pow & 1) == 1) { // a^(2x+1) = a*a^(2x)
                    r = (r * a) % p;
                }
                a = a * a % p;
                pow >>= 1;
            }
            return r;
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

        //str中必须仅包含小写字符，计算每个小写字符的数量
        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }

        int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }

}
