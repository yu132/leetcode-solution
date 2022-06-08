package redo.Util.math;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: CombinationNumber  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class CombinationNumber {

    // n > m
    public int combinationNumber(int n, int m, int mod) {
        List<Integer> primes = getPrimes(n);
        long ans = 1;
        for (int prime : primes) {
            int pow = getPrimerPow(n, prime) - getPrimerPow(m, prime) - getPrimerPow(n - m, prime);
            for (int j = 0; j < pow; ++j) {
                ans *= prime;
                ans %= mod;
            }
        }
        return (int)ans;
    }

    // 计算num的阶乘中包含prime的次数
    private int getPrimerPow(int num, int prime) {
        int pow = 0;
        while (num >= prime) {
            int temp = num / prime;
            pow += temp;
            num = temp;
        }
        return pow;
    }

    private List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n + 1];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i <= n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) <= n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes;
    }

    // 利用费马小定理求C(n, m)
    public int C_Fermat(int n, int m, int p) {
        // C(n, m) = a / b
        long a = multiMod(n, n - m + 1, p);
        long b = multiMod(m, 1, p);
        // a / b = a * b^(p-2) [mod p]
        return (int)(a * powMod(b, p - 2, p) % p);
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

    @Test
    public void test() {
        assertEquals(45449810, combinationNumber(32003, 123, 1000000007));
        assertEquals(45449810, C_Fermat(32003, 123, 1000000007));
        assertEquals(combinationNumber(1234, 1234, 1000000007), C_Fermat(1234, 1234, 1000000007));
    }


}
