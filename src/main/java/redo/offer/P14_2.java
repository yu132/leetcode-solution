package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P14_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P14_2 {

    class Solution {

        static final int MOD = 1000000007;

        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            switch (n % 3) {
                case 0:
                    return (int)fastPow(3, n / 3, MOD);
                case 1:
                    return (int)((fastPow(3, n / 3 - 1, MOD) * 4) % MOD);
                case 2:
                    return (int)((fastPow(3, n / 3, MOD) * 2) % MOD);
            }
            throw new RuntimeException("unreachable");
        }

        long fastPow(long base, int exp, int mod) {
            long pow = 1;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    pow = (pow * base) % mod;
                }
                exp >>= 1;
                base = (base * base) % mod;
            }
            return pow;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.cuttingRope(2));
        Assert.assertEquals(36, s.cuttingRope(10));
        Assert.assertEquals(965709895, s.cuttingRope(999));
        Assert.assertEquals(620946522, s.cuttingRope(1000));
    }

}
