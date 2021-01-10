package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1375  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1375 {

    static//

    class Solution {
        public int numTimesAllBlue(int[] light) {
            int count = 0, max = 0;
            for (int i = 0; i < light.length; ++i) {
                max = Math.max(max, light[i]);
                if (i + 1 == max) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numTimesAllBlue(new int[] {2, 1, 3, 5, 4}));
        Assert.assertEquals(2, s.numTimesAllBlue(new int[] {3, 2, 4, 1, 5}));
        Assert.assertEquals(1, s.numTimesAllBlue(new int[] {4, 1, 2, 3}));
        Assert.assertEquals(3, s.numTimesAllBlue(new int[] {2, 1, 4, 3, 6, 5}));
        Assert.assertEquals(6, s.numTimesAllBlue(new int[] {1, 2, 3, 4, 5, 6}));

    }

}
