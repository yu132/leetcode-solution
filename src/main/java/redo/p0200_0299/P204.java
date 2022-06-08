package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P204  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P204 {

    class Solution {
        public int countPrimes(int n) {
            boolean[] sieve = new boolean[n];
            for (int i = 2; i <= n / 2; ++i) {
                for (int j = 2; j <= i; ++j) {
                    if (i * j >= n) {
                        break;
                    }
                    sieve[i * j] = true;
                }
            }
            int sum = 0;
            for (int i = 2; i < sieve.length; ++i) {
                if (!sieve[i]) {
                    ++sum;
                }
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.countPrimes(10));
        assertEquals(0, s.countPrimes(2));
        assertEquals(0, s.countPrimes(1));
        assertEquals(0, s.countPrimes(0));
        assertEquals(1474, s.countPrimes(12345));
    }

}
