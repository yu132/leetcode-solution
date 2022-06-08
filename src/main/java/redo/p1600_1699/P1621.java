package redo.p1600_1699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1621  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1621 {

    class Solution {
        public int numberOfSets(int n, int k) {
            if (n <= k) {
                return 0;
            }
            return combinationNumber(n + k - 1, 2 * k, 1000000007);
        }

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
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.numberOfSets(1, 1));
        Assert.assertEquals(1, s.numberOfSets(2, 1));
        Assert.assertEquals(3, s.numberOfSets(3, 1));
        Assert.assertEquals(6, s.numberOfSets(4, 1));
        Assert.assertEquals(5, s.numberOfSets(4, 2));
        Assert.assertEquals(3, s.numberOfSets(3, 1));
        Assert.assertEquals(796297179, s.numberOfSets(30, 7));
        Assert.assertEquals(7, s.numberOfSets(5, 3));
        Assert.assertEquals(1, s.numberOfSets(3, 2));
    }

}
