package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1281  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1281 {

    class Solution {
        public int subtractProductAndSum(int n) {
            int product = 1, sum = 0, N = n;
            while (N != 0) {
                product *= N % 10;
                sum += N % 10;
                N /= 10;
            }
            return product - sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(15, s.subtractProductAndSum(234));
        Assert.assertEquals(21, s.subtractProductAndSum(4421));
    }

}
