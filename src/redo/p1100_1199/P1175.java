package redo.p1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1175  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1175 {


    class Solution {

        private final static int MOD = 1000000007;

        public int numPrimeArrangements(int n) {
            int primeNum = countPrimes(n);
            return (int)((long)factorial(primeNum, MOD) * factorial(n - primeNum, MOD) % MOD);
        }

        public int factorial(int num, int mod) {
            long n = 1;
            for (int i = 2; i <= num; ++i) {
                n *= i;
                n %= mod;
            }
            return (int)n;
        }

        public int countPrimes(int n) {
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
            return primes.size();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numPrimeArrangements(2));
        Assert.assertEquals(12, s.numPrimeArrangements(5));
        Assert.assertEquals(682289015, s.numPrimeArrangements(100));
    }

}
