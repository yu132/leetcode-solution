package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1492  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1492 {

    class Solution {
        public int kthFactor(int n, int k) {
            if (k > n) {
                return -1;
            }

            for (int i = 1; i <= n; ++i) {
                if (n % i == 0) {
                    --k;
                    if (k == 0) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.kthFactor(12, 3));
        Assert.assertEquals(7, s.kthFactor(7, 2));
        Assert.assertEquals(-1, s.kthFactor(4, 4));
        Assert.assertEquals(1, s.kthFactor(1, 1));
    }

}
