package redo.Util.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: BigNumMod  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class BigNumMod {

    public static int add(long a, long b, int mod) {
        return (int)((a % mod + b % mod) % mod);
    }

    public static int minus(long a, long b, int mod) {// a > b
        return (int)((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
    }

    public static int multiply(long a, long b, int mod) {
        return (int)(((a % mod) * (b % mod)) % mod);
    }

    // 成立的前提是a能整除b
    public static int divide(long a, long b, int mod) {
        return multiply(a, pow(b, mod - 2, mod), mod) % mod;
    }

    public static int eulerFastPow(long base, long exp, int mod) {
        long eulerNumber = eulerFunction(mod);
        exp = exp % eulerNumber + eulerNumber;
        return pow(base, exp, mod);
    }

    public static int pow(long base, long exp, int mod) {
        long ans = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 != 0) {
                ans = (ans * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return (int)ans;
    }

    public static long eulerFunction(long n) {
        long eulerNumbers = n;
        for (long i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                eulerNumbers = eulerNumbers / i * (i - 1);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            eulerNumbers = eulerNumbers / n * (n - 1);
        }
        return eulerNumbers;
    }

    @Test
    public void test() {
        assertEquals((123 + 5567) % 29, add(123, 5567, 29));
        assertEquals((30 - 28) % 29, minus(30, 28, 29));
        assertEquals((1953 * 6942) % 29, multiply(1953, 6942, 29));
        assertEquals((300 / 100) % 29, divide(300, 100, 29));
        // assertEquals((301 / 100) % 29, divide(301, 100, 29));
    }

}
