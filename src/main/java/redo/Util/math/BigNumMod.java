package redo.Util.math;

/**
 * @author 余定邦
 * @ClassName: BigNumMod
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月11日
 */
public class BigNumMod {

    public final static int MOD = 1_000_000_007;

    int add(long a, long b) {
        return (int) ((a % MOD + b % MOD) % MOD);
    }

    int minus(long a, long b) {// a > b
        return (int) ((a % MOD - b % MOD + MOD) % MOD);// 加mod是为了防止为负数
    }

    int multiply(long a, long b) {
        return (int) (((a % MOD) * (b % MOD)) % MOD);
    }

    // 成立的前提是a能整除b
    int divide(long a, long b) {
        return multiply(a, pow(b, MOD - 2, MOD), MOD) % MOD;
    }

    int add(long a, long b, int mod) {
        return (int) ((a % mod + b % mod) % mod);
    }

    int minus(long a, long b, int mod) {// a > b
        return (int) ((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
    }

    int multiply(long a, long b, int mod) {
        return (int) (((a % mod) * (b % mod)) % mod);
    }

    // 成立的前提是a能整除b
    int divide(long a, long b, int mod) {
        return multiply(a, pow(b, mod - 2, mod), mod) % mod;
    }

    //需要base和mod互质
    int eulerFastPow(long base, long exp, int mod) {
        long eulerNumber = eulerFunction(mod);
        exp = exp % eulerNumber;
        return pow(base, exp, mod);
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

    long eulerFunction(long n) {
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

    // @Test
    // public void test() {
    // assertEquals((123 + 5567) % 29, add(123, 5567, 29));
    // assertEquals((30 - 28) % 29, minus(30, 28, 29));
    // assertEquals((1953 * 6942) % 29, multiply(1953, 6942, 29));
    // assertEquals((300 / 100) % 29, divide(300, 100, 29));
    // // assertEquals((301 / 100) % 29, divide(301, 100, 29));
    // }

}
