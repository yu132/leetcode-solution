package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1551  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1551 {

    /*
     * 1,3,5
     * 1,3,5,7
     * 1,3,5,7,9 n=5
     * 1,3,5,7,9,11 n=6
     */

    class Solution {
        public int minOperations(int n) {
            if (n % 2 == 0) {
                return getSum(1, n / 2, 2);
            } else {
                return getSum(2, n / 2, 2);
            }
        }

        public int getSum(int a0, int n, int d) {
            return a0 * n + d * (n * n - n) / 2;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minOperations(3));
        Assert.assertEquals(9, s.minOperations(6));
        Assert.assertEquals(20843790, s.minOperations(9131));
    }


}
