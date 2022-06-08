package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1486  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1486 {

    class Solution {
        public int xorOperation(int n, int start) {
            int num = 0;
            for (int i = start + 2 * (n - 1); i >= start; i -= 2) {
                num ^= i;
            }
            return num;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(8, s.xorOperation(5, 0));
        Assert.assertEquals(8, s.xorOperation(4, 3));
        Assert.assertEquals(7, s.xorOperation(1, 7));
        Assert.assertEquals(2, s.xorOperation(10, 5));
    }

}
