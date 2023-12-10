package redo.Util.newcommutil;

import java.util.LinkedList;

// 滚动哈希工具类 test by P214
public class RollingStrHash {

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
