package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1015  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1015 {

    class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0 || K % 5 == 0) {
                return -1;
            }
            int i = 1;
            for (int n = 1; n % K != 0; ++i) {
                n = (n % K) * 10 + 1;
            }
            return i;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.smallestRepunitDivByK(1));
        Assert.assertEquals(-1, s.smallestRepunitDivByK(2));
        Assert.assertEquals(3, s.smallestRepunitDivByK(3));
    }

}
