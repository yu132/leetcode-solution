package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P16  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P16 {

    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            return fastPow(x, N);
        }

        public double fastPow(double base, long exp) {
            double ans = 1;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    ans *= base;
                }
                exp >>= 1;
                base *= base;
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1024.0, s.myPow(2.0, 10), 0.00001);
        Assert.assertEquals(9.261, s.myPow(2.1, 3), 0.00001);
        Assert.assertEquals(0.25, s.myPow(2.0, -2), 0.00001);
        Assert.assertEquals(0.0, s.myPow(2.0, Integer.MIN_VALUE), 0.00001);

    }

}
