package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1342  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1342 {

    class Solution {
        public int numberOfSteps(int num) {
            int count = 0;
            while (num != 0) {
                count += (num & 1) + 1;
                num >>= 1;
            }
            return count == 0 ? 0 : count - 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.numberOfSteps(0));
        Assert.assertEquals(6, s.numberOfSteps(14));
        Assert.assertEquals(4, s.numberOfSteps(8));
        Assert.assertEquals(12, s.numberOfSteps(123));
    }

}
