package redo.p0700_0799;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P762  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P762 {

    static//

    class Solution {

        private final static Set<Integer> PRIMES = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));

        public int countPrimeSetBits(int L, int R) {
            int count = 0;
            for (int i = L; i <= R; ++i) {
                int num1 = 0, n = i;
                while (n != 0) {
                    n &= n - 1;
                    ++num1;
                }
                if (PRIMES.contains(num1)) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.countPrimeSetBits(6, 10));
        Assert.assertEquals(5, s.countPrimeSetBits(10, 15));
        Assert.assertEquals(4252, s.countPrimeSetBits(1, 10000));
    }

}
