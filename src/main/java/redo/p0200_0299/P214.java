package redo.p0200_0299;

import java.util.LinkedList;

public class P214 {

    class Solution {
        public String shortestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            RollingLowerStrHashUtil left = new RollingLowerStrHashUtil(),
                    right = new RollingLowerStrHashUtil();
            right.appendLast('a');

            // i 即为中心元素
            int max1 = 0;
            for (int i = 1, r = 2; r < s.length(); ++i) {
                left.appendLast(s.charAt(i - 1));
                right.removeLast();
                while (r < s.length() && right.list.size() < left.list.size()) {
                    right.appendFirst(s.charAt(r++));
                }
                if (left.hash == right.hash) {
                    max1 = i;
                }
            }

            left = new RollingLowerStrHashUtil();
            right = new RollingLowerStrHashUtil();
            right.appendLast('a');

            // i 即为right last
            int max2 = -1;
            for (int i = 1, r = 1; r < s.length(); ++i) {
                left.appendLast(s.charAt(i - 1));
                right.removeLast();
                while (r < s.length() && right.list.size() < left.list.size()) {
                    right.appendFirst(s.charAt(r++));
                }
                if (left.hash == right.hash) {
                    max2 = i;
                }
            }
            if (max1 >= max2) {
                return new StringBuilder(s.substring(max1 * 2 + 1)).reverse() + s;
            } else {
                return new StringBuilder(s.substring(max2 * 2)).reverse() + s;
            }
        }

        class RollingLowerStrHashUtil {
            LinkedList<Character> list = new LinkedList<>();
            long base = 27;
            long hash = 0;

            public char removeLast() {
                char ch = list.removeLast();
                hash = minus(hash, multiply(ch - 'a' + 1, pow(base, list.size())));
                return ch;
            }

            public void appendFirst(char ch) {
                list.addFirst(ch);
                hash = add(multiply(hash, base), ch - 'a' + 1);
            }

            public void appendLast(char ch) {
                hash = add(hash, multiply(ch - 'a' + 1, pow(base, list.size())));
                list.addLast(ch);
            }

            long getHash() {
                return hash;
            }
        }

        public final static int MOD = 1_000_000_007;

        //模数不能求模，如果需要，要先求欧拉函数，再对欧拉函数的结果求模，见上eulerFastPow，还需要mod是一个质数
        private int pow(long base, long exp) {
            long ans = 1;
            base %= MOD;
            while (exp > 0) {
                if (exp % 2 != 0) {
                    ans = (ans * base) % MOD;
                }
                exp >>= 1;
                base = (base * base) % MOD;
            }
            return (int) ans;
        }

        private int add(long a, long b) {
            return (int) ((a % MOD + b % MOD) % MOD);
        }

        private int minus(long a, long b) {// a > b
            return (int) ((a % MOD - b % MOD + MOD) % MOD);// 加mod是为了防止为负数
        }

        private int multiply(long a, long b) {
            return (int) (((a % MOD) * (b % MOD)) % MOD);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P214().new Solution().shortestPalindrome("aaaaa"));
    }
}
